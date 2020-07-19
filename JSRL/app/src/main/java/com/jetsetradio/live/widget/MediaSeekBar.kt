package com.jetsetradio.live.widget

import android.animation.ValueAnimator
import android.content.Context
import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.session.MediaControllerCompat
import android.support.v4.media.session.PlaybackStateCompat
import android.util.AttributeSet
import android.util.Log
import android.view.animation.LinearInterpolator
import android.widget.SeekBar
import androidx.appcompat.widget.AppCompatSeekBar



class MediaSeekBar : AppCompatSeekBar {

    private var isTracking = false

    private var mediaController: MediaControllerCompat? = null
    private var progressAnimator: ValueAnimator? = null
    private var mediaControllerCallback = object : MediaControllerCompat.Callback() {
        override fun onMetadataChanged(metadata: MediaMetadataCompat?) {
            super.onMetadataChanged(metadata)
            metadata?.apply {
                max = getLong(MediaMetadataCompat.METADATA_KEY_DURATION).toInt()
                progress = 0
            }
        }

        override fun onPlaybackStateChanged(state: PlaybackStateCompat?) {
            super.onPlaybackStateChanged(state)
            // If there is an ongoing session, stop animation now
            progressAnimator?.also {
                it.cancel()
                progressAnimator = null
            }
            state?.apply {
                progress = position.toInt()
                if (this.state == PlaybackStateCompat.STATE_PLAYING) {
                    progressAnimator = ValueAnimator.ofInt(progress, max).apply {
                        duration = ((max - progress) / playbackSpeed).toLong()
                        interpolator = LinearInterpolator()
                        addUpdateListener { handleAnimationUpdate(it) }
                        start()
                    }
                }
            }
        }
    }

    private fun handleAnimationUpdate(valueAnimator: ValueAnimator) {
        if (isTracking) {
            valueAnimator.cancel()
        } else {
            progress = valueAnimator.animatedValue as Int
        }
    }

    private val seekBarChangeListener = object : OnSeekBarChangeListener {
        override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {}

        override fun onStartTrackingTouch(seekBar: SeekBar?) {
            isTracking = true
        }

        override fun onStopTrackingTouch(seekBar: SeekBar?) {
            mediaController?.transportControls?.seekTo(progress.toLong())
            isTracking = false
        }
    }

    constructor(context: Context) : super(context) {
        super.setOnSeekBarChangeListener(seekBarChangeListener)
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        super.setOnSeekBarChangeListener(seekBarChangeListener)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr) {
        super.setOnSeekBarChangeListener(seekBarChangeListener)
    }

    override fun setOnSeekBarChangeListener(l: OnSeekBarChangeListener?) {
        Log.d(TAG, "We have already set change listener for SeekBar")
    }

    fun setMediaController(newMediaController: MediaControllerCompat?) {
        newMediaController?.also {
            it.registerCallback(mediaControllerCallback)
            mediaController = it
        }
    }

    fun disconnectMediaController() {
        mediaController?.also {
            it.unregisterCallback(mediaControllerCallback)
            mediaController = null
        }
    }

    companion object {

        private const val TAG = "MediaSeekBar"
    }
}
