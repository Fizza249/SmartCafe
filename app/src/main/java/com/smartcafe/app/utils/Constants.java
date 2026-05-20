package com.smartcafe.app.utils;

/**
 * Constants - Global constants used throughout the application
 * Centralized configuration for easier maintenance
 */
public class Constants {

    // ========== Firebase Collection Names ==========
    public static final String USERS_COLLECTION = "users";
    public static final String PRODUCTS_COLLECTION = "products";
    public static final String CATEGORIES_COLLECTION = "categories";
    public static final String ORDERS_COLLECTION = "orders";
    public static final String CART_COLLECTION = "cart";
    public static final String FAVORITES_COLLECTION = "favorites";
    public static final String NOTIFICATIONS_COLLECTION = "notifications";

    // ========== User Related Constants ==========
    public static final String USER_ROLE_USER = "user";
    public static final String USER_ROLE_ADMIN = "admin";
    public static final String FIELD_UID = "uid";
    public static final String FIELD_EMAIL = "email";
    public static final String FIELD_FULL_NAME = "fullName";
    public static final String FIELD_PHONE = "phone";
    public static final String FIELD_ROLE = "role";
    public static final String FIELD_LOYALTY_POINTS = "loyaltyPoints";
    public static final String FIELD_CREATED_AT = "createdAt";

    // ========== Product Related Constants ==========
    public static final String FIELD_PRODUCT_NAME = "name";
    public static final String FIELD_PRODUCT_CATEGORY = "category";
    public static final String FIELD_PRODUCT_PRICE = "price";
    public static final String FIELD_PRODUCT_RATING = "rating";
    public static final String FIELD_PRODUCT_AVAILABLE = "available";
    public static final String FIELD_PRODUCT_IMAGE = "imageUrl";
    public static final String FIELD_PRODUCT_DESCRIPTION = "description";

    // ========== Order Related Constants ==========
    public static final String ORDER_STATUS_PENDING = "pending";
    public static final String ORDER_STATUS_PREPARING = "preparing";
    public static final String ORDER_STATUS_READY = "ready";
    public static final String ORDER_STATUS_COMPLETED = "completed";
    public static final String ORDER_STATUS_CANCELLED = "cancelled";

    public static final String[] ORDER_STATUSES = {
        ORDER_STATUS_PENDING,
        ORDER_STATUS_PREPARING,
        ORDER_STATUS_READY,
        ORDER_STATUS_COMPLETED,
        ORDER_STATUS_CANCELLED
    };

    public static final String FIELD_ORDER_TOTAL = "totalAmount";
    public static final String FIELD_ORDER_STATUS = "status";
    public static final String FIELD_ORDER_USER_ID = "userId";
    public static final String FIELD_ORDER_ITEMS = "items";

    // ========== Payment Methods ==========
    public static final String PAYMENT_METHOD_CARD = "card";
    public static final String PAYMENT_METHOD_CASH = "cash";
    public static final String PAYMENT_METHOD_UPI = "upi";
    public static final String PAYMENT_METHOD_WALLET = "wallet";

    public static final String[] PAYMENT_METHODS = {
        PAYMENT_METHOD_CARD,
        PAYMENT_METHOD_CASH,
        PAYMENT_METHOD_UPI,
        PAYMENT_METHOD_WALLET
    };

    // ========== Notification Types ==========
    public static final String NOTIFICATION_TYPE_ORDER = "order_update";
    public static final String NOTIFICATION_TYPE_PROMO = "promo";
    public static final String NOTIFICATION_TYPE_ANNOUNCEMENT = "announcement";
    public static final String NOTIFICATION_TYPE_SYSTEM = "system";

    // ========== Request & Result Codes ==========
    public static final int REQUEST_CODE_LOGIN = 1001;
    public static final int REQUEST_CODE_SIGNUP = 1002;
    public static final int REQUEST_CODE_PRODUCT_DETAIL = 1003;
    public static final int REQUEST_CODE_CHECKOUT = 1004;
    public static final int REQUEST_CODE_GALLERY = 1005;
    public static final int REQUEST_CODE_CAMERA = 1006;

    public static final int RESULT_CODE_SUCCESS = 200;
    public static final int RESULT_CODE_ERROR = 400;
    public static final int RESULT_CODE_CANCELLED = 401;

