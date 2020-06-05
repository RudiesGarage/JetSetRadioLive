package com.jetsetradio.live.service

import android.content.Context
import android.media.MediaPlayer
import android.net.Uri
import android.os.SystemClock
import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.session.PlaybackStateCompat
import com.jetsetradio.live.data.MusicLibrary
import com.jetsetradio.live.extensions.MEDIA_URI
import com.jetsetradio.live.extensions.id

/**
 * Create on 3/15/19 by Sang
 * Description:
 **/
class MusicPlayerAdapter(
    private val context: Context,
    private val playbackStateChange: (PlaybackStateCompat) -> Unit, // Notification action
    private val playbackComplete: (MediaMetadataCompat) -> Unit?
) : PlayerAdapter(context) {
    private lateinit var listener: MediaPlayer.OnCompletionListener
    private var fileName: String? = null
    private var playbackStateCode: Int = PlaybackStateCompat.STATE_NONE
    // MediaPlayer might be in Paused (not playing) and is called MediaPlayer.seekTo()
    private var seekWhileNotPlaying = -1L
    private var isMediaCompleted: Boolean = false

    private val applicationContext = context.applicationContext
    private var mediaPlayer: MediaPlayer? = null
    var currentMetadata: MediaMetadataCompat? = null

    override fun onPlay() {
        mediaPlayer?.apply {
            if (isPlaying.not()) {
                start()
                setNewPlaybackStateCode(PlaybackStateCompat.STATE_PLAYING)
            }
        }
    }

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

    override fun onPause() {
        mediaPlayer?.apply {
            if (isPlaying) {
                pause()
                setNewPlaybackStateCode(PlaybackStateCompat.STATE_PAUSED)
            }
        }
    }

    override fun onStop() {
        setNewPlaybackStateCode(PlaybackStateCompat.STATE_STOPPED)
        releaseMediaPlayer()
    }

    private fun releaseMediaPlayer() {
        mediaPlayer?.also {
            it.release()
            mediaPlayer = null
        }
    }

    override fun isPlaying(): Boolean = mediaPlayer?.isPlaying ?: false

    override fun setVolume(volume: Float) {
        mediaPlayer?.apply { setVolume(volume, volume) }
    }

    override fun seekTo(position: Long) {
        mediaPlayer?.apply {
            if (isPlaying.not()) {
                seekWhileNotPlaying = position
            }
            this.seekTo(position.toInt())
            // Set the new state (to the current state) because the position changed and should be reported to clients.
            setNewPlaybackStateCode(playbackStateCode)
        }
    }

    override fun playFromMedia(metadata: MediaMetadataCompat) {
        currentMetadata = metadata
        playFile(metadata.MEDIA_URI)
//        metadata.description.mediaId?.let { playFile(metadata.description.mediaId?:return) }
    }


    private fun playFile(newFileName: String) {
        var isMediaChanged = newFileName != fileName
        if (isMediaCompleted) {
            // research to end of MediaPlayer
            // Last audio file was played to completion, the resourceId hasn't been changed.
            // But the player was released, so force a reload of the media file for playback.
            isMediaChanged = true
            isMediaCompleted = false
        }
        if (isMediaChanged.not()) {
            if (!isPlaying()) {
                play()
            }
            return
        }

        releaseMediaPlayer()

        // Play new media file
        fileName = newFileName
        initializeMediaPlayer()

        mediaPlayer?.apply {
            setDataSource(this@MusicPlayerAdapter.context,Uri.parse(fileName))
            prepare()
        }
        play()
    }

    fun initializeMediaPlayerListener(listener: MediaPlayer.OnCompletionListener){
        this.listener = listener
    }


    private fun initializeMediaPlayer() {
        if (mediaPlayer == null) {
            mediaPlayer = MediaPlayer().apply {
                setOnCompletionListener{

//                    setNewPlaybackStateCode(PlaybackStateCompat.STATE_PAUSED)

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
//                    setNewPlaybackStateCode(PlaybackStateCompat.STATE_PLAYING)
                }
            }
        }
    }
}




