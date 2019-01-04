package com.example.dem.jetsetradiolive;

import android.app.IntentService;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import java.util.Random;

import static com.example.dem.jetsetradiolive.MediaPlayerServiceManager.ACTION_REC;


//THIS HANDLES ALL DATABASE CONNECTIVITY
public class Firebase_Controller extends IntentService {
    private int waitingIntentCount = 0;


    public Firebase_Controller() {
        super("FBC");
    }

    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public Firebase_Controller(String name) {
        super(name);
    }


    //This fetches and sends Song data to MediaPlayerService
    private void sendSong(final String station) {

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference(station+"/"); //Dont pass any path if you want root of the tree

        Random randomGenerator = new Random();

        int index = randomGenerator.nextInt(getPlaylistSize(station));

        Query query = mDatabase.child(""+index);

        //fetch data
        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                String url = dataSnapshot.child("url").getValue(String.class);
                String Title = dataSnapshot.child("songTitle").getValue(String.class);
                String author = dataSnapshot.child("artist").getValue(String.class);
                Song chosenSong = new Song(url,Title,author,station);

                Log.d("CHOSEN SONG",chosenSong.getURL());

                //send data
                Intent intent = new Intent(getApplicationContext(), MediaPlayerServiceManager.class);
                intent.putExtra("SONG",chosenSong);
                intent.setAction(ACTION_REC);
                startService(intent);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                System.out.println("The read failed: " + databaseError.getCode());
            }
        });
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

   // @Override
    protected void onHandleIntent(Intent intent) {
        if(!intent.getStringExtra("STATION").equals(null)){
            sendSong(getStation(intent.getStringExtra("STATION")));
            waitingIntentCount--;
        }
    }

    public int getPlaylistSize(String Station){
        switch(Station){
            case "classic":
                return 25;
            case "future":
                return 31;
            case "ggs":
                return 746;
            case "poisonjam":
                return 257;
            case "noisetanks":
                return 433;
            case "loveshockers":
                return 202;
            case "rapid99":
                return 137;
            case "immortals":
                return 118;
            case "doomriders":
                return 184;
            case "goldenrhinos":
                return 382;
            case "summer":
                return 48;
        }
        return 0;
    }


    //get proper station from
    public String getStation(String tmpStation){
        if(tmpStation.equals("shuffle")){
            Random randomGenerator = new Random();
            //System.out.println(songlist.size());
            int index = randomGenerator.nextInt(11); //including zero, excluding 11
            switch(index){
                case 0:
                    tmpStation = "classic";
                    break;
                case 1:
                    tmpStation = "future";
                    break;
                case 2:
                    tmpStation = "ggs";
                    break;
                case 3:
                    tmpStation = "poisonjam";
                    break;
                case 4:
                    tmpStation = "noisetanks";
                    break;
                case 5:
                    tmpStation = "loveshockers";
                    break;
                case 6:
                    tmpStation = "rapid99";
                    break;
                case 7:
                    tmpStation = "immortals";
                    break;
                case 8:
                    tmpStation = "doomriders";
                    break;
                case 9:
                    tmpStation = "goldenrhinos";
                    break;
                case 10:
                    tmpStation = "summer";
                    break;
                default:
                    //if some bit error occurs then pick classic
                    tmpStation = "classic";
                    break;
            }
        }
        Log.d("MEDIAPLAYERSERVICE.SONG",tmpStation);
        return tmpStation;
    }

    public void onTaskRemoved(Intent rootIntent) {

        //unregister listeners
        //do any other cleanup if required
        //stop service
        stopSelf();
    }


    @Override
    public int onStartCommand (Intent intent, int flags, int startId){

        Log.d("QUEUE Length:",""+ waitingIntentCount);
        String origin = intent.getStringExtra("ORIGIN"); //this extra must all ways be passed

        switch(origin){
            case "NewSongRequest":
                if(waitingIntentCount>=1){
                    stopSelf();
                }
            default:

                break;
        }

        super.onStart(intent, startId);
        return START_STICKY;
    }




}
