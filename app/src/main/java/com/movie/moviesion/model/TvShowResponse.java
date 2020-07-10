package com.movie.moviesion.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class TvShowResponse {
    @SerializedName("results")
    private ArrayList<TvShowItem> resultTvShow;

    public ArrayList<TvShowItem> getResultTvShow() {
        return resultTvShow;
    }
}

