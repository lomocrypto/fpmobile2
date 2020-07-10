package com.movie.moviesion.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.movie.moviesion.model.MovieItem;
import com.movie.moviesion.model.TvShowItem;

import java.util.List;

@Dao
public interface MovieFavDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertMovie(MovieItem movieItem);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertTvShow(TvShowItem tvShowItem);

    @Query("SELECT * FROM tMovie WHERE id = :id")
    MovieItem selectedMovie(int id);

    @Query("SELECT * FROM tTvShow WHERE id = :id")
    MovieItem selectedTv(int id);

    @Delete
    void deleteMovie(MovieItem movieItem);

    @Delete
    void deleteTv(TvShowItem tvShowItem);

    @Query("SELECT * FROM tMovie ORDER BY title ASC")
    List<MovieItem> selectFavoriteMovie();

    @Query("SELECT * FROM tTvShow ORDER BY title ASC")
    List<TvShowItem> selectFavoriteTv();
}

