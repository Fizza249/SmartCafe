package com.smartcafe.app.models;

import com.google.firebase.firestore.PropertyName;

/**
 * User Model - Represents a user in the application
 * Fields are mapped to Firestore documents
 */
public class User {
    private String uid;                     // Firebase UID
    private String email;                   // User email
    private String fullName;                // Full name
    private String phone;                   // Phone number
    private String photoUrl;                // Profile photo URL
    private String role;                    // "user" or "admin"
    private int loyaltyPoints;              // Loyalty points earned
    private long createdAt;                 // Account creation timestamp

    /**
     * Default Constructor (Required for Firestore)
     */
    public User() {}

    /**
     * Constructor with essential parameters
     */
    public User(String uid, String email, String fullName, String phone) {
        this.uid = uid;
        this.email = email;
        this.fullName = fullName;
        this.phone = phone;
        this.role = "user";
        this.loyaltyPoints = 0;
        this.createdAt = System.currentTimeMillis();
    }

    // Getters and Setters
    public String getUid() { return uid; }
    public void setUid(String uid) { this.uid = uid; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getPhotoUrl() { return photoUrl; }
    public void setPhotoUrl(String photoUrl) { this.photoUrl = photoUrl; }

    @PropertyName("role")
    public String getRole() { return role; }
    @PropertyName("role")
    public void setRole(String role) { this.role = role; }

    @PropertyName("loyaltyPoints")
    public int getLoyaltyPoints() { return loyaltyPoints; }
    @PropertyName("loyaltyPoints")
    public void setLoyaltyPoints(int loyaltyPoints) { this.loyaltyPoints = loyaltyPoints; }

    @PropertyName("createdAt")
    public long getCreatedAt() { return createdAt; }
    @PropertyName("createdAt")
    public void setCreatedAt(long createdAt) { this.createdAt = createdAt; }

    /**
     * Check if user is admin
     */
    public boolean isAdmin() {
        return "admin".equals(role);
    }

    /**
     * Add loyalty points
     */
    public void addLoyaltyPoints(int points) {
        this.loyaltyPoints += points;
    }

    /**
     * Deduct loyalty points
     */
    public void deductLoyaltyPoints(int points) {
        if (this.loyaltyPoints >= points) {
            this.loyaltyPoints -= points;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "uid='" + uid + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", role='" + role + '\'' +
                ", loyaltyPoints=" + loyaltyPoints +
                '}';
    }
}
