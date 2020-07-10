package com.movie.moviesion.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.movie.moviesion.R;
import com.movie.moviesion.model.MovieItem;
import com.movie.moviesion.ui.detail.DetailActivity;
import com.movie.moviesion.utils.Helper;

import java.util.ArrayList;
import java.util.List;

public class MovieAdapter extends RecyclerView.Adapter<MovieAdapter.MovieViewHolder> {
    private Context context;
    private List<MovieItem> listMovieItem;

    public MovieAdapter(Context context, List<MovieItem> listMovieItem) {
        this.context = context;
        this.listMovieItem = listMovieItem;
    }

    public void refill(ArrayList<MovieItem> items) {
        this.listMovieItem = new ArrayList<>();
        this.listMovieItem.addAll(items);

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MovieViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_movie, viewGroup, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieViewHolder holder, final int i) {
        String pathGambar = listMovieItem.get(i).getBannerPath();
        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500" + pathGambar)
                .into(holder.imgPoster);
        holder.tvTitle.setText(listMovieItem.get(i).getTitle());
        holder.tvReleaseDate.setText(listMovieItem.get(i).getReleaseDate());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(Helper.STATE, "movie");
                intent.putExtra(Helper.EXTRA_MOVIE, listMovieItem.get(i));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listMovieItem.size();
    }

    class MovieViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView tvTitle, tvReleaseDate;

        MovieViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.imgBannerTvShow);
            tvTitle = itemView.findViewById(R.id.tvTitleTvShow);
            tvReleaseDate = itemView.findViewById(R.id.tvReleaseDateTvShow);
        }
    }
}
