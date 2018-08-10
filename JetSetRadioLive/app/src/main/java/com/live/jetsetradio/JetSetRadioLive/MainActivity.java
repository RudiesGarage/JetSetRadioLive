package com.live.jetsetradio.JetSetRadioLive;

import android.animation.ArgbEvaluator;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
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
import android.view.View;
import android.view.ViewManager;
import android.view.inputmethod.InputMethodManager;


//Main activity that holds everything!
public class MainActivity extends FragmentActivity {
    String msg = "Android : ";
    ArgbEvaluator RGB = new ArgbEvaluator();
    Integer[] IntArray;
    private ViewPager Viewpager; //ViewPager
    private PagerAdapter Adapter; //PagerAdapter
    private int status;

    //Fragment State Adapter
    private class CustomFragmentStatePagerAdapter extends FragmentStatePagerAdapter {
       //takes a fragment manager
        public CustomFragmentStatePagerAdapter( FragmentManager fm) {
            super(fm);
        }
        //fragment handler
        @Override
        public Fragment getItem(int i) {
            if (i == 0) {
                return new RadioFragment(); //load radio fragment
            }
            return new Fragment(); //blank fragment for now (chat TBD)
        }
        //get the count of fragments (one for music player one for chat)
        @Override
        public int getCount() {
            return 2;
        }
    }

    private class UpdateBG implements ViewPager.OnPageChangeListener {
        final /* synthetic */ MainActivity f3330a;

        private UpdateBG(MainActivity mainActivity) {
            this.f3330a = mainActivity;
        }

        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            this.f3330a.status = position;
            if (position >= this.f3330a.Adapter.getCount() - 1 || position >= this.f3330a.IntArray.length - 1) {
                this.f3330a.Viewpager.setBackgroundColor(this.f3330a.IntArray[this.f3330a.IntArray.length - 1].intValue());
            } else {
                this.f3330a.Viewpager.setBackgroundColor(((Integer) this.f3330a.RGB.evaluate(positionOffset, this.f3330a.IntArray[position], this.f3330a.IntArray[position + 1])).intValue());
            }
        }
        
        @Override
        public void onPageSelected(int position) {
            if (position == 1) {
                this.f3330a.m5846f();
            }
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    }



    class CustomBR extends BroadcastReceiver {
        final /* synthetic */ MainActivity f3329a;

        CustomBR(MainActivity mainActivity) {
            this.f3329a = mainActivity;
        }

        public void onReceive(Context context, Intent intent) {
            this.f3329a.IntArray[0] = Integer.valueOf(intent.getExtras().getInt("Color"));
            if (this.f3329a.status == 0) {
                this.f3329a.Viewpager.setBackgroundColor(this.f3329a.IntArray[0].intValue());
            }
        }
    }


    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d(msg, "The onCreate() event");
        setVolumeControlStream(3); //set volume to 3
        setContentView(R.layout.screen_slide); //set view
        super.onCreate(savedInstanceState); //create instance

        //PreferenceManager.setDefaultValues(this, R.xml.preferences, false); //preference manager TBD

        this.Adapter = new CustomFragmentStatePagerAdapter( getSupportFragmentManager()); //create a fragment state adapter
        this.Viewpager = findViewById(R.id.pager); //Set view to screen slide pager
        this.Viewpager.setAdapter(this.Adapter); //have the adapter be part of set adapter
        // this.Viewpager.addOnPageChangeListener (new UpdateBG(this)); //add BG listener to change background
        LocalBroadcastManager.getInstance(getApplicationContext()).registerReceiver(new CustomBR(this), new IntentFilter("JSRL.UPDATEBG"));
        getWindow().setSoftInputMode(3);//SOFT_INPUT_STATE_ALWAYS_HIDDEN

        start_notifications();
    }


    /** Called when the activity is about to become visible. */
    @Override
    protected void onStart() {

        Log.e("DEBUG", "MainActivity ONSTART");
       // SharedPreferences defaultSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext()); //TBD
        super.onStart(); //start app
       // Intent intent = new Intent(getBaseContext(),MediaPlayerS.class); //make Media player intent
       // intent.setAction("action_preload"); //preload  intent
        //startService(intent); //start intent
         m5846f();
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

    //start notification
    public void start_notifications() {
        Intent serviceIntent = new Intent(MainActivity.this, NotificationService.class);
        serviceIntent.setAction(Constants.ACTION.STARTFOREGROUND_ACTION);
        startService(serviceIntent);
    }
}
