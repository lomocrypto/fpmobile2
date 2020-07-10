package com.movie.moviesion.ui.tvshow;

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
import com.movie.moviesion.adapter.TvShowAdapter;
import com.movie.moviesion.model.TvShowItem;

import java.util.ArrayList;

import static com.movie.moviesion.utils.Helper.KEY_MOVIES;

public class TvShowFragment extends Fragment implements TvShowView {
    private ArrayList<TvShowItem> dataTvShow = new ArrayList<>();
    private TvShowPresenter presenter;
    private TvShowAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tvshow, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        swipeRefreshLayout = view.findViewById(R.id.swipeRefreshNow);
        RecyclerView recyclerView = view.findViewById(R.id.rvTvShow);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        adapter = new TvShowAdapter(getActivity(), dataTvShow);
        recyclerView.setAdapter(adapter);

        presenter = new TvShowPresenter(this);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                presenter.getListTvShow();
            }
        });

        if (savedInstanceState == null) {
            presenter.getListTvShow();
        } else {
            dataTvShow = (ArrayList<TvShowItem>) savedInstanceState.getSerializable(KEY_MOVIES);
            adapter.refill(dataTvShow);
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
    public void showList(ArrayList<TvShowItem> listTvShow) {
        dataTvShow = listTvShow;
        adapter.refill(dataTvShow);
    }

    @Override
    public void noData() {
        swipeRefreshLayout.setRefreshing(false);
        dataTvShow.clear();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putSerializable(KEY_MOVIES, dataTvShow);
        super.onSaveInstanceState(outState);
    }
}
