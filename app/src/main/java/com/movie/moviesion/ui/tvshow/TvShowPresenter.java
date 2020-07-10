package com.movie.moviesion.ui.tvshow;

import com.movie.moviesion.api.ApiRetrofit;
import com.movie.moviesion.model.TvShowResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class TvShowPresenter {

    private TvShowView view;

    TvShowPresenter(TvShowView view) {
        this.view = view;
    }

    void getListTvShow() {
        view.showLoad();
        Call<TvShowResponse> request = ApiRetrofit.getServiceRetrofit().getTvShow();
        request.enqueue(new Callback<TvShowResponse>() {
            @Override
            public void onResponse(Call<TvShowResponse> call, Response<TvShowResponse> response) {
                view.finishLoad();
                if (response.body() != null) {
                    view.showList(response.body().getResultTvShow());
                }
            }

            @Override
            public void onFailure(Call<TvShowResponse> call, Throwable t) {
                view.noData();
            }
        });
    }
}