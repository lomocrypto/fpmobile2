package com.movie.moviesion.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.movie.moviesion.R;
import com.movie.moviesion.adapter.ViewPageAdapter;
import com.movie.moviesion.ui.favorite.movie.MovieFavFragment;
import com.movie.moviesion.ui.favorite.tvshow.TvShowFavFragment;

public class FavoriteFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_fav, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        TabLayout tabLayout = view.findViewById(R.id.tabLayout);
        ViewPager viewPager = view.findViewById(R.id.viewPager);

        ViewPageAdapter adapter = new ViewPageAdapter(getChildFragmentManager());
        adapter.AddFragment(new MovieFavFragment(), getString(R.string.tab1));
        adapter.AddFragment(new TvShowFavFragment(), getString(R.string.tab2));
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}