    // ========== Intent Extra Keys ==========
    public static final String EXTRA_PRODUCT_ID = "product_id";
    public static final String EXTRA_CATEGORY = "category";
    public static final String EXTRA_ORDER_ID = "order_id";
    public static final String EXTRA_USER_ID = "user_id";
    public static final String EXTRA_TOTAL_AMOUNT = "total_amount";
    public static final String EXTRA_PROMO_CODE = "promo_code";

    // ========== Shared Preferences Keys ==========
    public static final String PREF_KEY_USER_UID = "user_uid";
    public static final String PREF_KEY_USER_EMAIL = "user_email";
    public static final String PREF_KEY_USER_NAME = "user_name";
    public static final String PREF_KEY_IS_LOGGED_IN = "is_logged_in";
    public static final String PREF_KEY_REMEMBER_ME = "remember_me";
    public static final String PREF_KEY_DARK_MODE = "dark_mode";
    public static final String PREF_KEY_NOTIFICATIONS = "notifications_enabled";

    // ========== Default Values ==========
    public static final double DEFAULT_TAX_PERCENTAGE = 5.0;
    public static final double DEFAULT_DELIVERY_CHARGE = 40.0;
    public static final int DEFAULT_PREPARATION_TIME = 15;
    public static final int MINIMUM_ORDER_AMOUNT = 100;
    public static final int MAXIMUM_CART_ITEMS = 100;
    public static final int MAX_ADDRESS_COUNT = 5;

    // ========== Product Categories ==========
    public static final String[] PRODUCT_CATEGORIES = {
        "Coffee",
        "Tea",
        "Smoothies",
        "Desserts",
        "Snacks",
        "Fast Food",
        "Beverages"
    };

    // ========== Error Messages ==========
    public static final String ERROR_NO_INTERNET = "No internet connection";
    public static final String ERROR_AUTHENTICATION_FAILED = "Authentication failed";
    public static final String ERROR_INVALID_EMAIL = "Invalid email address";
    public static final String ERROR_WEAK_PASSWORD = "Password is too weak";
    public static final String ERROR_EMAIL_ALREADY_EXISTS = "Email already registered";
    public static final String ERROR_USER_NOT_FOUND = "User not found";
    public static final String ERROR_INVALID_PASSWORD = "Invalid password";
    public static final String ERROR_PRODUCT_NOT_FOUND = "Product not found";
    public static final String ERROR_ORDER_NOT_FOUND = "Order not found";
    public static final String ERROR_CART_IS_EMPTY = "Cart is empty";
    public static final String ERROR_INVALID_QUANTITY = "Invalid quantity";
    public static final String ERROR_INSUFFICIENT_FUNDS = "Insufficient funds";

    // ========== Success Messages ==========
    public static final String SUCCESS_LOGIN = "Login successful";
    public static final String SUCCESS_SIGNUP = "Signup successful";
    public static final String SUCCESS_LOGOUT = "Logout successful";
    public static final String SUCCESS_PROFILE_UPDATED = "Profile updated successfully";
    public static final String SUCCESS_ITEM_ADDED = "Item added to cart";
    public static final String SUCCESS_ITEM_REMOVED = "Item removed from cart";
    public static final String SUCCESS_ORDER_PLACED = "Order placed successfully";
    public static final String SUCCESS_ORDER_CANCELLED = "Order cancelled successfully";

    // ========== API Timeouts ==========
    public static final long CONNECTION_TIMEOUT = 30000; // 30 seconds
    public static final long READ_TIMEOUT = 30000;
    public static final long WRITE_TIMEOUT = 30000;

    // ========== Animation Durations ==========
    public static final int ANIMATION_SHORT_DURATION = 300;
    public static final int ANIMATION_MEDIUM_DURATION = 500;
    public static final int ANIMATION_LONG_DURATION = 1000;

    // ========== Pagination ==========
    public static final int PAGE_SIZE = 20;
    public static final int INITIAL_LOAD_SIZE = 20;

    // ========== Currency ==========
    public static final String CURRENCY_SYMBOL = "₹";
    public static final String CURRENCY_CODE = "INR";

    // ========== App Settings ==========
    public static final String LANGUAGE_ENGLISH = "en";
    public static final String LANGUAGE_HINDI = "hi";
    public static final String[] SUPPORTED_LANGUAGES = {LANGUAGE_ENGLISH, LANGUAGE_HINDI};

    // ========== Date & Time Formats ==========
    public static final String DATE_FORMAT = "dd-MM-yyyy";
    public static final String TIME_FORMAT = "HH:mm";
    public static final String DATETIME_FORMAT = "dd-MM-yyyy HH:mm";
}
