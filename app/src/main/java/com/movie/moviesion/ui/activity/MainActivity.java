package com.movie.moviesion.ui.activity;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.fragment.app.Fragment;

import com.gauravk.bubblenavigation.BubbleNavigationConstraintView;
import com.gauravk.bubblenavigation.listener.BubbleNavigationChangeListener;
import com.movie.moviesion.PreferenceLogin;
import com.movie.moviesion.R;
import com.movie.moviesion.ui.FavoriteFragment;
import com.movie.moviesion.ui.SettingFragment;
import com.movie.moviesion.ui.movie.MovieFragment;
import com.movie.moviesion.ui.tvshow.TvShowFragment;

public class MainActivity extends AppCompatActivity {

    BubbleNavigationConstraintView buble;
    Fragment fragment;
    public static final int NOTIFICATION_ID = 1;
    public static String CHANNEL_ID = "Moviesion";
    public static CharSequence CHANNEL_NAME = "Mobilechannel";
    private PreferenceLogin login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NotificationManager mNotificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.ic_notifications_white_48dp)
                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.ic_notifications_white_48dp))
                .setContentTitle(getResources().getString(R.string.content_title))
                .setContentText(getResources().getString(R.string.content_text))
                .setSubText(getResources().getString(R.string.subtext))
                .setAutoCancel(true);

        /*
        Untuk android Oreo ke atas perlu menambahkan notification channel
        */
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, NotificationManager.IMPORTANCE_DEFAULT);
            mBuilder.setChannelId(CHANNEL_ID);
            if (mNotificationManager != null) {
                mNotificationManager.createNotificationChannel(channel);
            }
        }

        Notification notification = mBuilder.build();

        if (mNotificationManager != null) {
            mNotificationManager.notify(NOTIFICATION_ID, notification);
        }

        // kita set default nya Home Fragment
        if (savedInstanceState == null) {
            loadFragment(new MovieFragment());
        }

        buble = findViewById(R.id.floating_top_bar_navigation);
        buble.setNavigationChangeListener(new BubbleNavigationChangeListener() {
            @Override
            public void onNavigationChanged(View view, int position) {
                switch (view.getId()) {
                    case R.id.movie:
                        fragment = new MovieFragment();
                        break;
                    case R.id.tvShow:
                        fragment = new TvShowFragment();
                        break;
                    case R.id.favorite:
                        fragment = new FavoriteFragment();
                        break;
                    case R.id.setting:
                        fragment = new SettingFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fl_container, fragment).commit();
            }
        });
    }

    @Override
    public void onBackPressed() {
        // super.onBackPressed(); commented this line in order to disable back press
        //Write your code here
        Toast.makeText(getApplicationContext(), "Back press disabled!", Toast.LENGTH_SHORT).show();

    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            super.onKeyDown(keyCode, event);
            return true;
        }
        return false;
    }




    // method untuk load fragment yang sesuai
    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }


}
