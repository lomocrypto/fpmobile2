package com.movie.moviesion.ui.movie;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.movie.moviesion.R;
import com.movie.moviesion.adapter.MovieAdapter;
import com.movie.moviesion.model.MovieItem;

import java.util.ArrayList;

import static com.movie.moviesion.utils.Helper.KEY_MOVIES;

public class MovieFragment extends Fragment implements MovieView {
    private ArrayList<MovieItem> dataMovie = new ArrayList<>();
    private MoviePresenter presenter;
    private MovieAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_movie, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshNow);
        RecyclerView recyclerView = view.findViewById(R.id.rvMovies);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new MovieAdapter(getActivity(), dataMovie);
        recyclerView.setAdapter(adapter);

        presenter = new MoviePresenter(this);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getListMovie();
            }
        });

        if (savedInstanceState == null) {
            presenter.getListMovie();
        } else {
            dataMovie = (ArrayList<MovieItem>) savedInstanceState.getSerializable(KEY_MOVIES);
            adapter.refill(dataMovie);
        }
    }

    @Override
    public void showLoad() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void finishLoad() {
        swipeRefreshLayout.setRefreshing(false);
    }

    @Override
    public void showList(ArrayList<MovieItem> listMovie) {
        dataMovie = listMovie;
        adapter.refill(dataMovie);
    }

    @Override
    public void noData() {
        swipeRefreshLayout.setRefreshing(false);
        dataMovie.clear();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putSerializable(KEY_MOVIES, dataMovie);
        super.onSaveInstanceState(outState);
    }
}

