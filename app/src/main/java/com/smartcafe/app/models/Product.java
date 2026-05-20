package com.smartcafe.app.models;

import com.google.firebase.firestore.PropertyName;
import java.util.List;

/**
 * Product Model - Represents a product/menu item in the cafe
 * Fields are mapped to Firestore documents
 */
public class Product {
    private String id;                      // Product ID
    private String name;                    // Product name
    private String category;                // Category name
    private double price;                   // Price in rupees
    private String description;             // Product description
    private String imageUrl;                // Product image URL
    private double rating;                  // Average rating (0-5)
    private int reviewCount;                // Number of reviews
    private boolean available;              // Availability status
    private int preparationTime;            // Preparation time in minutes
    private boolean vegetarian;             // Vegetarian/Non-vegetarian flag
    private long createdAt;                 // Creation timestamp

    /**
     * Default Constructor (Required for Firestore)
     */
    public Product() {}

    /**
     * Constructor with essential parameters
     */
    public Product(String name, String category, double price, String description) {
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.available = true;
        this.rating = 0.0;
        this.reviewCount = 0;
        this.preparationTime = 15;
        this.createdAt = System.currentTimeMillis();
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public double getPrice() { return price; }
    public void setPrice(double price) { this.price = price; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getImageUrl() { return imageUrl; }
    public void setImageUrl(String imageUrl) { this.imageUrl = imageUrl; }

    @PropertyName("rating")
    public double getRating() { return rating; }
    @PropertyName("rating")
    public void setRating(double rating) { 
        // Ensure rating is between 0 and 5
        this.rating = Math.max(0, Math.min(5, rating)); 
    }

    @PropertyName("reviewCount")
    public int getReviewCount() { return reviewCount; }
    @PropertyName("reviewCount")
    public void setReviewCount(int reviewCount) { this.reviewCount = reviewCount; }

    @PropertyName("available")
    public boolean isAvailable() { return available; }
    @PropertyName("available")
    public void setAvailable(boolean available) { this.available = available; }

    @PropertyName("preparationTime")
    public int getPreparationTime() { return preparationTime; }
    @PropertyName("preparationTime")
    public void setPreparationTime(int preparationTime) { this.preparationTime = preparationTime; }

    @PropertyName("vegetarian")
    public boolean isVegetarian() { return vegetarian; }
    @PropertyName("vegetarian")
    public void setVegetarian(boolean vegetarian) { this.vegetarian = vegetarian; }

    @PropertyName("createdAt")
    public long getCreatedAt() { return createdAt; }
    @PropertyName("createdAt")
    public void setCreatedAt(long createdAt) { this.createdAt = createdAt; }

    /**
     * Get formatted price string with currency symbol
     */
    public String getFormattedPrice() {
        return "₹" + String.format("%.2f", price);
    }

    /**
     * Get formatted rating string
     */
    public String getFormattedRating() {
        return String.format("%.1f", rating);
    }

    /**
     * Check if product is highly rated (>= 4.0)
     */
    public boolean isHighlyRated() {
        return rating >= 4.0;
    }

    /**
     * Check if product is new (created in last 7 days)
     */
    public boolean isNew() {
        long sevenDaysInMillis = 7 * 24 * 60 * 60 * 1000;
        return System.currentTimeMillis() - createdAt <= sevenDaysInMillis;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", price=" + price +
                ", rating=" + rating +
                ", available=" + available +
                '}';
    }
}
