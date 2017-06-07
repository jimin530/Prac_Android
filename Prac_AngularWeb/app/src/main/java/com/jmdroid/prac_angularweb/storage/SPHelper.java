package com.jmdroid.prac_angularweb.storage;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * 앱 구동간 필요에 의해서 저장하는 저장소 기능
 */
public class SPHelper {
    // 저장소 메인키

    private static SPHelper ourInstance = new SPHelper();

    public static SPHelper getInstance() {
        return ourInstance;
    }

    private SPHelper() {
    }

    public static final String STORAGE_KEY = "pref";
    public static final String SESSION_KEY = "cookies";
    Context context;

    public void setContext(Context context) {
        this.context = context;
    }

    public void setString(Context context, String key, String value) {
        // 저장소 획득
        SharedPreferences.Editor editor
                = context.getSharedPreferences(STORAGE_KEY, 0).edit();
        // 저장
        editor.putString(key, value);
        // 커밋
        editor.commit();
    }

    public void setString(String key, String value) {
        this.setString(this.context, key, value);
    }

    public String getString(Context context, String key) {
        return context.getSharedPreferences(STORAGE_KEY, 0).getString(key, "");
    }


    public void setBoolean(Context context, String key, boolean value) {
        // 저장소 획득
        SharedPreferences.Editor editor
                = context.getSharedPreferences(STORAGE_KEY, 0).edit();
        // 저장
        editor.putBoolean(key, value);
        // 커밋
        editor.commit();
    }

    public boolean getBoolean(Context context, String key) {
        return
                context.getSharedPreferences(STORAGE_KEY, 0).getBoolean(key, false);
    }

    public void setInt(Context context, String key, int value) {
        // 저장소 획득
        SharedPreferences.Editor editor
                = context.getSharedPreferences(STORAGE_KEY, 0).edit();
        // 저장
        editor.putInt(key, value);
        // 커밋
        editor.commit();
    }

    public int getInt(Context context, String key) {
        return context.getSharedPreferences(STORAGE_KEY, 0).getInt(key, 0);
    }
}













