package com.movie.moviesion.api;

import com.movie.moviesion.BuildConfig;
import com.movie.moviesion.model.MovieResponse;
import com.movie.moviesion.model.TvShowResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ClientService {
    @GET("movie/now_playing?api_key=" + BuildConfig.API_KEY + "&language=en-US")
    Call<MovieResponse> getMovie();

    @GET("tv/on_the_air?api_key=" + BuildConfig.API_KEY + "&language=en-US")
    Call<TvShowResponse> getTvShow();
}
