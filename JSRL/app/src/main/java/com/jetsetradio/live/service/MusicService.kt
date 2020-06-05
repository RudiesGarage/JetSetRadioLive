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
import com.jetsetradio.live.data.MusicLibrary
import kotlin.random.Random

/**
 * Create on 3/12/19 by Sang
 * Description:
 **/

class MusicService : MediaBrowserServiceCompat() {

    private var isServiceInStartedState = false
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

    override fun onLoadChildren(
            parentId: String, result: Result<MutableList<MediaBrowserCompat.MediaItem>>
    ) {
        result.sendResult(MusicLibrary.getMediaItems())
    }

    override fun onGetRoot(
            clientPackageName: String, clientUid: Int, rootHints: Bundle?
    ): BrowserRoot? {
        return BrowserRoot(MusicLibrary.getRoot(), null)
    }

    companion object {
        private const val TAG = "MusicService"
    }

    private inner class MusicSessionCallback : MediaSessionCompat.Callback() {

        private var playedItemIndex: Int = -1
        private val playList = mutableListOf<MediaSessionCompat.QueueItem>()

        private var prepareMusicMetadata: MediaMetadataCompat? = null

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
//            val musicId = playList[playedItemIndex].description.mediaId ?: return
            prepareMusicMetadata =
                    MusicLibrary.getMusicMetadata(this@MusicService, playedItemIndex)
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

        override fun onSkipToNext() {
            super.onSkipToNext()
            playedItemIndex = if (playedItemIndex < MusicLibrary.getNumSongs()?.minus(1) ?:0 ) {
                playedItemIndex + 1
            } else {
                0
            }
            prepareMusicMetadata = null
            onPlay()
        }

        // todo make skip station its own state
        // todo update playlist to new station size
        fun onSkiptoNextStation(){
//            playList.
        }


        override fun onSkipToPrevious() {
            super.onSkipToPrevious()
            playedItemIndex = if (playedItemIndex > 0) {
                playedItemIndex - 1
            } else {
                playList.size - 1 // Index = 0, start the last media.
            }
            prepareMusicMetadata = null
            onPlay()
        }
    }
}

