package com.smartcafe.app.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * SharedPrefHelper - Utility for SharedPreferences operations
 * Used for storing user preferences, app settings, and simple data
 */
public class SharedPrefHelper {

    private static final String PREF_NAME = "SmartCafePrefs";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private static SharedPrefHelper instance;

    /**
     * Private constructor for singleton pattern
     */
    private SharedPrefHelper(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    /**
     * Get singleton instance
     */
    public static synchronized SharedPrefHelper getInstance(Context context) {
        if (instance == null) {
            instance = new SharedPrefHelper(context);
        }
        return instance;
    }

    // User Related Preferences
    public void saveUserUID(String uid) { editor.putString("user_uid", uid).apply(); }
    public String getUserUID() { return sharedPreferences.getString("user_uid", ""); }

    public void saveUserEmail(String email) { editor.putString("user_email", email).apply(); }
    public String getUserEmail() { return sharedPreferences.getString("user_email", ""); }

    public void saveUserName(String name) { editor.putString("user_name", name).apply(); }
    public String getUserName() { return sharedPreferences.getString("user_name", ""); }

    public void saveUserPhone(String phone) { editor.putString("user_phone", phone).apply(); }
    public String getUserPhone() { return sharedPreferences.getString("user_phone", ""); }

    public void saveUserPhotoUrl(String url) { editor.putString("user_photo_url", url).apply(); }
    public String getUserPhotoUrl() { return sharedPreferences.getString("user_photo_url", ""); }

    public void saveUserRole(String role) { editor.putString("user_role", role).apply(); }
    public String getUserRole() { return sharedPreferences.getString("user_role", "user"); }

    public void saveDefaultAddress(String address) { editor.putString("default_address", address).apply(); }
    public String getDefaultAddress() { return sharedPreferences.getString("default_address", ""); }

    // Login Related Preferences
    public void saveRememberMe(boolean remember) { editor.putBoolean("remember_me", remember).apply(); }
    public boolean getRememberMe() { return sharedPreferences.getBoolean("remember_me", false); }

    public void saveLoginEmail(String email) { editor.putString("login_email", email).apply(); }
    public String getLoginEmail() { return sharedPreferences.getString("login_email", ""); }

    public void setUserLoggedIn(boolean loggedIn) { editor.putBoolean("is_logged_in", loggedIn).apply(); }
    public boolean isUserLoggedIn() { return sharedPreferences.getBoolean("is_logged_in", false); }

    // App Settings
    public void saveDarkMode(boolean isDarkMode) { editor.putBoolean("dark_mode", isDarkMode).apply(); }
    public boolean isDarkModeEnabled() { return sharedPreferences.getBoolean("dark_mode", false); }

    public void saveNotificationEnabled(boolean enabled) { editor.putBoolean("notifications_enabled", enabled).apply(); }
    public boolean isNotificationEnabled() { return sharedPreferences.getBoolean("notifications_enabled", true); }

    public void saveLanguage(String language) { editor.putString("language", language).apply(); }
    public String getLanguage() { return sharedPreferences.getString("language", "en"); }

    // First Time User
    public void setFirstTimeUser(boolean isFirst) { editor.putBoolean("is_first_time", isFirst).apply(); }
    public boolean isFirstTimeUser() { return sharedPreferences.getBoolean("is_first_time", true); }

    public void setOnboardingShown(boolean shown) { editor.putBoolean("onboarding_shown", shown).apply(); }
    public boolean isOnboardingShown() { return sharedPreferences.getBoolean("onboarding_shown", false); }

    // Loyalty Points
    public void saveLoyaltyPoints(int points) { editor.putInt("loyalty_points", points).apply(); }
    public int getLoyaltyPoints() { return sharedPreferences.getInt("loyalty_points", 0); }

    // Cart Related
    public void saveCartItemCount(int count) { editor.putInt("cart_count", count).apply(); }
    public int getCartItemCount() { return sharedPreferences.getInt("cart_count", 0); }

    // Last Session
    public void saveLastSessionTime(long time) { editor.putLong("last_session", time).apply(); }
    public long getLastSessionTime() { return sharedPreferences.getLong("last_session", 0); }

    // Generic Methods
    public void putString(String key, String value) { editor.putString(key, value).apply(); }
    public String getString(String key, String defaultValue) { return sharedPreferences.getString(key, defaultValue); }

    public void putInt(String key, int value) { editor.putInt(key, value).apply(); }
    public int getInt(String key, int defaultValue) { return sharedPreferences.getInt(key, defaultValue); }

    public void putBoolean(String key, boolean value) { editor.putBoolean(key, value).apply(); }
    public boolean getBoolean(String key, boolean defaultValue) { return sharedPreferences.getBoolean(key, defaultValue); }

    public void putLong(String key, long value) { editor.putLong(key, value).apply(); }
    public long getLong(String key, long defaultValue) { return sharedPreferences.getLong(key, defaultValue); }

    /**
     * Clear all preferences
     */
    public void clearAll() {
        editor.clear().apply();
    }

    /**
     * Clear specific key
     */
    public void remove(String key) {
        editor.remove(key).apply();
    }

    /**
     * Check if key exists
     */
    public boolean containsKey(String key) {
        return sharedPreferences.contains(key);
    }
}
