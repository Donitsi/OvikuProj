package com.example.doni.oviku_proj;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

/**
 * Created by Doni on 11/8/2017.
 */

public class SaveSharedPreference
{
    static final String PREF_USER_NAME= "username";
    static final String PREF_THEME_BACKGROUND = "background_theme";
    static final String PREF_NOTIFICATION_STATUS = "notification_status";
    static final String PREF_LOCK_NAME = "lock_name";


    static SharedPreferences getSharedPreferences(Context ctx) {
        return PreferenceManager.getDefaultSharedPreferences(ctx);
    }

    public static void setUserName(Context ctx, String userName)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.putString(PREF_USER_NAME, userName);
        editor.commit();
    }

    public static void setBackgroundTheme(Context context, String background){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(PREF_THEME_BACKGROUND, background);
        editor.commit();
    }

    public static void setNotificationStatus(Context context, String notificationStatus){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(PREF_NOTIFICATION_STATUS, notificationStatus);
        editor.commit();
    }

    public static void setLockName(Context context, String lockName){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.putString(PREF_LOCK_NAME, lockName);
        editor.commit();
    }

    public static String getUserName(Context ctx)
    {
        return getSharedPreferences(ctx).getString(PREF_USER_NAME, "");
    }

    public static String getBackgroundTheme(Context context){
        return getSharedPreferences(context).getString(PREF_THEME_BACKGROUND,"");
    }

    public static String getNotificationStatus(Context context){
        return getSharedPreferences(context).getString(PREF_NOTIFICATION_STATUS, "");
    }

    public static String getLockName(Context context){
        return getSharedPreferences(context).getString(PREF_LOCK_NAME, "");
    }

    public static void clearUserName(Context ctx)
    {
        SharedPreferences.Editor editor = getSharedPreferences(ctx).edit();
        editor.remove("username");
        //editor.clear(); //clear all stored data
        editor.commit();
    }

    public static void clearBackgroundTheme(Context context){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.remove("background_theme");
        editor.commit();
    }
    public static void clearNotificationStatus(Context context){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.remove("notification_status");
        editor.commit();
    }

    public static void clearLockName(Context context){
        SharedPreferences.Editor editor = getSharedPreferences(context).edit();
        editor.remove("lock_name");
        editor.commit();
    }
}
