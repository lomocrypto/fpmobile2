package com.movie.moviesion.ui.favorite.tvshow;

import android.content.Context;

import com.movie.moviesion.model.TvShowItem;

import java.util.List;

public interface TvShowFavView {
    interface View {
        void hideRefresh();

        void showDataList(List<TvShowItem> tvShowItems);
    }

    interface Presenter {
        void getDataListMovie(Context context);
    }
}

