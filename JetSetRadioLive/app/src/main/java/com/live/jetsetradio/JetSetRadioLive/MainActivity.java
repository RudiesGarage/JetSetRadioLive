package com.live.jetsetradio.JetSetRadioLive;

import android.animation.ArgbEvaluator;
import android.app.Activity;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.preference.PreferenceManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import 	android.support.v4.view.PagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends FragmentActivity {
    String msg = "Android : ";
    ArgbEvaluator RGB = new ArgbEvaluator();
    Integer[] IntArray;
    private ViewPager Viewpager;
    private PagerAdapter Adapter;
    private int status;







    private class CustomFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
        final /* synthetic */ MainActivity f3331a;
       // FragmentManager myManager;
        public CustomFragmentStatePagerAdapter(MainActivity mainActivity, FragmentManager fm) {
            super(fm);
            this.f3331a = mainActivity;

        }

        @Override
        public Fragment getItem(int i) {
            if (i == 0) {
                return new RadioFragment();
            }
            return new Fragment();
        }

        @Override
        public int getCount() {
            return 2;
        }
    }




    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        setVolumeControlStream(3);
        Log.d(msg, "The onCreate() event");
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(R.layout.screen_slide);
        //PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
        //this.IntArray = new Integer[]{Integer.valueOf(Color.parseColor("#" + Integer.toHexString(getResources().getColor(R.color.md_orange_500)).toUpperCase())), Integer.valueOf(Color.parseColor("#" + Integer.toHexString(getResources().getColor(R.color.md_orange_500)).toUpperCase()))};
        this.Adapter = new CustomFragmentStatePagerAdapter(this, getSupportFragmentManager());
        this.Viewpager = (ViewPager) findViewById(R.id.pager);
        this.Viewpager.setAdapter(this.Adapter);
       // this.Viewpager.setOnPageChangeListener(new C1281a(this));
        //LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(new RadioReceiver(this), new IntentFilter("JSRL.UPDATECOLOR"));
        getWindow().setSoftInputMode(3);
        Intent intent = new Intent(getBaseContext(),MediaPlayerS.class);
        intent.setAction("action_preload");
        startService(intent);

    }

    /** Called when the activity is about to become visible. */
    @Override
    protected void onStart() {
        Log.e("DEBUG", "MainActivity ONSTART");

       // SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
       // this.IntArray[1] = Integer.valueOf(Color.parseColor("#" + Integer.toHexString(defaultSharedPreferences.getInt("chatbg", getResources().getColor(R.color.md_orange_500))).toUpperCase()));
       // if (!defaultSharedPreferences.getBoolean("randombg", true) && this.status == 0) {
           // this.IntArray[0] = Integer.valueOf(Color.parseColor("#" + Integer.toHexString(defaultSharedPreferences.getInt("radiobg", getResources().getColor(R.color.md_orange_500))).toUpperCase()));
            //this.Viewpager.setBackgroundColor(this.IntArray[0].intValue());
      //  }

        super.onStart();
        // m5846f();
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
        super.onDestroy();
        Log.d(msg, "The onDestroy() event");
    }

    private void m5846f() {
        // ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(this.f3334p.getWindowToken(), 0);
    }

    public void onBackPressed() {
        moveTaskToBack(true);
    }

}
