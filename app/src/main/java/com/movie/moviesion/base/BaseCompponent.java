package com.movie.moviesion.base;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

class BaseCompponent {

    public interface Activity extends Component {
        void initComponent(Bundle savedInstanceState);

        void findView();
    }

    public interface Fragment extends Component {
        void initComponent(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState);

        void findView(View v);
    }

    private interface Component {
        int setLayout();

        void initView();

        void loadView();

        void listener();
    }

}
