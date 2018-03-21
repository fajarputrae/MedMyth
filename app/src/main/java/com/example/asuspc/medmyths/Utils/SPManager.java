package com.example.asuspc.medmyths.Utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.util.Log;

/**
 * Created by asus pc on 19/03/2018.
 */

public class SPManager {
    public static final String IS_REGISTER = "IS_REGISTER";

    private static SharedPreferences getSharedPreference(Context context) {
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setIsRegister(Context context, Boolean isLogin) {
        getSharedPreference(context).edit().putBoolean(IS_REGISTER, isLogin).commit();
    }

    public static Boolean getIsRegister(Context context) {
        return getSharedPreference(context).getBoolean(IS_REGISTER, false);
    }


    public static void saveString(Context activity, String key, String value) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key, value);
        if (editor.commit()) {
            Log.d("SPMANAGER", "commited " + value);
        } else {
            Log.d("SPMANAGER", "not commited");
        }
    }

    public static void saveInt(Context activity, String key, int value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(activity);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static void saveBoolean(Context activity, String key, boolean value) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(activity);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static String getString(Context activity, String key) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(activity);
        String latihan = sharedPreferences.getString(key, null);
        return latihan;
    }

    public static int getInt(Context activity, String key) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(activity);
        int latihan = sharedPreferences.getInt(key, 0);
        return latihan;
    }

    public static boolean getBoolean(Context activity, String key) {
        SharedPreferences sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(activity);
        boolean latihan = sharedPreferences.getBoolean(key, false);
        return latihan;
    }

}
