package com.smartcafe.app.models;

import com.google.firebase.firestore.PropertyName;
import java.util.ArrayList;
import java.util.List;

/**
 * Order Model - Represents a customer order
 * Fields are mapped to Firestore documents
 */
public class Order {
    private String id;                      // Order ID
    private String userId;                  // User ID who placed the order
    private List<OrderItem> items;          // List of ordered items
    private double totalAmount;             // Total order amount
    private double tax;                     // Tax amount
    private double deliveryCharge;          // Delivery charges
    private double discountAmount;          // Discount applied
    private String status;                  // pending, preparing, ready, completed, cancelled
    private String deliveryAddress;         // Delivery address
    private String paymentMethod;           // card, cash, upi, wallet
    private String promoCode;               // Applied promo code
    private long createdAt;                 // Order creation timestamp
    private long estimatedDeliveryTime;     // Estimated delivery time
    private String specialInstructions;     // Special instructions from user

    /**
     * Inner class for OrderItem
     */
    public static class OrderItem {
        private String productId;
        private String productName;
        private double price;
        private int quantity;
        private String imageUrl;

        public OrderItem() {}

        public OrderItem(String productId, String productName, double price, int quantity) {
            this.productId = productId;
            this.productName = productName;
            this.price = price;
            this.quantity = quantity;
        }

        // Getters and Setters
        public String getProductId() { return productId; }
        public void setProductId(String productId) { this.productId = productId; }

        public String getProductName() { return productName; }
        public void setProductName(String productName) { this.productName = productName; }

        public double getPrice() { return price; }
        public void setPrice(double price) { this.price = price; }

        public int getQuantity() { return quantity; }
        public void setQuantity(int quantity) { this.quantity = quantity; }

        public String getImageUrl() { return imageUrl; }
        public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

        public double getItemTotal() {
            return price * quantity;
        }
    }

    /**
     * Default Constructor (Required for Firestore)
     */
    public Order() {
        this.items = new ArrayList<>();
    }

    /**
     * Constructor with essential parameters
     */
    public Order(String userId, String deliveryAddress) {
        this.userId = userId;
        this.deliveryAddress = deliveryAddress;
        this.items = new ArrayList<>();
        this.status = "pending";
        this.createdAt = System.currentTimeMillis();
        this.totalAmount = 0;
        this.tax = 0;
        this.deliveryCharge = 0;
        this.discountAmount = 0;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public List<OrderItem> getItems() { return items; }
    public void setItems(List<OrderItem> items) { this.items = items; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public double getTax() { return tax; }
    public void setTax(double tax) { this.tax = tax; }

    public double getDeliveryCharge() { return deliveryCharge; }
    public void setDeliveryCharge(double deliveryCharge) { this.deliveryCharge = deliveryCharge; }

    public double getDiscountAmount() { return discountAmount; }
    public void setDiscountAmount(double discountAmount) { this.discountAmount = discountAmount; }

    @PropertyName("status")
    public String getStatus() { return status; }
    @PropertyName("status")
    public void setStatus(String status) { this.status = status; }

    public String getDeliveryAddress() { return deliveryAddress; }
    public void setDeliveryAddress(String deliveryAddress) { this.deliveryAddress = deliveryAddress; }

    public String getPaymentMethod() { return paymentMethod; }
    public void setPaymentMethod(String paymentMethod) { this.paymentMethod = paymentMethod; }

    public String getPromoCode() { return promoCode; }
    public void setPromoCode(String promoCode) { this.promoCode = promoCode; }

    @PropertyName("createdAt")
    public long getCreatedAt() { return createdAt; }
    @PropertyName("createdAt")
    public void setCreatedAt(long createdAt) { this.createdAt = createdAt; }

    @PropertyName("estimatedDeliveryTime")
    public long getEstimatedDeliveryTime() { return estimatedDeliveryTime; }
    @PropertyName("estimatedDeliveryTime")
    public void setEstimatedDeliveryTime(long estimatedDeliveryTime) { this.estimatedDeliveryTime = estimatedDeliveryTime; }

    public String getSpecialInstructions() { return specialInstructions; }
    public void setSpecialInstructions(String specialInstructions) { this.specialInstructions = specialInstructions; }

    /**
     * Add item to order
     */
    public void addItem(OrderItem item) {
        if (items == null) {
            items = new ArrayList<>();
        }
        items.add(item);
    }

    /**
     * Calculate subtotal (sum of all items)
     */
    public double calculateSubtotal() {
        double subtotal = 0;
        if (items != null) {
            for (OrderItem item : items) {
                subtotal += item.getItemTotal();
            }
        }
        return subtotal;
    }

    /**
     * Calculate final total (subtotal + tax + delivery - discount)
     */
    public double calculateFinalTotal() {
        return calculateSubtotal() + tax + deliveryCharge - discountAmount;
    }

    /**
     * Check if order is completed
     */
    public boolean isCompleted() {
        return "completed".equals(status);
    }

    /**
     * Check if order is pending
     */
    public boolean isPending() {
        return "pending".equals(status);
    }

    /**
     * Check if order is cancelled
     */
    public boolean isCancelled() {
        return "cancelled".equals(status);
    }

    /**
     * Get formatted total price
     */
    public String getFormattedTotal() {
        return "₹" + String.format("%.2f", calculateFinalTotal());
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", userId='" + userId + '\'' +
                ", status='" + status + '\'' +
                ", totalAmount=" + totalAmount +
                ", itemCount=" + (items != null ? items.size() : 0) +
                '}';
    }
}
