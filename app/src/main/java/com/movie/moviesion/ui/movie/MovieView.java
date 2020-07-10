package com.movie.moviesion.ui.movie;

import com.movie.moviesion.model.MovieItem;

import java.util.ArrayList;

public interface MovieView {
    void showLoad();

    void finishLoad();

    void showList(ArrayList<MovieItem> listMovie);

    void noData();
}
