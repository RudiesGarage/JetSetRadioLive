package com.example.dem.jetsetradiolive;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

//The Main Activity that holds everything
//TODO Shared Preferences Manager


public class MainActivity extends AppCompatActivity {
    private String msg = "Android : ";

    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        Log.d(msg, "The onCreate() event");
        setVolumeControlStream(3); //set volume to 3
        setContentView(R.layout.screen_slide); //set view
        super.onCreate(savedInstanceState); //create instance

        //PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

        //Set up the fragment manager
        PagerAdapter Adapter = new CustomFragmentStatePagerAdapter(getSupportFragmentManager());

        ViewPager Viewpager = findViewById(R.id.pager); //Set view to screen slide pager
        Viewpager.setAdapter(Adapter); //have the adapter be part of set adapter

        getWindow().setSoftInputMode(3);//SOFT_INPUT_STATE_ALWAYS_HIDDEN
    }

    /** Called when the activity is about to become visible. */
    @Override
    protected void onStart() {

        Log.e("DEBUG", "MainActivity ONSTART");

        // SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()); //TBD
        super.onStart(); //start app

    }

    /** Called when the activity has become visible. */
    @Override
    protected void onResume() {
        super.onResume();
        Log.d(msg, "The onResume() event");
    }

    /** Called when another activity is taking focus.*/
    @Override
    protected void onPause() {
        super.onPause();
        Log.d(msg, "The onPause() event");
    }

    /** Called when the activity is no longer visible. */
    @Override
    protected void onStop() {
        Log.e("DEBUG", "MainActivity ONSTOP");
        super.onStop();
    }

    /** Called just before the activity is destroyed. */
    @Override
    public void onDestroy() {
        //remove all notifications
        NotificationManager nManager = ((NotificationManager) getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE));
        nManager.cancelAll();

        //Stop mediaplayer service
        Intent stopService = new Intent(getApplicationContext(),MediaPlayerServiceManager.class);
        getApplicationContext().stopService(stopService);

        super.onDestroy();
        Log.d(msg, "The onDestroy() event");
    }

    public void onBackPressed() {
        moveTaskToBack(true);
    }

}
