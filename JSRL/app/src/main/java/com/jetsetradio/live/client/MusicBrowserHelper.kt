package com.jetsetradio.live.client

import android.content.ComponentName
import android.content.Context
import android.media.MediaPlayer
import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.session.MediaControllerCompat
import android.support.v4.media.session.PlaybackStateCompat
import android.util.Log
import androidx.media.MediaBrowserServiceCompat


abstract class MusicBrowserHelper<T : MediaBrowserServiceCompat>(
    private val context: Context, private val serviceClass: Class<T>
) {

    private val callbacks = mutableListOf<MediaControllerCompat.Callback>()
    var mediaController: MediaControllerCompat? = null
    private var mediaBrowser: MediaBrowserCompat? = null



    private val mediaBrowserConnectionCallback = object : MediaBrowserCompat.ConnectionCallback() {
        override fun onConnected() {
            super.onConnected()
            val musicToken = mediaBrowser?.sessionToken ?: return
            mediaController = MediaControllerCompat(context, musicToken).apply {
                registerCallback(mediaControllerCallback)
                this@MusicBrowserHelper.onConnected(this)
            }
            Log.d("Test_tag", "token: ${mediaBrowser?.sessionToken} - $musicToken")
            mediaBrowser?.apply { subscribe(root, mediaSubscriptionCallback) }
        }
    }

    private val mediaControllerCallback = object : MediaControllerCompat.Callback() {
        override fun onMetadataChanged(metadata: MediaMetadataCompat?) {
            super.onMetadataChanged(metadata)
            handleCallbacks { onMetadataChanged(metadata) }
        }

        override fun onShuffleModeChanged(shuffleMode: Int) {
            super.onShuffleModeChanged(shuffleMode)
            handleCallbacks { onShuffleModeChanged(shuffleMode) }
        }

        override fun onPlaybackStateChanged(state: PlaybackStateCompat?) {
            super.onPlaybackStateChanged(state)
            handleCallbacks { onPlaybackStateChanged(state) }
        }

        override fun onSessionDestroyed() {
            super.onSessionDestroyed()
            resetState()
            onDisconnected()
        }
    }

    private val mediaSubscriptionCallback = object : MediaBrowserCompat.SubscriptionCallback() {
        override fun onChildrenLoaded(
            parentId: String, children: MutableList<MediaBrowserCompat.MediaItem>
        ) {
            super.onChildrenLoaded(parentId, children)
            this@MusicBrowserHelper.onChildrenLoaded(parentId, children)
        }
    }

    fun onStart() {
        if (mediaBrowser == null) {
            mediaBrowser = MediaBrowserCompat(
                context, ComponentName(context, serviceClass), mediaBrowserConnectionCallback, null
            ).apply { connect() }
        }
    }

    fun onStop() {
        mediaController?.also {
            it.unregisterCallback(mediaControllerCallback)
            mediaController = null
        }
        mediaBrowser?.also {
            if (it.isConnected) {
                it.disconnect()
                mediaBrowser = null
            }
        }
    }

    private fun resetState() {
        handleCallbacks { onPlaybackStateChanged(null) }
    }

    private fun handleCallbacks(callbackCommand: MediaControllerCompat.Callback.() -> Unit) {
        callbacks.forEach(callbackCommand)
    }

    fun addControllerCallback(callback: MediaControllerCompat.Callback?) {
        callback?.also { callbacks.add(it) }
    }

    abstract fun onConnected(mediaController: MediaControllerCompat)

    abstract fun onDisconnected()

    abstract fun onChildrenLoaded(parentId: String, children: MutableList<MediaBrowserCompat.MediaItem>)



}
