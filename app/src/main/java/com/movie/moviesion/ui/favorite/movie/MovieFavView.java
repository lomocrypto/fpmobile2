package com.movie.moviesion.ui.favorite.movie;

import android.content.Context;

import com.movie.moviesion.model.MovieItem;

import java.util.List;

public interface MovieFavView {
    interface View {
        void hideRefresh();

        void showDataList(List<MovieItem> movieItems);
    }

    interface Presenter{
        void getDataListMovie(Context context);
    }
}

