package com.jetsetradio.live.extensions

import android.support.v4.media.session.PlaybackStateCompat


inline val PlaybackStateCompat.isPrepared: Boolean
    get() = (state == PlaybackStateCompat.STATE_BUFFERING) ||
            (state == PlaybackStateCompat.STATE_PLAYING) ||
            (state == PlaybackStateCompat.STATE_PAUSED)

inline val PlaybackStateCompat.isPlaying: Boolean
    get() = (state == PlaybackStateCompat.STATE_PLAYING) ||
            (state == PlaybackStateCompat.STATE_BUFFERING)

inline val PlaybackStateCompat.isPlayEnabled: Boolean
    get() = (actions and PlaybackStateCompat.ACTION_PLAY != 0L) ||
            ((actions and PlaybackStateCompat.ACTION_PLAY_PAUSE != 0L) &&
                    (state == PlaybackStateCompat.STATE_BUFFERING || state == PlaybackStateCompat.STATE_PLAYING))

inline val PlaybackStateCompat.isSkipToNextEnabled: Boolean
    get() = actions and PlaybackStateCompat.ACTION_SKIP_TO_NEXT != 0L

inline val PlaybackStateCompat.isSkipToPreviousEnabled: Boolean
    get() = actions and PlaybackStateCompat.ACTION_SKIP_TO_PREVIOUS != 0L

inline val PlaybackStateCompat.isShuffleEnabled: Boolean
    get() = actions and PlaybackStateCompat.ACTION_SKIP_TO_PREVIOUS != 0L


inline val PlaybackStateCompat.stateName: String
    get() = when (state) {
        PlaybackStateCompat.STATE_NONE -> "STATE_NONE"
        PlaybackStateCompat.STATE_STOPPED -> "STATE_STOPPED"
        PlaybackStateCompat.STATE_PAUSED -> "STATE_PAUSED"
        PlaybackStateCompat.STATE_PLAYING -> "STATE_PLAYING"
        PlaybackStateCompat.STATE_FAST_FORWARDING -> "STATE_FAST_FORWARDING"
        PlaybackStateCompat.STATE_REWINDING -> "STATE_REWINDING"
        PlaybackStateCompat.STATE_BUFFERING -> "STATE_BUFFERING"
        PlaybackStateCompat.STATE_ERROR -> "STATE_ERROR"
        PlaybackStateCompat.STATE_CONNECTING -> "STATE_CONNECTING"
        PlaybackStateCompat.STATE_SKIPPING_TO_PREVIOUS -> "STATE_SKIPPING_TO_PREVIOUS"
        PlaybackStateCompat.STATE_SKIPPING_TO_NEXT -> "STATE_SKIPPING_TO_NEXT"
        PlaybackStateCompat.STATE_SKIPPING_TO_QUEUE_ITEM -> "STATE_SKIPPING_TO_QUEUE_ITEM"
        else -> "UNKNOWN_STATE"
    }
