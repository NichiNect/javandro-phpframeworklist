package com.example.belajararray2_yoniwidhi;

import android.content.Context;
import android.content.SharedPreferences;

public class SessionManager {
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    // Constructor Method
    public SessionManager(Context context) {
        sharedPreferences = context.getSharedPreferences("AppKey", 0);
        editor = sharedPreferences.edit();
        editor.apply();
    }

    // Create setter setLogin()
    public void setLogin(boolean login) {
        editor.putBoolean("KEY_LOGIN", login);
        editor.commit();
    }

    // Create getter getLogin()
    public boolean getLogin() {
        return sharedPreferences.getBoolean("KEY_LOGIN",false);
    }

    // Create setter setUsername()
    public void setUsername(String username) {
        editor.putString("KEY_USERNAME", username);
        editor.commit();
    }

    // Create getter getUsername()
    public String getUsername() {
        return sharedPreferences.getString("KEY_USERNAME","");
    }
}
