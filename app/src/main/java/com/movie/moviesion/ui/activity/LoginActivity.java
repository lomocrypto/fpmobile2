package com.movie.moviesion.ui.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.movie.moviesion.PreferenceLogin;
import com.movie.moviesion.R;
import com.movie.moviesion.base.BaseActivity;

public class LoginActivity extends BaseActivity {

    private PreferenceLogin login;
    private EditText etNim; // form input nim
    private EditText etPass; // form input password
    private Button btnLogin; // tombol login

    @Override
    public int setLayout() {
        return R.layout.activity_login;
    }

    @Override
    public void initComponent(Bundle savedInstanceState) {
        login = PreferenceLogin.getInstance(getApplicationContext());
        login.setPass("123456");
    }

    @Override
    public void findView() {
        etNim = findViewById(R.id.login_Nim);
        etPass = findViewById(R.id.loginPass);
        btnLogin = findViewById(R.id.btn_login);
    }

    @Override
    public void initView() {

    }


    @Override
    public void loadView() {

    }

    @Override
    public void listener() {
        btnLogin.setOnClickListener(v -> {
            // ambil isi dari form
            String nim = etNim.getText().toString();
            String pass = etPass.getText().toString();
            // pengecekan nama dan nim
            if (nim.equals("18.02.0248") && pass.equals("finalprojeck")) {
                // set login
                login.setLogin(true);
                login.setNim(nim);

                //Login
                Toast.makeText(this, "Login Berhasil", Toast.LENGTH_SHORT).show();

                // Move to Main
                startActivity(new Intent(LoginActivity.this, MainActivity.class));
                finish();

            } else if (nim.equals("") && pass.equals("")) {

                Toast.makeText(this, "Blom di isi pak", Toast.LENGTH_SHORT).show();

            } else {

                Toast.makeText(this, "Nim atau Password salah pak", Toast.LENGTH_SHORT).show();

            }

        });
    }

}
