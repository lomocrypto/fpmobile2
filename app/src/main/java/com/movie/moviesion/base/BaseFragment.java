package com.movie.moviesion.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

public abstract class BaseFragment extends Fragment implements BaseCompponent.Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(setLayout(), container, false);
        initComponent(inflater, container, savedInstanceState);
        findView(v);
        initView();
        loadView();
        listener();
        return v;
    }

}

