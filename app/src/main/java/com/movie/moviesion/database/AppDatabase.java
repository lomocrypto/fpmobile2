package com.movie.moviesion.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.movie.moviesion.model.MovieItem;
import com.movie.moviesion.model.TvShowItem;

@Database(entities = {MovieItem.class, TvShowItem.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    public abstract MovieFavDAO movieFavDAO();

    private static AppDatabase appDatabase;

    public static AppDatabase getDatabase(Context context) {
        synchronized (AppDatabase.class) {
            if (appDatabase == null) {
                appDatabase = Room.databaseBuilder(context, AppDatabase.class, "dbMovieFav").allowMainThreadQueries().build();
            }
        }
        return appDatabase;
    }
}