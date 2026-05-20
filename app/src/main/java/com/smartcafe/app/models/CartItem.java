package com.smartcafe.app.models;

/**
 * CartItem Model - Represents an item in the shopping cart
 * Fields are mapped to Firestore documents
 */
public class CartItem {
    private String id;                  // Cart item ID
    private String userId;              // User ID
    private String productId;           // Product ID
    private String productName;         // Product name (cached)
    private double price;               // Product price (cached)
    private String imageUrl;            // Product image (cached)
    private int quantity;               // Item quantity
    private long addedAt;               // Timestamp when added

    /**
     * Default Constructor (Required for Firestore)
     */
    public CartItem() {}

    /**
     * Constructor with parameters
     */
    public CartItem(String userId, String productId, String productName, double price, int quantity) {
        this.userId = userId;
        this.productId = productId;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
        this.addedAt = System.currentTimeMillis();
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getProductId() { return productId; }
    public void setProductId(String productId) { this.productId = productId; }

    public String getProductName() { return productName; }
    public void setProductName(String productName) { this.productName = productName; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public long getAddedAt() { return addedAt; }
    public void setAddedAt(long addedAt) { this.addedAt = addedAt; }

    /**
     * Calculate total price for this item (price * quantity)
     */
    public double getTotalPrice() {
        return price * quantity;
    }

    @Override
    public String toString() {
        return "CartItem{" +
                "productName='" + productName + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", totalPrice=" + getTotalPrice() +
                '}';
    }
}
