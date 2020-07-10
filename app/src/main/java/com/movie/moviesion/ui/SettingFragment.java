package com.movie.moviesion.ui;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.movie.moviesion.PreferenceLogin;
import com.movie.moviesion.R;
import com.movie.moviesion.ui.activity.LoginActivity;

public class SettingFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        return inflater.inflate(R.layout.fragment_setting, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button btnChangeLanguage = view.findViewById(R.id.btnLanguage);
        Button btnexit = view.findViewById(R.id.btnexit);

        btnexit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                System.exit(0);
            }

            private void finish() {
            }
        });
        btnChangeLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent change = new Intent(Settings.ACTION_LOCALE_SETTINGS);
                startActivity(change);
            }
        });

        onButtonLogoutClick(view);
    }

    private void onButtonLogoutClick(View view) {

        view.findViewById(R.id.btnlogout).setOnClickListener(v -> {
            PreferenceLogin.getInstance(getActivity()).setLogin(false);
            startActivity(new Intent(getActivity(), LoginActivity.class));
            getActivity().finish();
            Toast.makeText(getActivity(), "Logout", Toast.LENGTH_SHORT).show();
        });

    }
}

