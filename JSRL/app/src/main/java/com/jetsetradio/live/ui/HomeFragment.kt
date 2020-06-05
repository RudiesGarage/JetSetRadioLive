package com.jetsetradio.live.ui

import android.media.MediaPlayer
import android.os.Bundle
import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.session.MediaControllerCompat
import android.support.v4.media.session.PlaybackStateCompat
import android.view.*
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.jetsetradio.live.R
import com.jetsetradio.live.client.MusicBrowserHelper
import com.jetsetradio.live.data.MusicLibrary
import com.jetsetradio.live.service.MusicService
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {

    private var isPlaying: Boolean = false
    private lateinit var musicBrowserHelper: MusicBrowserHelper<MusicService>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
        context?.let { MusicLibrary.loadJetSetRadio(it) }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.apply {
            if (this is AppCompatActivity) {
                setSupportActionBar(toolbar)
            }
        }
        setupClient()
        setupEvents()
    }

    private fun setupClient() {
        val musicControllerCallback = object : MediaControllerCompat.Callback() {
            override fun onMetadataChanged(metadata: MediaMetadataCompat?) {
                super.onMetadataChanged(metadata)
                showMusicInfoWhenMetadataChanged(metadata)
            }

            override fun onPlaybackStateChanged(state: PlaybackStateCompat?) {
                super.onPlaybackStateChanged(state)
                showPlayStateChanged(state)
            }
        }


        musicBrowserHelper =
            object : MusicBrowserHelper<MusicService>(activity!!, MusicService::class.java) {
                override fun onConnected(mediaController: MediaControllerCompat) {
//                    musicSeekBar.setMediaController(mediaController)
//                    this.setListener(
//                            MediaPlayer.OnCompletionListener {
//                        musicBrowserHelper.mediaController?.transportControls?.skipToNext()
//                    })

                }

                override fun onDisconnected() {}

                override fun onChildrenLoaded(
                    parentId: String, children: MutableList<MediaBrowserCompat.MediaItem>
                ) {
                    mediaController?.apply {
                        children.forEach { addQueueItem(it.description) }
                        transportControls.prepare()
                    }
                }
            }.apply { addControllerCallback(musicControllerCallback) }
    }

    private fun showMusicInfoWhenMetadataChanged(metadata: MediaMetadataCompat?) {
        metadata?.apply {
            musicTitleTextView.text = getString(MediaMetadataCompat.METADATA_KEY_TITLE)
            musicArtistTextView.text = getString(MediaMetadataCompat.METADATA_KEY_ARTIST)
//            musicDurationTextView.text =
//                getLong(MediaMetadataCompat.METADATA_KEY_DURATION).toTimeString("mm:ss")
            context?.apply {

                val stationImages = MusicLibrary.getStationBitmaps( this, getString(MediaMetadataCompat.METADATA_KEY_GENRE))
                val thumbnailImage = stationImages?.get(0)
                // set station Icon
                stationIcon.setImageBitmap(thumbnailImage)

                val descImage = stationImages?.get(1)
                // set station description
                stationDescription.setImageBitmap(descImage)

                val bgImage = stationImages?.get(2)
                // set station bg
                stationBackground.setImageBitmap(bgImage)

            }
        }
    }

    private fun showPlayStateChanged(playbackState: PlaybackStateCompat?) {
        playbackState?.apply {
            if(state == PlaybackStateCompat.STATE_SKIPPING_TO_NEXT){
                musicBrowserHelper.mediaController?.transportControls?.skipToNext()
            }
            else{
                isPlaying = state == PlaybackStateCompat.STATE_PLAYING
                playPauseImageView.isPressed = isPlaying
            }
        }
    }

    private fun setupEvents() {
        nextMusicImageView.setOnClickListener {
            musicBrowserHelper.mediaController?.transportControls?.skipToNext()
        }
//        prevMusicImageView.setOnClickListener{
//            musicBrowserHelper.mediaController?.transportControls?.skipToPrevious()
//        }

//         Shuffle Button
        shuffleMusicImageView.setOnClickListener {
            if(!MusicLibrary.getShuffle()) {
                shuffleMusicImageView.alpha = 1.0F
                MusicLibrary.setShuffle(true)
            }
            else{
                shuffleMusicImageView.alpha = 0.5F
                MusicLibrary.setShuffle(false)
            }
        }

        playPauseImageView.setOnClickListener {
            if (isPlaying) {
                musicBrowserHelper.mediaController?.transportControls?.pause()
            } else {
                musicBrowserHelper.mediaController?.transportControls?.play()
            }
        }
        nextStationButton.setOnClickListener{
            MusicLibrary.nextStation()
            musicBrowserHelper.mediaController?.transportControls?.skipToNext()
            //todo update UI
        }
        prevStationButton.setOnClickListener{
            MusicLibrary.prevStation()
            musicBrowserHelper.mediaController?.transportControls?.skipToNext()
        }
    }

    override fun onStart() {
        super.onStart()
        musicBrowserHelper.onStart()
    }

    override fun onStop() {
        super.onStop()
        musicBrowserHelper.onStop()
//        musicSeekBar.disconnectMediaController()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_home_option, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        view?.apply { Snackbar.make(this, "Menu clicked", Snackbar.LENGTH_SHORT).show() }
        return true
    }

    companion object {

        fun newInstance() = HomeFragment()
    }





}

