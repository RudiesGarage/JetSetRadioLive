package com.example.dem.jetsetradiolive;


import android.annotation.SuppressLint;
import android.app.ActivityManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Objects;
import info.hoang8f.android.segmented.SegmentedGroup;
import static com.example.dem.jetsetradiolive.MediaPlayerServiceManager.ACTION_INTERNET;
import static com.example.dem.jetsetradiolive.MediaPlayerServiceManager.ACTION_NEXT;
import static com.example.dem.jetsetradiolive.MediaPlayerServiceManager.ACTION_STATION;
import static com.example.dem.jetsetradiolive.MediaPlayerServiceManager.ACTION_UI;


//This handles everything in the radio Fragment
public class RadioFragment extends Fragment {
    private String Station = "shuffle"; //current station being played
    private Context ctx;
    private Intent mMediaplayerServiceIntent;
    public boolean status = false;
    private TextView SongTitle;
    private TextView SongArtist;


    //On start of radio fragment...
    public void onStart() {
        super.onStart(); //start
    }

    //broadcastreciever to know when to update the ui
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            updateUI(intent);
        }
    };

    //update the ui
    private void updateUI(Intent intent) {
        String action = intent.getAction();

        switch(action){

            //update the new song on the string
            case ACTION_UI:
                String counter = intent.getStringExtra("TITLE");
                String time = intent.getStringExtra("ARTIST");
                SongTitle.setText(counter);
                SongArtist.setText(time);
                break;

            //send the toast
            case ACTION_INTERNET:
                Toast.makeText(getContext(), "No Internet Detected! The Noise Tanks must be behind this!", Toast.LENGTH_SHORT).show();
                break;
        }
    }




    //when view is created...
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ctx = getContext();

        final ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.fragment_radio, viewGroup, false);
        SongTitle = viewGroup2.findViewById(R.id.songtitle);
        SongArtist = viewGroup2.findViewById(R.id.songartist);
        //set layout to radio fragment
       // ImageView image = (ImageView)viewGroup2.findViewById(R.id.StationLogo);
        viewGroup2.setOnClickListener(new View.OnClickListener(){

            @SuppressLint("NewApi")
            @Override
            public void onClick(View v) {
                Log.e("ONCLICK","VIEW");
                mMediaplayerServiceIntent = new Intent(ctx,MediaPlayerServiceManager.class);

                mMediaplayerServiceIntent.setAction(ACTION_NEXT);
                mMediaplayerServiceIntent.putExtra("NEXT","TRUE"); //Extra to determine if the next button was hit
                mMediaplayerServiceIntent.putExtra("STATION",Station);
                Objects.requireNonNull(getContext()).startService(mMediaplayerServiceIntent);
            }
        });


        //Declare buttons
        final SegmentedGroup segmentedGroup = viewGroup2.findViewById(R.id.segmented1); //row 1
        final SegmentedGroup segmentedGroup2 =  viewGroup2.findViewById(R.id.segmented2);//row 2
        final SegmentedGroup segmentedGroup3 = viewGroup2.findViewById(R.id.segmented3); //row 3
        final SegmentedGroup segmentedGroup4 = viewGroup2.findViewById(R.id.segmented4); //row 4

        segmentedGroup4.check(R.id.Shuffle); //make shuffle checked by default

        //Set button listeners
        segmentedGroup.setOnCheckedChangeListener(new RadioButtonListener(this,segmentedGroup,segmentedGroup2,segmentedGroup3,segmentedGroup4,1,viewGroup2));
        segmentedGroup2.setOnCheckedChangeListener(new RadioButtonListener(this,segmentedGroup,segmentedGroup2,segmentedGroup3,segmentedGroup4,2,viewGroup2));
        segmentedGroup3.setOnCheckedChangeListener(new RadioButtonListener(this,segmentedGroup,segmentedGroup2,segmentedGroup3,segmentedGroup4,3,viewGroup2));
        segmentedGroup4.setOnCheckedChangeListener(new RadioButtonListener(this,segmentedGroup,segmentedGroup2,segmentedGroup3,segmentedGroup4,4,viewGroup2));


        mMediaplayerServiceIntent = new Intent(ctx, MediaPlayerServiceManager.class);
        mMediaplayerServiceIntent.setAction("Initialize");

        if (!isMyServiceRunning(MediaPlayerServiceManager.class)) {
            ctx.startService(mMediaplayerServiceIntent);
        }
        ctx.registerReceiver(broadcastReceiver, new IntentFilter(MediaPlayerServiceManager.ACTION_UI));
        return viewGroup2;
    }

    //check if service is running
    private boolean isMyServiceRunning(Class<?> serviceClass) {
        ActivityManager manager = (ActivityManager) getContext().getSystemService(Context.ACTIVITY_SERVICE);
        for (ActivityManager.RunningServiceInfo service : manager.getRunningServices(Integer.MAX_VALUE)) {
            if (serviceClass.getName().equals(service.service.getClassName())) {
                Log.i ("isMyServiceRunning?", true+"");
                return true;
            }
        }
        Log.i ("isMyServiceRunning?", false+"");
        return false;
    }

    //when activity is created
    public void onActivityCreated(Bundle bundle) {
        Log.e("FRAGMENT", "Activity Created");
        super.onActivityCreated(bundle);
    }

    //on create
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }


    //Set the current station
    public void setStation(int stationid){
        //convert the passed station int to string
        String Station = IDtoString(stationid);

        System.out.println("Station buttton pressed: " + Station);

        if(!this.Station.equals(Station)){
            this.Station = Station;
            //pass the intnet to the Service Manager
            mMediaplayerServiceIntent = new Intent(ctx,MediaPlayerServiceManager.class);
            mMediaplayerServiceIntent.putExtra("STATION",Station);
            mMediaplayerServiceIntent.setAction(ACTION_STATION);
            ctx.startService(mMediaplayerServiceIntent); //recalls onStartCommand for the given intent
            //send to mediaplayerservice
        }
        else {
            System.out.println("They are the same");
        }
    }


    //Converts a given reference ID to a string class
    private String IDtoString(int id){
        switch(id){
            case R.id.Classic:
                return "classic";
            case R.id.Future:
                return "future";
            case R.id.PoisonJam:
                return "poisonjam";
            case R.id.NoiseTanks:
                return "noisetanks";
            case R.id.LoveShockers:
                return "loveshockers";
            case R.id.Rapid99:
                return "rapid99";
            case R.id.Immortals:
                return "immortals";
            case R.id.DoomRiders:
                return "doomriders";
            case  R.id.GoldenRhinos:
                return "goldenrhinos";
            case  R.id.Summer:
                return "summer";
            default:
                return "shuffle";
        }
    }

    //on destroy
    public void onDestroy() {
        Log.e("DEBUG", "OnDestroy!");


        getContext().stopService(mMediaplayerServiceIntent);

        super.onDestroy();
    }




}
