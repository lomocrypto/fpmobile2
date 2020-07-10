package com.movie.moviesion.ui.movie;

import com.movie.moviesion.api.ApiRetrofit;
import com.movie.moviesion.model.MovieResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MoviePresenter {
    private MovieView view;

    MoviePresenter(MovieView view) {
        this.view = view;
    }

    void getListMovie() {
        view.showLoad();
        Call<MovieResponse> request = ApiRetrofit.getServiceRetrofit().getMovie();
        request.enqueue(new Callback<MovieResponse>() {
            @Override
            public void onResponse(Call<MovieResponse> call, Response<MovieResponse> response) {
                view.finishLoad();
                if (response.body() != null) {
                    view.showList(response.body().getResult());
                }
            }

            @Override
            public void onFailure(Call<MovieResponse> call, Throwable t) {
                view.noData();
            }
        });
    }
}

