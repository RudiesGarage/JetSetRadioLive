package com.jetsetradio.live.service

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.MediaDescriptionCompat
import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.session.MediaSessionCompat
import android.support.v4.media.session.PlaybackStateCompat
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.media.MediaBrowserServiceCompat
import com.jetsetradio.live.R
import com.jetsetradio.live.data.MusicLibrary
import kotlin.random.Random
import kotlin.random.Random.Default.nextInt


const val CUSTOM_ACTION_STATION_NEXT = "Station_Next"
const val CUSTOM_ACTION_CURRENT_SONG = "Music_Current"
const val CUSTOM_ACTION_MUSIC_NEXT = "Music_Next"
const val CUSTOM_ACTION_MUSIC_PLAY_PAUSE = "Music_Play_Pause"
const val CUSTOM_ACTION_SHUFFLE = "Station_Shuffle"
const val CUSTOM_ACTION_STATION_PREV = "Station_Prev"
const val CUSTOM_ACTION_STATION_SET = "Station_Set"
const val BUNDLE_UUID_KEY = "uuid"

class MusicService : MediaBrowserServiceCompat() {
    private var isServiceInStartedState = false
    private var isShuffle = false;
    private lateinit var musicSession: MediaSessionCompat
    private lateinit var playback: MusicPlayerAdapter
    private lateinit var musicNotificationManager: MusicNotificationManager

    override fun onCreate() {
        super.onCreate()
        setupMusicSession()
        setupPlayerAdapter()
        musicNotificationManager = MusicNotificationManager(this)
    }


    private fun setupMusicSession() {
        musicSession = MediaSessionCompat(this, TAG).apply {
            setFlags(MediaSessionCompat.FLAG_HANDLES_QUEUE_COMMANDS)
            setCallback(MusicSessionCallback())
        }
        sessionToken = musicSession.sessionToken
    }

    private fun setupPlayerAdapter() {
        val playbackStateChange: PlaybackStateCompat.() -> Unit = {
            musicSession.setPlaybackState(this) // Update current playback state.
            when (state) {
                PlaybackStateCompat.STATE_PLAYING -> moveNotificationToStartedState(this)
                PlaybackStateCompat.STATE_SKIPPING_TO_NEXT -> moveNotificationToStartedState(this)
                PlaybackStateCompat.STATE_PAUSED -> updateNotificationWhenStatePaused(this)
                PlaybackStateCompat.STATE_STOPPED -> stopServiceWhenStateStopped()
            }
        }

        val completionStateChange: MediaMetadataCompat.() -> Unit = {
            musicSession.setMetadata(this)
        }

        playback = MusicPlayerAdapter(context = this, playbackStateChange = playbackStateChange,playbackComplete = completionStateChange)

    }


    private fun moveNotificationToStartedState(playbackState: PlaybackStateCompat) {
        if (isServiceInStartedState.not()) {
            val serviceIntent = Intent(this, MusicService::class.java)
            ContextCompat.startForegroundService(this, serviceIntent)
            isServiceInStartedState = true
        }
        val notification = musicNotificationManager.getNotification(
                state = playbackState,
                token = sessionToken ?: return,
                description = playback.currentMetadata?.description ?: return
        )
        startForeground(MusicNotificationManager.NOTIFICATION_ID, notification)
    }

    private fun updateNotificationWhenStatePaused(playbackState: PlaybackStateCompat) {
        stopForeground(false)
        val notification = musicNotificationManager.getNotification(
                state = playbackState,
                token = sessionToken ?: return,
                description = playback.currentMetadata?.description ?: return
        )
        musicNotificationManager.notificationManager.notify(
                MusicNotificationManager.NOTIFICATION_ID, notification
        )
    }

    private fun stopServiceWhenStateStopped() {
        stopForeground(true)
        stopSelf()
        isServiceInStartedState = false
    }



    override fun onLoadChildren(parentId: String, result: Result<MutableList<MediaBrowserCompat.MediaItem>>) {
        result.sendResult(MusicLibrary.getMediaItems())
    }

    override fun onGetRoot(clientPackageName: String, clientUid: Int, rootHints: Bundle?): BrowserRoot? {
        return BrowserRoot(MusicLibrary.getRoot(), null)
    }

    companion object {
        private const val TAG = "MusicService"
    }

