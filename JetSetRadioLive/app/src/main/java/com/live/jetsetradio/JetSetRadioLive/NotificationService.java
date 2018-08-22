package com.live.jetsetradio.JetSetRadioLive;

import android.graphics.drawable.Icon;
import android.os.IBinder;
import android.app.Service;
import android.content.Intent;
import android.support.v4.app.ActivityCompat;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.app.Notification;
import android.app.PendingIntent;
import android.util.Log;
import android.view.View;
import android.widget.RemoteViews;

//Notification Class
public class NotificationService extends Service {
    public static boolean isIntentServiceRunning = false; //checks if the intnet is running
    Notification status;
    private final String LOG_TAG = "NotificationService";



    //when called upon
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        //on start
        if (intent.getAction() != null && intent.getAction().equals(Constants.ACTION.STARTFOREGROUND_ACTION)) {
            showNotification();
            isIntentServiceRunning = true;

        }

        //on end
        else if (intent.getAction().equals(Constants.ACTION.STOPFOREGROUND_ACTION)) {
            Log.i(LOG_TAG, "Received Stop Foreground Intent");
            stopForeground(true); //kill notification
            stopSelf(); //kill intent
        }
        return START_STICKY;
    }
    //on destroy
    @Override
    public void onDestroy() {
        super.onDestroy();
        isIntentServiceRunning = false; //notification is not running
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }


    private void showPlayingNotification(){
        RemoteViews bigViews = new RemoteViews(getPackageName(), R.layout.status_bar_expanded);
        bigViews.setImageViewBitmap(R.id.status_bar_album_art,
                Constants.getDefaultAlbumArt(this));

        //set notification intent
        Intent notificationIntent = new Intent(this, MainActivity.class);
        notificationIntent.setAction(Constants.ACTION.MAIN_ACTION);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        //set pending intent for notifications
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
                notificationIntent, 0);

        //previous button intent
        Intent previousIntent = new Intent(this, NotificationService.class);
        previousIntent.setAction(Constants.ACTION.PREV_ACTION);
        PendingIntent ppreviousIntent = PendingIntent.getService(this, 0,
                previousIntent, 0);

        //play button intent
        Intent playIntent = new Intent(this, MediaPlayerS.class);
        playIntent.setAction("action_play");
        // playIntent.setAction("change_icon");
        PendingIntent pplayIntent = PendingIntent.getService(this, 0,
                playIntent, 0);


        //next button intent
        Intent nextIntent = new Intent(this, MediaPlayerS.class);
        nextIntent.putExtra("action_next",false);
        PendingIntent pnextIntent = PendingIntent.getService(this, 0,
                nextIntent, 0);

        //close button intent
        Intent closeIntent = new Intent(this, NotificationService.class);
        closeIntent.setAction(Constants.ACTION.STOPFOREGROUND_ACTION);
        PendingIntent pcloseIntent = PendingIntent.getService(this, 0,
                closeIntent, 0);

        //Set intents to corresponding buttons
        bigViews.setOnClickPendingIntent(R.id.status_bar_play, pplayIntent);

        bigViews.setOnClickPendingIntent(R.id.status_bar_next, pnextIntent);

        bigViews.setOnClickPendingIntent(R.id.status_bar_prev, ppreviousIntent);

        bigViews.setOnClickPendingIntent(R.id.status_bar_collapse, pcloseIntent);


        bigViews.setImageViewResource(R.id.status_bar_play, R.drawable.apollo_holo_dark_pause);

        //set Texts
        bigViews.setTextViewText(R.id.status_bar_track_name, "Song Title");
        bigViews.setTextViewText(R.id.status_bar_artist_name, "Artist Name");
        bigViews.setTextViewText(R.id.status_bar_station_name, "Station Name");


        status = new Notification.Builder(this).build();
        status.priority = status.PRIORITY_MAX; //set to first icon
        status.bigContentView = bigViews; //set to extended view
        status.flags = Notification.FLAG_ONGOING_EVENT;
        status.icon = R.drawable.profk; //set notification icon to DJPK
        status.contentIntent = pendingIntent;
        startForeground(Constants.NOTIFICATION_ID.FOREGROUND_SERVICE, status);
    }

    private void showNotification() {
        // Using RemoteViews to bind custom layouts into Notification
        RemoteViews bigViews = new RemoteViews(getPackageName(), R.layout.status_bar_expanded);
        RemoteViews views = new RemoteViews(getPackageName(), R.layout.status_bar);

        views.setViewVisibility(R.id.status_bar_icon, View.VISIBLE);
        views.setViewVisibility(R.id.status_bar_album_art, View.GONE);

        // showing default album image
        bigViews.setImageViewBitmap(R.id.status_bar_album_art,
                Constants.getDefaultAlbumArt(this));

        //set notification intent
        Intent notificationIntent = new Intent(this, MainActivity.class);
        //notificationIntent.setAction(Constants.ACTION.MAIN_ACTION);
        notificationIntent.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT); //flag to bring activity to the front when touching the notification bar

        //set pending intent for notifications
      PendingIntent pendingIntent = PendingIntent.getActivity(this, 0,
              notificationIntent, 0);

        //previous button intent
        Intent previousIntent = new Intent(this, NotificationService.class);
        previousIntent.setAction(Constants.ACTION.PREV_ACTION);
        PendingIntent ppreviousIntent = PendingIntent.getService(this, 0,
                previousIntent, 0);

        //play button intent
        Intent playIntent = new Intent(this, MediaPlayerS.class);
        playIntent.setAction("action_play");
       // playIntent.setAction("change_icon");
        PendingIntent pplayIntent = PendingIntent.getService(this, 0,
                playIntent, 0);


        //next button intent
        Intent nextIntent = new Intent(this, MediaPlayerS.class);
        nextIntent.setAction("action_next");
        PendingIntent pnextIntent = PendingIntent.getService(this, 0,
                nextIntent, 0);

        //close button intent
        Intent closeIntent = new Intent(this, NotificationService.class);
        closeIntent.setAction(Constants.ACTION.STOPFOREGROUND_ACTION);
        PendingIntent pcloseIntent = PendingIntent.getService(this, 0,
                closeIntent, 0);

        //Set intents to corresponding buttons
        bigViews.setOnClickPendingIntent(R.id.status_bar_play, pplayIntent);
        views.setOnClickPendingIntent(R.id.status_bar_play, pplayIntent);
        bigViews.setOnClickPendingIntent(R.id.status_bar_next, pnextIntent);
        views.setOnClickPendingIntent(R.id.status_bar_next, pnextIntent);
        bigViews.setOnClickPendingIntent(R.id.status_bar_prev, ppreviousIntent);
        views.setOnClickPendingIntent(R.id.status_bar_prev, ppreviousIntent);
        bigViews.setOnClickPendingIntent(R.id.status_bar_collapse, pcloseIntent);
        views.setOnClickPendingIntent(R.id.status_bar_collapse, pcloseIntent);

        bigViews.setImageViewResource(R.id.status_bar_play, R.drawable.apollo_holo_dark_play);

        //set Texts
        bigViews.setTextViewText(R.id.status_bar_track_name, "Song Title");
        bigViews.setTextViewText(R.id.status_bar_artist_name, "Artist Name");
        bigViews.setTextViewText(R.id.status_bar_station_name, "Station Name");
        views.setTextViewText(R.id.status_bar_track_name, "Song Title");
        views.setTextViewText(R.id.status_bar_artist_name, "Artist Name");

        status = new Notification.Builder(this).build();
        status.contentView = views;
        status.priority = status.PRIORITY_MAX; //set to first icon
        status.bigContentView = bigViews; //set to extended view
        status.flags = Notification.FLAG_ONGOING_EVENT;
        status.icon = R.mipmap.ic_launcher; //set notification icon to DJPK
        status.contentIntent = pendingIntent;
        startForeground(Constants.NOTIFICATION_ID.FOREGROUND_SERVICE, status);
    }
}