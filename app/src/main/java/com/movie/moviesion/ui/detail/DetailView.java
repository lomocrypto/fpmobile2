package com.movie.moviesion.ui.detail;

import android.content.Context;
import android.os.Bundle;

import com.movie.moviesion.model.MovieItem;
import com.movie.moviesion.model.TvShowItem;

public interface DetailView {
    interface View {
        void showDetailMovie(MovieItem movieItem);

        void showDetailTvShow(TvShowItem tvShowItem);
    }

    interface Presenter {
        void getDetailMovie(Bundle bundle);

        void addToFavMovie(Context context, MovieItem movieItem);

        void addToFavTv(Context context, TvShowItem tvShowItem);

        void removeFavMovie(Context context, MovieItem movieItem);

        void removeFavTv(Context context, TvShowItem movieItem);

        boolean checkFavMovie(Context context, MovieItem movieItem);

        boolean checkFavTvShow(Context context, TvShowItem tvShowItem);

    }
}
