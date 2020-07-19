package com.jetsetradio.live.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.media.AudioAttributes
import android.media.AudioFocusRequest
import android.media.AudioManager
import android.media.MediaPlayer
import android.os.Build
import android.os.SystemClock
import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.session.PlaybackStateCompat
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.jetsetradio.live.data.MusicLibrary
import com.jetsetradio.live.extensions.MEDIA_URI
import java.io.IOException

/*
Music Player Adapter

Handles the MediaPlayer State-Machine
 */

class MusicPlayerAdapter(
    private val context: Context,
    private val playbackStateChange: (PlaybackStateCompat) -> Unit, // Notification action
    private val playbackComplete: (MediaMetadataCompat) -> Unit?
)  {
    private val applicationContext = this.context.applicationContext
    private val audioManager = applicationContext.getSystemService(Context.AUDIO_SERVICE) as AudioManager
    private var isAudioNoisyReceiverRegistered = false

    private var isPlayWhenAudioFocus = false
    private var mPlaybackDelayed = true
    private var mResumeOnFocusGain = true
    private val mFocusLock = Any() // a lock to check if we do have focus




    // MediaPlayer might be in Paused (not playing) and is called MediaPlayer.seekTo()
    private var seekWhileNotPlaying = -1L
    private var isMediaCompleted: Boolean = false

    //CURRENT SONG DATA
    var currentMetadata: MediaMetadataCompat? = null

    private var playbackStateCode: Int = PlaybackStateCompat.STATE_NONE
    private var mediaPlayer: MediaPlayer? = null
    private var isPreparing: Boolean = false



    // Broadcast Receiver to handle other Audio Apps
    private val audioNoisyReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (AudioManager.ACTION_AUDIO_BECOMING_NOISY == intent?.action && isPlaying()) {
                pause()
            }
        }
    }

    // Register the Noisy receiver
    private fun registerAudioNoisyReceiver() {
        if (isAudioNoisyReceiverRegistered.not()) {
            val audioNoisyIntentFilter = IntentFilter(AudioManager.ACTION_AUDIO_BECOMING_NOISY)
            applicationContext.registerReceiver(audioNoisyReceiver, audioNoisyIntentFilter)
            isAudioNoisyReceiverRegistered = true
        }
    }

    // Handle the Focus changes
    private val audioFocusChangeListener = AudioManager.OnAudioFocusChangeListener { focusChange ->
        when (focusChange) {

            // When this app is allowed to play
            AudioManager.AUDIOFOCUS_GAIN ->{

                if (mPlaybackDelayed || mResumeOnFocusGain) {
                    synchronized (mFocusLock) {
                        mPlaybackDelayed = false;
                        mResumeOnFocusGain = false;
                    }
                    play()
                }
            }

            // When some other app begins to play
            AudioManager.AUDIOFOCUS_LOSS->{
                synchronized (mFocusLock) {
                    // this is not a transient loss, we shouldn't automatically resume for now
                    mResumeOnFocusGain = false;
                    mPlaybackDelayed = false;
                }
                pause();
            }

            // When some other app begins to play but we are allowed to play softly
            AudioManager.AUDIOFOCUS_LOSS_TRANSIENT,
            AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK->{
                // we handle all transient losses the same way because we never duck audio books
                synchronized (mFocusLock) {
                    // we should only resume if playback was interrupted
                    mResumeOnFocusGain = mediaPlayer?.isPlaying ?: false
                    mPlaybackDelayed = false;
                }
                pause();
            }
        }
    }


    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    private val mPlaybackAttributes = AudioAttributes.Builder()
            .setUsage(AudioAttributes.USAGE_MEDIA)
            .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
            .build()

   // Focus Request Handler as of version O
    @RequiresApi(Build.VERSION_CODES.O)
    private val mFocusRequest = AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN)
            .setAudioAttributes(mPlaybackAttributes)
            .setAcceptsDelayedFocusGain(true)
            .setWillPauseWhenDucked(true)
            .setOnAudioFocusChangeListener(audioFocusChangeListener)
            .build();

    private fun setNewPlaybackStateCode(@PlaybackStateCompat.State newPlaybackState: Int) {
        playbackStateCode = newPlaybackState
        if (playbackStateCode == PlaybackStateCompat.STATE_STOPPED) {
            isMediaCompleted = true
        }
        val currentPosition: Long
        if (seekWhileNotPlaying >= 0) {
            currentPosition = seekWhileNotPlaying
            if (playbackStateCode == PlaybackStateCompat.STATE_PLAYING) {
                seekWhileNotPlaying = -1
            }
        } else {
            currentPosition = mediaPlayer?.currentPosition?.toLong() ?: 0
        }
        val stateBuilder = PlaybackStateCompat.Builder()
            .setActions(getAvailableAction())
            .setState(playbackStateCode, currentPosition, 1F, SystemClock.elapsedRealtime())
        playbackStateChange.invoke(stateBuilder.build())
    }

    private fun getAvailableAction(): Long {
        var action = PlaybackStateCompat.ACTION_PLAY_FROM_MEDIA_ID or
                PlaybackStateCompat.ACTION_PLAY_FROM_SEARCH or
                PlaybackStateCompat.ACTION_SKIP_TO_PREVIOUS or
                PlaybackStateCompat.ACTION_SKIP_TO_NEXT
        when (playbackStateCode) {
            PlaybackStateCompat.STATE_PLAYING -> {
                action = action or PlaybackStateCompat.ACTION_PAUSE or
                        PlaybackStateCompat.ACTION_STOP or
                        PlaybackStateCompat.ACTION_SEEK_TO
            }
            PlaybackStateCompat.STATE_PAUSED -> {
                action = action or PlaybackStateCompat.ACTION_PLAY or
                        PlaybackStateCompat.ACTION_STOP
            }
            PlaybackStateCompat.STATE_STOPPED -> {
                action = action or PlaybackStateCompat.ACTION_PLAY or
                        PlaybackStateCompat.ACTION_PAUSE
            }
            else -> {
                action = action or PlaybackStateCompat.ACTION_PLAY or
                        PlaybackStateCompat.ACTION_PLAY_PAUSE or
                        PlaybackStateCompat.ACTION_STOP or
                        PlaybackStateCompat.ACTION_PAUSE or
                        PlaybackStateCompat.ACTION_SKIP_TO_NEXT
            }
        }
        return action
    }


    private fun releaseMediaPlayer() {
        mediaPlayer?.also {
            it.reset()
            it.release()
            mediaPlayer = null
        }
    }

     fun isPlaying(): Boolean = mediaPlayer?.isPlaying ?: false

     fun seekTo(position: Long) {
        mediaPlayer?.apply {
            if (isPlaying.not()) {
                seekWhileNotPlaying = position
            }
            this.seekTo(position.toInt())
            // Set the new state (to the current state) because the position changed and should be reported to clients.
            setNewPlaybackStateCode(playbackStateCode)
        }
    }


     fun playFromMedia(metadata: MediaMetadataCompat) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val res: Int = audioManager.requestAudioFocus(mFocusRequest)
            synchronized(mFocusLock) {
                when (res) {
                    AudioManager.AUDIOFOCUS_REQUEST_FAILED -> {
                        mPlaybackDelayed = false
                    }
                    AudioManager.AUDIOFOCUS_REQUEST_GRANTED -> {
                        mPlaybackDelayed = false
                        playFile(metadata)
                    }
                    AudioManager.AUDIOFOCUS_REQUEST_DELAYED -> {
                        mPlaybackDelayed = true
                    }
                }
            }
        }
        else{
            mPlaybackDelayed = false
            playFile(metadata)
        }
    }


    private fun playFile(metadata: MediaMetadataCompat) {

        var isMediaChanged = currentMetadata?.MEDIA_URI ?: ""  != metadata.MEDIA_URI
        currentMetadata = metadata // set current song to the new song even if it is the same

        if (isMediaCompleted) {
            // research to end of MediaPlayer
            // Last audio file was played to completion, the resourceId hasn't been changed.
            // But the player was released, so force a reload of the media file for playback.
            isMediaChanged = true
            isMediaCompleted = false
        }
        if (isMediaChanged.not()) {
            if (!isPlaying() && !isPreparing) {
                play()
            }
            return
        }
        //Release the existing player
        releaseMediaPlayer()

        // Play new media file
        initializeMediaPlayer()

        mediaPlayer?.apply {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                setAudioAttributes(mPlaybackAttributes)
            }
            else{
                setAudioStreamType(AudioManager.STREAM_MUSIC)
            }

            try{
                setDataSource(currentMetadata!!.MEDIA_URI)
                isPreparing = true
                prepareAsync()
                Toast.makeText(applicationContext, "Loading Next Track...", Toast.LENGTH_SHORT).show()

            }catch (e: IOException) {
                Toast.makeText(applicationContext, "Cannot load track. The Noise Tanks may be behind this!", Toast.LENGTH_SHORT).show();
                e.printStackTrace();
            }
        }
    }




    private fun initializeMediaPlayer() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer().apply {
                setOnCompletionListener{


                    val nextsong = currentMetadata?.description?.mediaId?.let { it1 -> MusicLibrary.getNextMusicFileName(it1) }
                    if (nextsong != null) {
                        playFromMedia(nextsong)
                    }

                    currentMetadata?.let { it1 -> playbackComplete.invoke(it1) }

                    // Set the state to "Paused" because it most closely matches the state of MediaPlayer
                    // with regards to available state transitions compared to "Stop".
                    // "Paused" state allows: seekTo(), start(), pause(), stop().
                    // "Stop" state allows: stop().
//                    next()
                    setNewPlaybackStateCode(PlaybackStateCompat.STATE_SKIPPING_TO_NEXT)
                }

                //mp3 will be started after completion of preparing...
                setOnPreparedListener {
                    if(it != null){
                        isPreparing = false
                        start()
                        setNewPlaybackStateCode(PlaybackStateCompat.STATE_PLAYING)
                    }
                }
            }
        }
    }

    // Play the track.
    private fun play() {
        //Handle Version Differences for Audio focus
        val musicFocusState: Int = if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            audioManager.requestAudioFocus(
                    audioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN
            )
        } else {
            audioManager.requestAudioFocus(mFocusRequest)
        }

        // If we are given audio focus then register receiver, start the media player, and set playback state
        if (AudioManager.AUDIOFOCUS_REQUEST_GRANTED == musicFocusState) {
            registerAudioNoisyReceiver()
            mediaPlayer?.apply {
                if (isPlaying.not() || isPreparing) {
                    start()
                    setNewPlaybackStateCode(PlaybackStateCompat.STATE_PLAYING)
                }
            }
        }
    }

    // Pause the mediaPlayer, give up Audio focus, and set playback state
    fun pause() {
        if (isPlayWhenAudioFocus.not()) {
            abandonMediaAudioFocus()
        }
        unregisterAudioNoisyReceiver()
        mediaPlayer?.apply {
            if (isPlaying) {
                pause()
                setNewPlaybackStateCode(PlaybackStateCompat.STATE_PAUSED)
            }
        }
    }

    // Release and unregister everything
    fun stop() {
        abandonMediaAudioFocus()
        unregisterAudioNoisyReceiver()
        setNewPlaybackStateCode(PlaybackStateCompat.STATE_STOPPED)
        releaseMediaPlayer()
    }


    private fun abandonMediaAudioFocus() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            audioManager.abandonAudioFocusRequest(mFocusRequest)
        } else {
            audioManager.abandonAudioFocus(audioFocusChangeListener)
        }
    }


    private fun unregisterAudioNoisyReceiver() {
        if (isAudioNoisyReceiverRegistered) {
            applicationContext.unregisterReceiver(audioNoisyReceiver)
            isAudioNoisyReceiverRegistered = false
        }
    }
}




