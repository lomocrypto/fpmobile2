package com.movie.moviesion;

import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceLogin {
    private static PreferenceLogin INSTANCE;
    private SharedPreferences sharedPreferences;

    private PreferenceLogin(Context context){
        sharedPreferences = context
                .getApplicationContext()
                .getSharedPreferences("simple.androis.app", Context.MODE_PRIVATE);
    }

    public static PreferenceLogin getInstance(Context context){
        if (INSTANCE==null){
            INSTANCE = new PreferenceLogin(context);
        }
        return INSTANCE;
    }

    public SharedPreferences Pref() {
        return sharedPreferences;
    }

    public Boolean isLogin(){
        return sharedPreferences.getBoolean("isLogin", false);
    }

    public void setLogin(Boolean isCall){
        sharedPreferences.edit().putBoolean("isLogin", isCall).apply();
    }

    public void setNim(String isName){
        sharedPreferences.edit().putString("isName", isName).apply();
    }

    public String getNim(){
        return sharedPreferences.getString("isName", " ");
    }

    public void setPass(String isPass){
        sharedPreferences.edit().putString("isPass", isPass).apply();
    }

    public String getPass(){
        return sharedPreferences.getString("isPass", " ");
    }



}
