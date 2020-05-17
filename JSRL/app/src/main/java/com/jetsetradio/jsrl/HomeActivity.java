package com.jetsetradio.jsrl;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.drawable.Drawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.bumptech.glide.Glide;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import static androidx.constraintlayout.widget.Constraints.TAG;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageClickListener;
import com.synnapps.carouselview.ImageListener;


public class HomeActivity extends AppCompatActivity{
    private LinearLayout app_container;
    private ImageButton playbutton;
    private TextView songname;
    private TextView artistname;
    private RadioModel model;
    private ConstraintLayout container;
    private static final long MIN_DELAY_MS = 2000;
    private long mLastClickTime;


    private static final String CMD_NAME = "command";
    private static final String CMD_PAUSE = "pause";
    private static final String CMD_STOP = "pause";
    private static final String CMD_PLAY = "play";
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener;
    private BroadcastReceiver mIntentReceiver;
    private boolean mReceiverRegistered = false;
    private boolean mAudioFocusGranted = false;
    private Context context = this;
    private CarouselView carouselView;
    // Jellybean
    private static String SERVICE_CMD = "com.sec.android.app.music.musicservicecommand";
    private static String PAUSE_SERVICE_CMD = "com.sec.android.app.music.musicservicecommand.pause";
    private static String PLAY_SERVICE_CMD = "com.sec.android.app.music.musicservicecommand.play";

    private List<Integer> resourcereferences = new ArrayList<>();
    private List<Integer> backgroundreferences = new ArrayList<>();
    private Calendar calendar;
    private int month;
    private boolean isCarouselIdle = true;

    private void loadRefs() {
        this.resourcereferences.add(R.drawable.profk);
        this.resourcereferences.add(R.drawable.classic);
        this.resourcereferences.add(R.drawable.future);
        this.resourcereferences.add(R.drawable.ultraremixes);
        this.resourcereferences.add(R.drawable.ggs);
        this.resourcereferences.add(R.drawable.poisonjam);
        this.resourcereferences.add(R.drawable.noisetanks);
        this.resourcereferences.add(R.drawable.loveshockers);
        this.resourcereferences.add(R.drawable.rapid99);
        this.resourcereferences.add(R.drawable.immortals);
        this.resourcereferences.add(R.drawable.doomriders);
        this.resourcereferences.add(R.drawable.goldenrhinos);
        this.resourcereferences.add(R.drawable.kingforanotherday);
        this.resourcereferences.add(R.drawable.revolution);
        this.resourcereferences.add(R.drawable.hover);
        this.resourcereferences.add(R.drawable.butterflies);
        this.resourcereferences.add(R.drawable.memoriesoftokyoto);
        this.resourcereferences.add(R.drawable.lofi);
        this.resourcereferences.add(R.drawable.elaquent);
        this.resourcereferences.add(R.drawable.ollieking);
        this.resourcereferences.add(R.drawable.toejamandearl);
        this.resourcereferences.add(R.drawable.crazytaxi);
        if(month >=4 && month <=7){
            this.resourcereferences.add(R.drawable.summer);
        }
        else if(month ==8 || month==9){
            this.resourcereferences.add(R.drawable.halloween);
        }
        else if(month ==10 || month==11 || month == 0){
            this.resourcereferences.add(R.drawable.christmas);
        }

        this.resourcereferences.add(R.drawable.endofdays);
        this.resourcereferences.add(R.drawable.profk);
    }
    private void BGRefs() {
        this.backgroundreferences.add(R.drawable.profk);
        this.backgroundreferences.add(R.drawable.classicwallpaper);
        this.backgroundreferences.add(R.drawable.futurewallpaper);
        this.backgroundreferences.add(R.drawable.ultraremixeswallpaper);
        this.backgroundreferences.add(R.drawable.ggswallpaper);
        this.backgroundreferences.add(R.drawable.poisonjamwallpaper);
        this.backgroundreferences.add(R.drawable.noisetankswallpaper);
        this.backgroundreferences.add(R.drawable.loveshockerswallpaper);
        this.backgroundreferences.add(R.drawable.rapid99wallpaper);
        this.backgroundreferences.add(R.drawable.immortalswallpaper);
        this.backgroundreferences.add(R.drawable.doomriderswallpaper);
        this.backgroundreferences.add(R.drawable.goldenrhinoswallpaper);
        this.backgroundreferences.add(R.drawable.kingforanotherdaywallpaper);
        this.backgroundreferences.add(R.drawable.revolutionwallpaper);
        this.backgroundreferences.add(R.drawable.hoverwallpaper);
        this.backgroundreferences.add(R.drawable.butterflieswallpaper);
        this.backgroundreferences.add(R.drawable.memoriesoftokyotowallpaper);
        this.backgroundreferences.add(R.drawable.lofiwallpaper);
        this.backgroundreferences.add(R.drawable.elaquentwallpaper);
        this.backgroundreferences.add(R.drawable.olliekingwallpaper);
        this.backgroundreferences.add(R.drawable.toejamandearlwallpaper);
        this.backgroundreferences.add(R.drawable.crazytaxiwallpaper);
        if(month >=4 && month <=7){
            this.backgroundreferences.add(R.drawable.summerwallpaper);
        }
        else if(month ==8 || month==9){
            this.backgroundreferences.add(R.drawable.halloweenwallpaper);
        }
        else if(month ==10 || month==11 || month == 0){
            this.backgroundreferences.add(R.drawable.christmaswallpaper);
        }
        this.backgroundreferences.add(R.drawable.endofdayswallpaper);
        this.backgroundreferences.add(R.drawable.profk);
    }

