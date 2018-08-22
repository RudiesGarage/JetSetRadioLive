package com.live.jetsetradio.JetSetRadioLive;

import android.annotation.SuppressLint;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.preference.PreferenceManager;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.media.app.NotificationCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.text.Html;
import android.util.Log;
import android.widget.RemoteViews;
import android.widget.TextView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutionException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MediaPlayerS extends Service {



   // private Timer f3349F;
   // private Timer f3350G;

    TelephonyManager f3352a;
    PhoneStateListener f3353b;
    public static boolean isPlaying = false;

    private MediaSessionCompat MediaSesh; //Media Session
    private MediaControllerCompat MediaController; //Media Controller
    private MediaPlayer mp; //Media Player

    //Song Arrays
    private ArrayList<Song> future_array;
    private ArrayList<Song> ggs_array;
    private ArrayList<Song> classic_array;
    private ArrayList<Song> poison_array;
    private ArrayList<Song> noise_array;
    private ArrayList<Song> love_array;
    private ArrayList<Song> r99_array;
    private ArrayList<Song> immortals_array;
    private ArrayList<Song> gr_array;
    private ArrayList<Song> doom_array;
    private ArrayList<Song> summer_array;
    private ArrayList<Song> shuffle_array;
    //Songs
    private Song currentSong;
    private Song cachedSong;

    public static int station_count;

    private boolean f3368q = false;
    private boolean f3369r = false;
    //private boolean isPlaying = false;
    private LocalBroadcastManager f3370s;
    private IntentFilter f3371t = new IntentFilter("android.media.AUDIO_BECOMING_NOISY");

    private Custom_BCR f3372u;

    //URLS
    private URL ggs_URL;
    private URL classic_URL;
    private URL future_URL;
    private URL poisonjam_URL;
    private URL noisetanks_URL;
    private URL loveshockers_URL;
    private URL rapid99_URL;
    private URL immortals_URL;
    private URL goldenrhinos_URL;
    private URL doomriders_URL;
    private URL summer_URL;

    //Check PhoneState handler
    class C12853 extends PhoneStateListener {
        final /* synthetic */ MediaPlayerS f3339a;

        C12853(MediaPlayerS mediaPlayerService) {
            this.f3339a = mediaPlayerService;
        }

        //check if calling or being called...
        public void onCallStateChanged(int i, String str) {
            if (i == 1 || i == 2) {
                this.f3339a.MediaController.getTransportControls().pause(); //pause music
            }
            super.onCallStateChanged(i, str);
        }
    }

    class C12864 extends TimerTask {
        final /* synthetic */ MediaPlayerS f3340a;

        C12864(MediaPlayerS mediaPlayerService) {
            this.f3340a = mediaPlayerService;
        }

        public void run() {
            if (PreferenceManager.getDefaultSharedPreferences(this.f3340a.getApplicationContext()).getBoolean("songrequests", true)) {
                this.f3340a.m5865c();
            }
        }
    }

    class C12875 extends TimerTask {
        final /* synthetic */ MediaPlayerS f3341a;

        C12875(MediaPlayerS mediaPlayerService) {
            this.f3341a = mediaPlayerService;
        }

        public void run() {
            new ListenersAsync().execute(new Context[]{this.f3341a.getApplicationContext()});
        }
    }

    class C12886  {
        final  MediaPlayerS f3342b;

        C12886(MediaPlayerS mediaPlayerService) {
            this.f3342b = mediaPlayerService;
        }

        public void mo878b() {
          //  super.mo878b();
            if (!this.f3342b.f3368q) {

                try {
                    this.f3342b.getNextSong();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (URISyntaxException e) {
                    e.printStackTrace();
                }

            } else if (!this.f3342b.mp.isPlaying()) {
                this.f3342b.mp.start();
                this.f3342b.f3368q = false;
                //this.f3342b.MediaSesh.m1579a(new C0410a().m1591a(547).m1589a(3, -1, 1.0f).m1592a());
                //this.f3342b.m5857a(this.f3342b.m5852a(17301539, "Pause", "action_pause"));
            }
        }

        public void mo879c() {
           // super.mo879c();
            if (this.f3342b.mp.isPlaying()) {
                this.f3342b.mp.pause();
                this.f3342b.f3368q = true;
                //this.f3342b.m5857a(this.f3342b.getSongList()) m5857a(this.f3342b.m5852a(17301540, "Play", "action_play"));
                //this.f3342b.MediaSesh.m1579a(new C0410a().m1591a(549).m1589a(2, -1, 0.0f).m1592a());
            }
        }

        public void mo880d() throws MalformedURLException, URISyntaxException {
           // super.mo880d();
            this.f3342b.getNextSong();
        }

      //  public boolean mo877a(Intent intent) {
          //  return super.mo877a(intent);
      //  }

        @SuppressLint("WrongConstant")
        public void mo881h() {
          //  super.mo881h();
            Log.e("MediaPlayerService", "onStop");
            if (this.f3342b.mp.isPlaying() || this.f3342b.f3368q) {
                this.f3342b.mp.stop();
               // this.f3342b.MediaSesh.m1579a(new C0410a().m1591a(551).m1589a(1, -1, 0.0f).m1592a());
                Intent intent = new Intent();
                intent.setAction("JSRL.UPDATEUI");
                intent.putExtra("Song", new String[]{"", ""});
                this.f3342b.f3370s.sendBroadcastSync(intent);
                ((NotificationManager) this.f3342b.getApplicationContext().getSystemService("notification")).cancel(1);
            }
        }
    }

    //Custom BroadCast Receiver (manage output)
    private class Custom_BCR extends BroadcastReceiver {
        final /* synthetic */ MediaPlayerS f3343a;

        private Custom_BCR(MediaPlayerS mediaPlayerService) {
            this.f3343a = mediaPlayerService;
        }

        //if new headphones detach..
        public void onReceive(Context context, Intent intent) {
            if (mp != null && mp.isPlaying()) {
                mp.pause(); //pause media player
            }
        }
    }

//on creat of the media player
    public void onCreate() {
         final String Audio_Path_Base = "https://jetsetradio.live/audioplayer/stations/"; //base url for the music
         final String Audio_Array_Path = "/~list.js"; //array extention
        try {
            this.classic_URL = new URL(Audio_Path_Base +"classic" + Audio_Array_Path);
            this.future_URL =new URL(Audio_Path_Base +"future" + Audio_Array_Path);
            this.ggs_URL = new URL(Audio_Path_Base +"ggs" + Audio_Array_Path);
            this.poisonjam_URL = new URL(Audio_Path_Base +"poisonjam" + Audio_Array_Path);
            this.noisetanks_URL = new URL(Audio_Path_Base +"noisetanks" + Audio_Array_Path);
            this.loveshockers_URL = new URL(Audio_Path_Base +"loveshockers" + Audio_Array_Path);
            this.rapid99_URL = new URL(Audio_Path_Base +"rapid99" + Audio_Array_Path);
            this.immortals_URL =new URL(Audio_Path_Base +"immortals" + Audio_Array_Path);
            this.goldenrhinos_URL = new URL(Audio_Path_Base +"goldenrhinos" + Audio_Array_Path);
            this.doomriders_URL = new URL(Audio_Path_Base +"doomriders" + Audio_Array_Path);
            this.summer_URL = new URL(Audio_Path_Base + "summer" + Audio_Array_Path);
            try {
                this.LoadSongLists();//load songs
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        this.f3370s = LocalBroadcastManager.getInstance(getApplicationContext());
        this.mp = new MediaPlayer(); //make a media player

        this.mp.setAudioStreamType(3);
        this.mp.setWakeMode(getApplicationContext(), 1);
        this.f3372u = new Custom_BCR(this);
        registerReceiver(this.f3372u, this.f3371t);
        this.f3353b = new C12853(this);
        this.f3352a = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
        this.MediaSesh = new MediaSessionCompat(this.getBaseContext(),"MEDIA SESH");
        this.MediaController = new MediaControllerCompat(this.getBaseContext(),this.MediaSesh);
    }

    //Intent ACTION HANDLER
    private void Action_Handler(Intent intent) throws IOException, URISyntaxException {
        if (intent != null && intent.getAction() != null) {
            //CHECK IF STATION SWITCH
            if (intent.hasExtra("Station")) {
                station_count = intent.getIntExtra("Station", 0);
                Intent noteIntent = new Intent(this, NotificationService.class);
                noteIntent.setAction(Constants.ACTION.STOPFOREGROUND_ACTION);
                Intent serviceIntent = new Intent(this, NotificationService.class);
                serviceIntent.setAction(Constants.ACTION.STARTFOREGROUND_ACTION);
                startService(serviceIntent);
            }

            //CHECKING MEDIA STATE
            String action = intent.getAction();
            //ON PLAY

            if (action.equalsIgnoreCase("action_play")) {
                //nothing is here yet ;)
                if(!NotificationService.isIntentServiceRunning){
                    Intent serviceIntent = new Intent(this, NotificationService.class);
                    serviceIntent.setAction(Constants.ACTION.STARTFOREGROUND_ACTION);
                    startService(serviceIntent);
                }
                if(mp.isPlaying()){
                    mp.pause();
                }
                else{
                    mp.start();
                }
                isPlaying = true;
            }
            //ON PAUSE
            else if (action.equalsIgnoreCase("action_pause")) {
                if(!NotificationService.isIntentServiceRunning){
                    Intent serviceIntent = new Intent(this, NotificationService.class);
                    serviceIntent.setAction(Constants.ACTION.STARTFOREGROUND_ACTION);
                    startService(serviceIntent);
                }
                isPlaying = false;
                this.MediaController.getTransportControls().pause();

            }
            //ON NEXT
            else if (action.equalsIgnoreCase("action_next")) {

                if(!NotificationService.isIntentServiceRunning){
                    Intent serviceIntent = new Intent(this, NotificationService.class);
                    serviceIntent.setAction(Constants.ACTION.STARTFOREGROUND_ACTION);
                    startService(serviceIntent);
                }
                this.getNextSong();
                isPlaying = true;
                //mp.start();
                //playSong();
                 this.MediaController.getTransportControls().skipToNext();
            }
            //ON STOP
            else if (action.equalsIgnoreCase("action_stop")) {
                if(!NotificationService.isIntentServiceRunning){
                    Intent serviceIntent = new Intent(this, NotificationService.class);
                    serviceIntent.setAction(Constants.ACTION.STARTFOREGROUND_ACTION);
                    startService(serviceIntent);
                }
                isPlaying = false;
               mp.stop();
               mp.release();
                // this.MediaController.m1670a().mo278c();
            }

        }
    }

    //Kill the media player
    public void KillMediaPlayer(){
        if(mp!=null) {
            try {
                mp.stop();
                mp.release();
            }
            catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    //Play a song
    public void playSong(String url) throws IOException {
        KillMediaPlayer(); //kill previous media player
        this.mp = new MediaPlayer(); //make a new media player
        this.mp.setDataSource(url); //set new data source
        //when ready start
       this.mp.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {

            @Override
            public void onPrepared(MediaPlayer player) {
                player.start();
            }
        });
       //when complete stop and get the next song
        this.mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
               mp.stop();
                try {
                    getNextSong();
                } catch (URISyntaxException |MalformedURLException e) {
                    e.printStackTrace();
                }
            }
        });
        this.mp.prepareAsync(); //prepare the song async
    }

    //  private NotificationCompat m5852a(int i, String str, String str2) {
    //     Intent intent = new Intent(getApplicationContext(), MediaPlayerServ.class);
    //     intent.setAction(str2);
    //    // return new NotificationCompat(i, str, PendingIntent.getService(getApplicationContext(), 1, intent, 0)).m976a();
    // }

    @SuppressLint("WrongConstant")
 /*   private void m5857a(NotificationCompat c0253a) {
        C0254q c0649h = new C0649h();
        C0647b c0647b = (C0647b) new C0647b(this).m990a((int) R.drawable.ic_stat_graffitisoul).m993a(BitmapFactory.decodeResource(getResources(), R.drawable.profk)).m996a(this.currentSong.m5906b()).m999b(this.currentSong.m5905a()).m997a(false).m998b(1).m992a(PendingIntent.getActivity(getApplicationContext(), 0, new Intent(this, MainActivity.class), 134217728)).m995a(c0649h);
        c0647b.m994a(m5852a(R.drawable.ic_media_stop, "Stop", "action_stop"));
        c0647b.m994a(c0253a);
        c0647b.m994a(m5852a(17301538, "Next", "action_next"));
        c0649h.m2709a(0, 1, 2);
        Notification a = c0647b.m989a();
        a.flags |= 32;
        ((NotificationManager) getSystemService("notification")).notify(1, a);
    }
*/
 //on start
    public int onStartCommand(Intent intent, int i, int i2) {
        //Exception e;
        try {
            this.LoadSongLists();//load songs
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        if (intent != null) {
          // System.out.println("Yass fam");
            if (this.MediaSesh == null) {
                m5862b();
              //  this.f3349F = new Timer();
             //   this.f3349F.scheduleAtFixedRate(new C12864(this), 1000, 5000);
               // this.f3350G = new Timer();
             //   this.f3350G.scheduleAtFixedRate(new C12875(this), 0, 60000);
            }
            try {
                Action_Handler(intent);
            } catch (IOException e1) {
                e1.printStackTrace();
            } catch (URISyntaxException e) {
                e.printStackTrace();
            }
        }
        return 1;
    }

    private void m5862b() {
        this.MediaSesh = new MediaSessionCompat(getApplicationContext(), "Jet Set Radio Live!", new ComponentName(getPackageName(), MediaPlayerS.class.getName()), PendingIntent.getBroadcast(this, 99, new Intent("action_play"), 0));
        this.MediaController = new MediaControllerCompat(getApplicationContext(), this.MediaSesh);
        this.MediaSesh.setPlaybackToLocal(3);
        this.MediaSesh.setActive(true);
      //  this.MediaSesh. m1577a(new C12886(this));
    }

    //get the song lists
    private ArrayList<Song> getSongList(URL url) throws URISyntaxException, MalformedURLException {
        String Station;
        Exception e;
        String[] split;
        int i;
        String[] split2;
        DownloadAsync c1297b = new DownloadAsync();
        ArrayList<Song> arrayList = new ArrayList();
        String SongName = "";


        //get current URL from current station
        if (url.equals(this.poisonjam_URL)) {
            Station = "poisonjam";
        } else if (url.equals(this.loveshockers_URL)) {
            Station = "loveshockers";
        } else if (url.equals(this.noisetanks_URL)) {
            Station = "noisetanks";
        } else if (url.equals(this.rapid99_URL)) {
            Station = "rapid99";
        } else if (url.equals(this.immortals_URL)) {
            Station = "immortals";
        } else if (url.equals(this.goldenrhinos_URL)) {
            Station = "goldenrhinos";
        } else if (url.equals(this.doomriders_URL)) {
            Station = "doomriders";
        } else if (url.equals(this.future_URL)) {
            Station = "future";
        } else if (url.equals( this.ggs_URL)) {
            Station = "ggs";
        } else if (url.equals( this.classic_URL)) {
            Station = "classic";
        }else if (url.equals( this.summer_URL)) {
            Station = "summer";
        }
        else {
            Station = "ERROR";
        }
        try {
            SongName = c1297b.execute(url).get(); //get url async-ly
        } catch (InterruptedException e2) {
            e = e2;
            e.printStackTrace();
            SongName = null;
            if (SongName != null) {
                return null;
            }
            split = SongName.split(";");
            for (i = 0; i < split.length; i++) {
                split2 = split[i].split("\"");
                if (split2.length > 1) {
                    split[i] = split2[1];
                }
                try {
                    arrayList.add(new Song(split[i], new URI("http", "//jetsetradio.live/audioplayer/stations/" + Station + "/" + split[i] + ".mp3", null).toURL()));
                } catch (URISyntaxException |MalformedURLException e3) {
                   e3.printStackTrace();
                }
            }
            return arrayList;
        } catch (ExecutionException e6) {
            e = e6;
            e.printStackTrace();
            SongName = null;
            if (SongName != null) {
                return null;
            }
            split = SongName.split(";");
            for (i = 0; i < split.length; i++) {
                split2 = split[i].split("\"");
                if (split2.length > 1) {
                    split[i] = split2[1];
                }
                System.out.println(split[i]);
                arrayList.add(new Song(split[i], new URI("http", "//jetsetradio.live/audioplayer/stations/" + Station + "/" + split[i] + ".mp3", null).toURL()));
            }
            return arrayList;
        }

if(SongName != null) {



    split = SongName.split(";");
    for (i = 0; i < split.length; i++) {
        split2 = split[i].split("\"");
        if (split2.length > 1) {
            split[i] = split2[1];

        }
        split[i] = split[i].substring(0, split[i].length() - 1);
        //System.out.println(split[i]);
        String song = "";
        try {
            song = URLEncoder.encode(split[i], "UTF-8");
            //song = URLEncoder.encode(song,"UTF-8");
            //System.out.println(song);
        } catch (UnsupportedEncodingException e1) {
            e1.printStackTrace();
        }
        song = split[i];
        arrayList.add(new Song(split[i], new URI("http", "//jetsetradio.live/audioplayer/stations/" + Station + "/" + song + ".mp3", null).toURL()));
    }
}
        return arrayList;
    }

        public void LoadSongLists() throws URISyntaxException, MalformedURLException{

            if (this.classic_array == null) {
                this.classic_array = getSongList(this.classic_URL);
            }
            if (this.future_array == null) {
                this.future_array = getSongList(this.future_URL);
            }
            if (this.ggs_array == null) {
                this.ggs_array = getSongList(this.ggs_URL);
            }
            if (this.love_array == null) {
                this.love_array = getSongList(this.loveshockers_URL);
            }
            if (this.noise_array == null) {
                this.noise_array = getSongList(this.noisetanks_URL);
            }
            if (this.poison_array == null) {
                this.poison_array = getSongList(this.poisonjam_URL);
            }
            if (this.r99_array == null) {
                this.r99_array = getSongList(this.rapid99_URL);
            }
            if (this.immortals_array == null) {
                this.immortals_array = getSongList(this.immortals_URL);
            }
            if (this.gr_array == null) {
                this.gr_array = getSongList(this.goldenrhinos_URL);
            }
            if (this.doom_array == null) {
                this.doom_array = getSongList(this.doomriders_URL);
            }
            if (this.summer_array == null) {
                this.summer_array = getSongList(this.summer_URL);
            }
            //if (!this.f3369r) {
            if (this.summer_array == null ||this.future_array == null || this.ggs_array == null || this.classic_array == null || this.love_array == null || this.noise_array == null || this.poison_array == null || this.r99_array == null || this.immortals_array == null || this.gr_array == null || this.doom_array == null) {
                Log.e("DEBUG", "No Internet");
                Toast makeText = Toast.makeText(getApplicationContext(), "Unable to start playback\nNo internet detected.", Toast.LENGTH_LONG);
                //  @SuppressLint("ResourceType") TextView textView = (TextView) makeText.getView().findViewById(16908299);
                //  if (textView != null) {
                //      textView.setGravity(17);
                //  }
                makeText.show();
                return;
            }
            this.shuffle_array = new ArrayList<Song>();
            this.shuffle_array.addAll(this.classic_array);
            this.shuffle_array.addAll(this.future_array);
            this.shuffle_array.addAll(this.ggs_array);
            this.shuffle_array.addAll(this.noise_array);
            this.shuffle_array.addAll(this.love_array);
            this.shuffle_array.addAll(this.poison_array);
            this.shuffle_array.addAll(this.r99_array);
            this.shuffle_array.addAll(this.immortals_array);
            this.shuffle_array.addAll(this.gr_array);
            this.shuffle_array.addAll(this.doom_array);
            this.shuffle_array.addAll(this.summer_array);
        }


        public void getNextSong() throws MalformedURLException, URISyntaxException {
        System.out.println("CURRENT STATION IS... " + station_count);
          //  this.LoadSongLists();
        //System.out.println("FUKING CHRIST!1");
            if (this.currentSong == null) {
                switch (station_count) {
                    case 0:
                        this.currentSong =  this.shuffle_array.get(new Random().nextInt(this.shuffle_array.size()));
                        break;
                    case 1:
                        this.currentSong =  this.classic_array.get(new Random().nextInt(this.classic_array.size()));
                        break;
                    case 2:
                        this.currentSong =  this.future_array.get(new Random().nextInt(this.future_array.size()));
                        break;
                    case 3:
                        this.currentSong =  this.ggs_array.get(new Random().nextInt(this.ggs_array.size()));
                        break;
                    case 4:
                        this.currentSong =  this.poison_array.get(new Random().nextInt(this.poison_array.size()));
                        break;
                    case 5:
                        this.currentSong =  this.noise_array.get(new Random().nextInt(this.noise_array.size()));
                        break;
                    case 6:
                        this.currentSong =  this.love_array.get(new Random().nextInt(this.love_array.size()));
                        break;
                    case 7:
                        this.currentSong =  this.r99_array.get(new Random().nextInt(this.r99_array.size()));
                        break;
                    case 8:
                        this.currentSong =  this.immortals_array.get(new Random().nextInt(this.immortals_array.size()));
                        break;
                    case 9:
                        this.currentSong = this.doom_array.get(new Random().nextInt(this.doom_array.size()));
                        break;
                    case 10:
                        this.currentSong =  this.gr_array.get(new Random().nextInt(this.gr_array.size()));
                        break;
                    case 11:
                        this.currentSong =  this.summer_array.get(new Random().nextInt(this.summer_array.size()));
                        break;
                    default:
                        break;
                }
                //System.out.println("FUKING CHRIST!3");
                this.cachedSong = this.currentSong;
                //System.out.println(this.currentSong.toString());
                //this.cachedSong = null;
                //mp.reset();
            }

            try {


                playSong(this.cachedSong.m5907c().toString());
                this.currentSong = null;

            } catch (IOException e) {



            }

            this.f3369r = true;

    }

    private void m5858a(String str) {
        String str2;
        Song Song;
        Exception e;
        Log.e("DEBUG", str);
        Log.e("DEBUG", Html.fromHtml(str).toString());
        String[] split = str.split("/");
        if (split.length < 2) {
            str2 = str;
        } else {
            str2 = split[1];
        }
        try {
            System.out.println(str);
            Song = new Song(str2, new URI("http", "//jetsetradio.live/audioplayer/stations/" + str + ".mp3", null).toURL());
        } catch (MalformedURLException e2) {
            e = e2;
            e.printStackTrace();
            Song = null;
            if (Song == null) {
                Log.e("DEBUG", Song.toString());
                this.cachedSong = Song;
                this.cachedSong.m5908d();
                if (!this.mp.isPlaying()) {
                    // this.MediaController.m1670a().mo279d();
                }
            }
        } catch (URISyntaxException e3) {
            e = e3;
            e.printStackTrace();
            Song = null;
            if (Song == null) {
                Log.e("DEBUG", Song.toString());
                this.cachedSong = Song;
                this.cachedSong.m5908d();
                if (!this.mp.isPlaying()) {
                    //   this.MediaController.m1670a().mo279d();
                }
            }
        }
        if (Song == null) {
            Log.e("DEBUG", Song.toString());
            this.cachedSong = Song;
            this.cachedSong.m5908d();
            if (!this.mp.isPlaying()) {
                this.MediaController.getPlaybackState().notify();//  m1670a().mo279d();
            }
        }
    }

    //DJPK requests
    private void m5865c() {
     /*   CharSequence charSequence;
        Exception e;
        Pattern compile;
        Matcher matcher;
        DownloadAsync c1297b = new DownloadAsync();
        try {
            String url = new URL("http://jetsetradio.live/messages/messages.xml?100000000" + new Random().nextInt(900000000));
            charSequence = (String) c1297b.execute(new URL[]{url}).get();
        } catch (MalformedURLException e2) {
            e = e2;
            e.printStackTrace();
            charSequence = null;
            compile = Pattern.compile("<message>(.*?)</message>");
            if (charSequence != null) {
                matcher = compile.matcher(charSequence);
                if (!matcher.find()) {
                    if (matcher.group(1).contains("REQUEST")) {
                    }
                    if (!matcher.group(1).contains("SCREEN:")) {
                        return;
                    }
                    return;
                }
                return;
            }
        } catch (InterruptedException e3) {
            e = e3;
            e.printStackTrace();
            charSequence = null;
            compile = Pattern.compile("<message>(.*?)</message>");
            if (charSequence != null) {
                matcher = compile.matcher(charSequence);
                if (!matcher.find()) {
                    if (matcher.group(1).contains("REQUEST")) {
                    }
                    if (!matcher.group(1).contains("SCREEN:")) {
                        return;
                    }
                    return;
                }
                return;
            }
        } catch (ExecutionException e4) {
            e = e4;
            e.printStackTrace();
            charSequence = null;
            compile = Pattern.compile("<message>(.*?)</message>");
            if (charSequence != null) {
                matcher = compile.matcher(charSequence);
                if (!matcher.find()) {
                    if (matcher.group(1).contains("REQUEST")) {
                    }
                    if (!matcher.group(1).contains("SCREEN:")) {
                        return;
                    }
                    return;
                }
                return;
            }
        } catch (NullPointerException e5) {
            e = e5;
            e.printStackTrace();
            charSequence = null;
            compile = Pattern.compile("<message>(.*?)</message>");
            if (charSequence != null) {
                matcher = compile.matcher(charSequence);
                if (!matcher.find()) {
                    if (matcher.group(1).contains("REQUEST")) {
                    }
                    if (!matcher.group(1).contains("SCREEN:")) {
                        return;
                    }
                    return;
                }
                return;
            }
        }
        compile = Pattern.compile("<message>(.*?)</message>");
        if (charSequence != null) {
            matcher = compile.matcher(charSequence);
            if (!matcher.find()) {
                return;
            }
            if (matcher.group(1).contains("REQUEST") || matcher.group(1).equals(this.f3347D)) {
                if (!matcher.group(1).contains("SCREEN:") && !matcher.group(1).contains("SNAPSHOT:") && !matcher.group(1).contains("REQUEST:") && !this.f3348E.equalsIgnoreCase(matcher.group(1))) {
                    Intent intent = new Intent();
                    intent.setAction("JSRL.UPDATEUI");
                    intent.putExtra("Text", "DJ Professor K:\n" + matcher.group(1));
                    // this.f3370s.m1088a(intent);
                    this.f3348E = matcher.group(1);
                }
            } else if (this.shuffle_array != null) {
                this.f3347D = matcher.group(1);
                m5858a(matcher.group(1).substring(9));
            }
        }*/
    }

    public void onTaskRemoved(Intent intent) {
        Log.e("DEBUG", "onTaskRemoved");
        super.onTaskRemoved(intent);
        stopSelf();
    }

    @SuppressLint("WrongConstant")
    public void onDestroy() {
        Log.e("DEBUG", "onDestroy");
        unregisterReceiver(this.f3372u);
        this.f3352a.listen(this.f3353b, 0);
        ((NotificationManager) getApplicationContext().getSystemService("notification")).cancelAll();
        this.MediaSesh.release();
        this.mp.release();
        onTaskRemoved(new Intent());
    }

    public IBinder onBind(Intent intent) {
        Log.e("DEBUG", "onBind");
        return null;
    }

    public boolean onUnbind(Intent intent) {
        return super.onUnbind(intent);
    }
}