    private inner class MusicSessionCallback : MediaSessionCompat.Callback() {
        private var playedItemIndex: Int = -1 // Current song index in queue
        private val playList = mutableListOf<MediaSessionCompat.QueueItem>() // A "cache" of current songs
        private var prepareMusicMetadata: MediaMetadataCompat? = null // Current Song

        override fun onAddQueueItem(description: MediaDescriptionCompat?) {
            super.onAddQueueItem(description)
            description?.apply {
                val addedItem = MediaSessionCompat.QueueItem(this, this.hashCode().toLong())
                playList.add(addedItem)
                playedItemIndex = if (playedItemIndex == -1) {
                    0
                } else {
                    playedItemIndex
                }
                musicSession.setQueue(playList)
            }
            Log.d("MusicService_TAG", "music info: ${description?.title}")
        }

        override fun onRemoveQueueItem(description: MediaDescriptionCompat?) {
            super.onRemoveQueueItem(description)
            description?.apply {
                val removedItem = MediaSessionCompat.QueueItem(this, hashCode().toLong())
                playList.remove(removedItem)
                playedItemIndex = if (playList.isEmpty()) {
                    -1
                } else {
                    playedItemIndex
                }
                musicSession.setQueue(playList)
            }
        }


        override fun onPrepare() {
            super.onPrepare()
            if (playedItemIndex < 0 || playList.isEmpty()) {
                return
            }

            prepareMusicMetadata = MusicLibrary.getMusicMetadata(playedItemIndex)
            musicSession.setMetadata(prepareMusicMetadata)
            if (musicSession.isActive.not()) {
                musicSession.isActive = true
            }
        }

        override fun onPlay() {
            super.onPlay()
            if (playedItemIndex == -1 || playList.isEmpty()) {
                return
            }
            if (prepareMusicMetadata == null) {
                onPrepare()
            }
            prepareMusicMetadata?.also { playback.playFromMedia(it) }
        }

        override fun onPause() {
            super.onPause()
            playback.pause()
        }

        override fun onSeekTo(pos: Long) {
            super.onSeekTo(pos)
            playback.seekTo(pos)
        }

        // Handle Skip to next song request
        override fun onSkipToNext() {
            super.onSkipToNext()
            if(isShuffle){
                //when shuffle is active we only get the next song due to a bug in the slider
                val action = CUSTOM_ACTION_STATION_NEXT
                onCustomAction(action, null)
            }else {
                playedItemIndex = if (playedItemIndex < MusicLibrary.getNumSongs()?.minus(1) ?: 0) {
                    playedItemIndex + 1
                } else {
                    0
                }
            }
            prepareMusicMetadata = null
            onPlay()
        }

        // Handle Skip to previous song request
        override fun onSkipToPrevious() {
            super.onSkipToPrevious()
            if(isShuffle){
                //when shuffle is active we only get the next song due to a bug in the slider on getting a random position
                val action = CUSTOM_ACTION_STATION_PREV
                onCustomAction(action, null)
            }
            else{
                playedItemIndex = if (playedItemIndex > 0) {
                    playedItemIndex - 1
                } else {
                    playList.size - 1 // Index = 0, start the last media.
                }
            }
            prepareMusicMetadata = null
            onPlay()
        }

        // Custom Actions AKA STATION Handling
        override fun onCustomAction(action: String?, extras: Bundle?) {
            super.onCustomAction(action, extras)

            when(action){
                // Next Station
                CUSTOM_ACTION_STATION_NEXT -> {

                    MusicLibrary.nextStation()

                    playedItemIndex == 0
                    playList.clear()

                    val temp = MusicLibrary.getMediaItems()

                    if(isShuffle){
                        playedItemIndex = nextInt(0,temp.size-1)
                    }

                    if(temp.size>=30){
                        for(i in 0 until 30){
                            onAddQueueItem(temp[i].description)
                        }
                    }
                    else{
                        for(i in 0 until temp.size){
                            onAddQueueItem(temp[i].description)
                        }
                    }

                    prepareMusicMetadata = null
                    onPause()
                    musicSession.isActive = false
                    onPrepare()

                }
                // Get Previous Station
                CUSTOM_ACTION_STATION_PREV -> {

                    //Clear the playlist
                    playedItemIndex == 0
                    playList.clear()


                    // fetch the previous station data
                    val temp = MusicLibrary.prevStation()
                    if(isShuffle){
                        playedItemIndex = nextInt(0,temp.size-1)
                    }
                    // if the station is too large only load 30 songs
                    if(temp.size>=30){
                        for(i in 0 until 30){
                            onAddQueueItem(temp[i].description)
                        }
                    }
                    // otherwise load all the songs
                    else{
                        for(i in 0 until temp.size){
                            onAddQueueItem(temp[i].description)
                        }
                    }

                    // clear the current song
                    prepareMusicMetadata = null
                    onPause()

                    musicSession.isActive = false

                    // prep the new station
                    onPrepare()
                }
                CUSTOM_ACTION_STATION_SET ->{
                    //Clear the playlist
                    playedItemIndex == 0
                    playList.clear()

                    val station = extras?.getInt("STATION_POSITION")

                    // fetch the station data
                    val temp = station?.let { MusicLibrary.anyStation(it) }

                    // if the station is too large only load 30 songs
                    if (temp != null) {
                        if (!this.playList.isNullOrEmpty()) {
                            this.playList.forEach { onRemoveQueueItem(it.description) }
                        }
                        if(isShuffle){
                            playedItemIndex = nextInt(0,temp.size-1)
                        }

                        if(temp.size>=30){
                            for(i in 0 until 30){
                                onAddQueueItem(temp[i].description)
                            }
                        }
                        // otherwise load all the songs
                        else{
                            for(i in 0 until temp.size){
                                onAddQueueItem(temp[i].description)
                            }
                        }
                    }

                    // clear the current song
                    prepareMusicMetadata = null
                    onPause()

                    musicSession.isActive = false

                    // prep the new station
                    onPrepare()
                }
                CUSTOM_ACTION_SHUFFLE -> {
                    isShuffle = !isShuffle

                }
            }

        }


    }
}