    // taget for when to transition backgrounds
    private SimpleTarget<Drawable> simpleTarget = new SimpleTarget<Drawable>() {
        @Override
        public void onResourceReady(@NonNull Drawable resource, Transition<? super Drawable> transition) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                container.setBackground(resource);
            }
        }
    };


    // Count down timer to handle carousel station change
    private CountDownTimer cdTimer = new CountDownTimer(2000, 1000) {
        public void onTick(long millisUntilFinished) {
//            mTextField.setText("seconds remaining: " + millisUntilFinished / 1000);
            //here you can have your logic to set text to edittext
        }

        public void onFinish() {
             try {
                 // check if carousel state is idol
                if(model.getCurr_station() != carouselView.getCurrentItem() && isCarouselIdle){
                    Toast.makeText(HomeActivity.this, "Station Changed to: "+ model.getStation(carouselView.getCurrentItem()).getStationName(), Toast.LENGTH_SHORT).show();
                    loadSong(model.setStation(carouselView.getCurrentItem()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    };



    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE); //will hide the title
        Objects.requireNonNull(getSupportActionBar()).hide(); // hide the title bar
        setContentView(R.layout.activity_home);

        // load  views into variables for referencing
        calendar = Calendar.getInstance();
        month = calendar.get(Calendar.MONTH);
        loadViews();


        // Fade in animation
        Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        app_container.startAnimation(animFadeIn);

        MediaPlayer.OnCompletionListener completelistener = new MediaPlayer.OnCompletionListener() {
            public void onCompletion(MediaPlayer mp) {
                try {
                    buttonPress_next(null);
                } catch (IOException e) {
                    e.printStackTrace();
                }


            }
        };


        Station[] stations = (Station[]) Objects.requireNonNull(getIntent().getExtras()).getSerializable("MusicDB");
        // load music
        model = new RadioModel(this,stations,completelistener);

        model.removeSeasonal(month);

        // load station icon
        ImageListener imageListener = new ImageListener() {
            @Override
            public void setImageForPosition(int position, ImageView imageView) {
                if(position<resourcereferences.size()-1){
                    Glide.with(context).load(resourcereferences.get(model.getStation(position).getStation_logo())).into(imageView);
               }
            }
        };


        // handle carousel changes
        carouselView.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {
                // loop to the beginning
                if(position == resourcereferences.size()-1){
                    carouselView.setCurrentItem(1);
                    Glide.with(context).load(backgroundreferences.get(1)).into(simpleTarget);
                }
                // loop to the other side of the end
                else if(position == 0){
                    carouselView.setCurrentItem(resourcereferences.size()-2);
                    Glide.with(context).load(backgroundreferences.get(resourcereferences.size()-2)).into(simpleTarget);
                }
                // load bg image
                else{
                    Glide.with(context).load(backgroundreferences.get(position)).into(simpleTarget);
                    }

            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (state==ViewPager.SCROLL_STATE_IDLE && model.getCurr_station() != carouselView.getCurrentItem()){
                    isCarouselIdle = true;
                    cdTimer.cancel();
                    pause();
                    cdTimer.start();
                }
                else{
                    isCarouselIdle = false;
                }
            }
        });


        carouselView.setPageCount(resourcereferences.size());
        carouselView.setCurrentItem(1);
        carouselView.setImageListener(imageListener);
        carouselView.getHandler();




        // handle station icon onclick
        carouselView.setImageClickListener(new ImageClickListener() {
            @Override
            public void onClick(int position) {
                try {
                    model.setStation(position);
                    loadSong(model.getCurrSong());
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Toast.makeText(HomeActivity.this, "Station Changed to: "+ model.getStation(position).getStationName(), Toast.LENGTH_SHORT).show();
            }
        });

        // load the current song into display
        loadSong(model.getCurrSong());

        // Set up the audio listener
        mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
            @Override
            public void onAudioFocusChange(int focusChange) {
                switch (focusChange) {
                    case AudioManager.AUDIOFOCUS_GAIN:
                        Log.i(TAG, "AUDIOFOCUS_GAIN");
                        play();
                        break;
                    case AudioManager.AUDIOFOCUS_GAIN_TRANSIENT:
                        Log.i(TAG, "AUDIOFOCUS_GAIN_TRANSIENT");
                        break;
                    case AudioManager.AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK:
                        Log.i(TAG, "AUDIOFOCUS_GAIN_TRANSIENT_MAY_DUCK");
                        break;
                    case AudioManager.AUDIOFOCUS_LOSS:
                        Log.e(TAG, "AUDIOFOCUS_LOSS");
                        pause();
                        break;
                    case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT:
                        Log.e(TAG, "AUDIOFOCUS_LOSS_TRANSIENT");
                        pause();
                        break;
                    case AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK:
                        Log.e(TAG, "AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK");
                        break;
                    case AudioManager.AUDIOFOCUS_REQUEST_FAILED:
                        Log.e(TAG, "AUDIOFOCUS_REQUEST_FAILED");
                        break;
                    default:
                        //
                }
            }
        };

        // 1. request focus
        requestAudioFocus();
        // 2. Kill off any other play back sources
        forceMusicStop();
        // 3. Register broadcast receiver for player intents
        setupBroadcastReceiver();

        IntentFilter receiverFilter = new IntentFilter(Intent.ACTION_HEADSET_PLUG);
        registerReceiver(mIntentReceiver, receiverFilter);







    }

   // if we receive Audio focus gain from listener...
    public void play() {
        if (this.model.isPlaying()) {

            // 1. Acquire audio focus
            if (!mAudioFocusGranted && requestAudioFocus()) {
                // 2. Kill off any other play back sources
                forceMusicStop();
            }
            playbutton.setBackgroundResource(R.drawable.arrow_pause);
            this.model.resume();
        }
    }

    // if we receive audio focus loss from listener...
    public void pause() {
        // 1. Suspend play back
        if (mAudioFocusGranted && this.model.isPlaying()) {
            abandonAudioFocus();
            playbutton.setBackgroundResource(R.drawable.arrow_play);
            this.model.pause();
        }
    }


    // obtain audio focus
    private boolean requestAudioFocus() {
        if (!mAudioFocusGranted) {
            AudioManager am = (AudioManager) this
                    .getSystemService(Context.AUDIO_SERVICE);
            // Request audio focus for play back
            int result = am.requestAudioFocus(mOnAudioFocusChangeListener,
                    // Use the music stream.
                    AudioManager.STREAM_MUSIC,
                    // Request permanent focus.
                    AudioManager.AUDIOFOCUS_GAIN);

            if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                mAudioFocusGranted = true;
            } else {
                // FAILED
                Log.e(TAG,">>>>>>>>>>>>> FAILED TO GET AUDIO FOCUS <<<<<<<<<<<<<<<<<<<<<<<<");
            }
        }
        return mAudioFocusGranted;
    }

    // relinquish audio focus
    private void abandonAudioFocus() {
        AudioManager am = (AudioManager) this
                .getSystemService(Context.AUDIO_SERVICE);
        int result = am.abandonAudioFocus(mOnAudioFocusChangeListener);
        if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
            mAudioFocusGranted = false;
        } else {
            // FAILED
            Log.e(TAG,">>>>>>>>>>>>> FAILED TO ABANDON AUDIO FOCUS <<<<<<<<<<<<<<<<<<<<<<<<");
        }
    }

    // set up listener
    private void setupBroadcastReceiver() {
        mIntentReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                String action = intent.getAction();
                if (Intent.ACTION_HEADSET_PLUG.equals(action)){
                    if (intent.getIntExtra("state", -1) == 0){
                        pause();
                    }
                }
                if(intent.hasExtra(CMD_NAME)){
                    String cmd = intent.getStringExtra(CMD_NAME);

                    Log.i(TAG, "mIntentReceiver.onReceive " + action + " / " + cmd);
                    if (PAUSE_SERVICE_CMD.equals(action)
                            || (SERVICE_CMD.equals(action) && CMD_PAUSE.equals(cmd))) {
                        play();
                    }
                    if (PLAY_SERVICE_CMD.equals(action)
                            || (SERVICE_CMD.equals(action) && CMD_PLAY.equals(cmd))) {
                        pause();
                    }
                }

            }
        };

        // Do the right thing when something else tries to play
        if (!mReceiverRegistered) {
            IntentFilter commandFilter = new IntentFilter();
            commandFilter.addAction(SERVICE_CMD);
            commandFilter.addAction(PAUSE_SERVICE_CMD);
            commandFilter.addAction(PLAY_SERVICE_CMD);
            this.registerReceiver(mIntentReceiver, commandFilter);
            mReceiverRegistered = true;
        }
    }

    // force background audio to stop
    private void forceMusicStop() {
        AudioManager am = (AudioManager) this
                .getSystemService(Context.AUDIO_SERVICE);
        if (am.isMusicActive()) {
            Intent intentToStop = new Intent(SERVICE_CMD);
            intentToStop.putExtra(CMD_NAME, CMD_STOP);
            this.sendBroadcast(intentToStop);
        }
    }


    // play or pause music on button press
    public void buttonPress_play(View v) throws IOException {
        //  if music playing then pause
        if (this.model.isPlaying()){
            playbutton.setBackgroundResource(R.drawable.arrow_play);
//            playbutton.setText("Play");
            abandonAudioFocus();
            this.model.pause();
        }
        // if music is paused then play
        else{
            //
            requestAudioFocus();
            // 2. Kill off any other play back sources
            forceMusicStop();
            playbutton.setBackgroundResource(R.drawable.arrow_pause);
//            playbutton.setText("Pause");
            this.model.resume();
        }
    }


    // next song on button press
    public void buttonPress_next(View v) throws IOException {
        //  Prevent making requests more than once a second
        long lastClickTime = mLastClickTime;
        long now = System.currentTimeMillis();
        mLastClickTime = now;
        if ((now - lastClickTime) > MIN_DELAY_MS) {
            Song currSong = this.model.next();
            requestAudioFocus();
            // 2. Kill off any other play back sources
            forceMusicStop();

            loadSong(currSong);
        }
    }



    // load the view data
    public void loadViews(){
        app_container = (LinearLayout) findViewById(R.id.container);
        playbutton = (ImageButton) findViewById(R.id.buttonPlay);
        songname = (TextView) findViewById(R.id.SongName);
        artistname = (TextView) findViewById(R.id.ArtistName);
        carouselView = (CarouselView) findViewById(R.id.carouselView);
        container = (ConstraintLayout) findViewById(R.id.constraintcontainer);
        loadRefs();
        BGRefs();
    }

    // load given song into display
    public void loadSong(Song currSong){
        if(currSong != null){
            songname.setText(currSong.getTitle());
            artistname.setText(currSong.getArtist());
            playbutton.setBackgroundResource(R.drawable.arrow_pause);
//            playbutton.setText("Pause");
        }
    }





}


