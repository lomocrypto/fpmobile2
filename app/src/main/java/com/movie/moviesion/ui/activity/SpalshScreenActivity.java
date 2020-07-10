package com.movie.moviesion.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.movie.moviesion.PreferenceLogin;
import com.movie.moviesion.R;

public class SpalshScreenActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 1500;
    private PreferenceLogin login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);
        login = PreferenceLogin.getInstance(getApplicationContext());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (login.isLogin()) {
                    Intent intent = new Intent(SpalshScreenActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    startActivity(new Intent(SpalshScreenActivity.this, LoginActivity.class));
                }
            }
        }, SPLASH_TIME_OUT);
    }
}