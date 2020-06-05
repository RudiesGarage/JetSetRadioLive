package com.jetsetradio.live.service

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import android.support.v4.media.MediaDescriptionCompat
import android.support.v4.media.session.MediaSessionCompat
import android.support.v4.media.session.PlaybackStateCompat
import androidx.core.app.NotificationCompat
import androidx.media.app.NotificationCompat.MediaStyle
import androidx.media.session.MediaButtonReceiver
import com.jetsetradio.live.R
import com.jetsetradio.live.data.MusicLibrary
import com.jetsetradio.live.extensions.*

class MusicNotificationManager(private val service: MusicService) {

    val notificationManager =
            service.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

    private val playAction = NotificationCompat.Action(
            R.drawable.ic_play_arrow_white_24dp,
            service.getString(R.string.play_action_label),
            MediaButtonReceiver.buildMediaButtonPendingIntent(service, PlaybackStateCompat.ACTION_PLAY)
    )
    private val pauseAction = NotificationCompat.Action(
            R.drawable.ic_pause_white_24dp,
            service.getString(R.string.pause_action_label),
            MediaButtonReceiver.buildMediaButtonPendingIntent(service, PlaybackStateCompat.ACTION_PAUSE)
    )
    private val nextAction = NotificationCompat.Action(
            R.drawable.ic_skip_next_white_24dp,
            service.getString(R.string.next_action_label),
            MediaButtonReceiver.buildMediaButtonPendingIntent(
                    service, PlaybackStateCompat.ACTION_SKIP_TO_NEXT
            )
    )


    private val shuffleAction = NotificationCompat.Action(
            R.drawable.ic_skip_previous_black_24dp,
            service.getString(R.string.shuffle_action_label),
            MediaButtonReceiver.buildMediaButtonPendingIntent(
                    service, PlaybackStateCompat.ACTION_SKIP_TO_PREVIOUS
            )
    )

    fun getNotification(
            state: PlaybackStateCompat,
            token: MediaSessionCompat.Token,
            description: MediaDescriptionCompat
    ): Notification {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            createNotificationChannel()
        }
        val mediaStyle = MediaStyle().setMediaSession(token)
                .setShowActionsInCompactView(0, 1, 2)
                .setShowCancelButton(true) // For android 7 and earlier
        val deletePendingIntent = MediaButtonReceiver.buildMediaButtonPendingIntent(
                service, PlaybackStateCompat.ACTION_STOP
        )
        val builder = NotificationCompat.Builder(service, CHANNEL_ID)
        builder.setSmallIcon(R.drawable.ic_music_note_black_24dp)
                .setContentTitle(description.title)
                .setContentText(description.subtitle)
                .setDeleteIntent(deletePendingIntent)
                .setLargeIcon(MusicLibrary.getStationBitmaps(service, description.mediaId ?: "")?.get(0))
                .setVisibility(NotificationCompat.VISIBILITY_PUBLIC)
                .setStyle(mediaStyle)

        if (state.isShuffleEnabled) {
            builder.addAction(shuffleAction)
        }

        if (state.isPlaying) {
            builder.addAction(pauseAction)
        } else if (state.isPlayEnabled) {
            builder.addAction(playAction)
        }
        if (state.isSkipToNextEnabled) {
            builder.addAction(nextAction)
        }
        return builder.build()
    }

    @TargetApi(Build.VERSION_CODES.O)
    private fun createNotificationChannel() {
        if (notificationManager.getNotificationChannel(CHANNEL_ID) == null) {
            val channel = NotificationChannel(
                    CHANNEL_ID, "MediaSession", NotificationManager.IMPORTANCE_LOW
            ).apply {
                description = "MediaPlayer with MediaSession demo"
                enableLights(true)
                lightColor = Color.RED
                lockscreenVisibility = Notification.VISIBILITY_PUBLIC
            }
            notificationManager.createNotificationChannel(channel)
        }
    }

    companion object {

        private const val CHANNEL_ID = "com.sournary.notification.MUSIC_CHANNEL"
        const val NOTIFICATION_ID = 111
    }
}