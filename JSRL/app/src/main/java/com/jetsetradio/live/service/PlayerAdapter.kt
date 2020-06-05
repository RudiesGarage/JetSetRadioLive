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
import android.support.v4.media.MediaMetadataCompat
import androidx.annotation.RequiresApi

/**
 * Create on 3/15/19 by Sang
 * Description:
 **/
private const val DEF_MEDIA_VOLUME = 1F
private const val DUCK_MEDIA_VOLUME = 0F

abstract class PlayerAdapter(context: Context) {

    private var isAudioNoisyReceiverRegistered = false
    private var isPlayWhenAudioFocus = false

    private val applicationContext = context.applicationContext
    private val audioManager =
        applicationContext.getSystemService(Context.AUDIO_SERVICE) as AudioManager

    private val audioNoisyReceiver = object : BroadcastReceiver() {
        override fun onReceive(context: Context?, intent: Intent?) {
            if (AudioManager.ACTION_AUDIO_BECOMING_NOISY == intent?.action && isPlaying()) {
                pause()
            }
        }
    }

    // Callback invokes when audio focus of the system is updated.
    private val audioFocusChangeListener = object : AudioManager.OnAudioFocusChangeListener {
        override fun onAudioFocusChange(focusChange: Int) {
            when (focusChange) {
                AudioManager.AUDIOFOCUS_GAIN -> {
                    if (isPlayWhenAudioFocus && !isPlaying()) {
                        play()
                    } else if (isPlaying()) {
                        setVolume(DEF_MEDIA_VOLUME)
                    }
                    isPlayWhenAudioFocus = false
                }
                AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK -> {
                    setVolume(DUCK_MEDIA_VOLUME)
                }
                AudioManager.AUDIOFOCUS_LOSS_TRANSIENT -> {
                    if (isPlaying()) {
                        isPlayWhenAudioFocus = true
                        pause()
                    }
                }
                AudioManager.AUDIOFOCUS_LOSS -> {
                    audioManager.abandonAudioFocus(this)
                    isPlayWhenAudioFocus = false
                    stop()
                }
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private val musicFocusRequest: AudioFocusRequest =
        AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN)
            .setAudioAttributes(AudioAttributes.Builder().run {
                setUsage(AudioAttributes.USAGE_MEDIA)
                setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                build()
            })
            .setAcceptsDelayedFocusGain(true)
            .setOnAudioFocusChangeListener(audioFocusChangeListener)
            .setWillPauseWhenDucked(true)
            .build()

    fun play() {
        val musicFocusState: Int = if (Build.VERSION.SDK_INT < Build.VERSION_CODES.O) {
            audioManager.requestAudioFocus(
                audioFocusChangeListener, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN
            )
        } else {
            audioManager.requestAudioFocus(musicFocusRequest)
        }
        if (AudioManager.AUDIOFOCUS_REQUEST_GRANTED == musicFocusState) {
            registerAudioNoisyReceiver()
            onPlay()
        }
    }

    private fun registerAudioNoisyReceiver() {
        if (isAudioNoisyReceiverRegistered.not()) {
            val audioNoisyIntentFilter = IntentFilter(AudioManager.ACTION_AUDIO_BECOMING_NOISY)
            applicationContext.registerReceiver(audioNoisyReceiver, audioNoisyIntentFilter)
            isAudioNoisyReceiverRegistered = true
        }
    }

    fun pause() {
        if (isPlayWhenAudioFocus.not()) {
            abandonMediaAudioFocus()
        }
        unregisterAudioNoisyReceiver()
        onPause()
    }

    fun stop() {
        abandonMediaAudioFocus()
        unregisterAudioNoisyReceiver()
        onStop()
    }

    private fun abandonMediaAudioFocus() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            audioManager.abandonAudioFocusRequest(musicFocusRequest)
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

    abstract fun onPlay()

    abstract fun onPause()

    abstract fun onStop()

    abstract fun isPlaying(): Boolean

    abstract fun setVolume(volume: Float)

    abstract fun seekTo(position: Long)

    abstract fun playFromMedia(metadata: MediaMetadataCompat)
}
