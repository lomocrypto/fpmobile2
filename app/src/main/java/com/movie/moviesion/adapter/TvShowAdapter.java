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
import com.movie
        .moviesion.model.TvShowItem;
import com.movie.moviesion.ui.detail.DetailActivity;
import com.movie.moviesion.utils.Helper;

import java.util.ArrayList;
import java.util.List;

public class TvShowAdapter extends RecyclerView.Adapter<TvShowAdapter.TvViewHolder> {
    private Context context;
    private List<TvShowItem> listTv;

    public TvShowAdapter(Context context, List<TvShowItem> listTv) {
        this.context = context;
        this.listTv = listTv;
    }

    public void refill(ArrayList<TvShowItem> items) {
        this.listTv = new ArrayList<>();
        this.listTv.addAll(items);

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public TvViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_tvshow, viewGroup, false);
        return new TvViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TvViewHolder holder, final int i) {
        String pathGambar = listTv.get(i).getBannerPath();
        Glide.with(context)
                .load("https://image.tmdb.org/t/p/w500" + pathGambar)
                .into(holder.imgPoster);
        holder.tvTitle.setText(listTv.get(i).getTitle());
        holder.tvReleaseDate.setText(listTv.get(i).getReleaseDate());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra(Helper.STATE, "tvShow");
                intent.putExtra(Helper.EXTRA_TV_SHOW, listTv.get(i));
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return listTv.size();
    }

    class TvViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPoster;
        TextView tvTitle, tvReleaseDate;

        TvViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPoster = itemView.findViewById(R.id.imgBannerTvShow);
            tvTitle = itemView.findViewById(R.id.tvTitleTvShow);
            tvReleaseDate = itemView.findViewById(R.id.tvReleaseDateTvShow);
        }
    }
}