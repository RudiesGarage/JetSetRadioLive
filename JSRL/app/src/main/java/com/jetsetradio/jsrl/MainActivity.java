package com.jetsetradio.jsrl;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.Serializable;
import java.util.Objects;

@SuppressLint("Registered")
public class MainActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;
    private ImageView img;
    private LinearLayout layout;
    private Station[] stationlist;

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar
        setContentView(R.layout.activity_main);

        img = (ImageView)findViewById(R.id.splash);
        layout = (LinearLayout) findViewById(R.id.splashlayout);

        // LOAD MUSIC DB while splash screen is going
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                AssetManager assetManager = getAssets();
                InputStream ims = null;
                try {
                    // read json file
                    ims = assetManager.open("station_data.json");
                    Reader reader = new InputStreamReader(ims);
                    // have Gson convert into objects
                    stationlist = new Gson().fromJson(reader,Station[].class);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // do the fade-in animation
        Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        img.startAnimation(animFadeIn);


        final Handler handler =new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                // TODO check if music db is loaded, if not throw an error

                //Do fade out after 2 sec
                Animation animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
                img.startAnimation(animFadeOut);
                layout.removeAllViews();

                // Load home page and pass the music list
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent homeIntent = new Intent(MainActivity.this,HomeActivity.class);
                        homeIntent.putExtra("MusicDB", (Serializable) stationlist);
                        startActivity(homeIntent);
                        finish();
                    }
                },SPLASH_TIME_OUT);

            }
        }, SPLASH_TIME_OUT);

    }
}
