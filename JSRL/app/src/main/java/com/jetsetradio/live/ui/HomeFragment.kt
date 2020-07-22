package com.jetsetradio.live.ui

import android.os.Build
import android.os.Bundle
import android.os.SystemClock
import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.session.MediaControllerCompat
import android.support.v4.media.session.PlaybackStateCompat
import android.view.*
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.google.android.material.snackbar.Snackbar
import com.jetsetradio.live.R
import com.jetsetradio.live.client.MusicBrowserHelper
import com.jetsetradio.live.data.MusicLibrary
import com.jetsetradio.live.service.*
import kotlinx.android.synthetic.main.fragment_home.*
import java.lang.Math.abs


// this is the home fragment that has the main radio functionality
class HomeFragment : Fragment() {
    private var isPlaying: Boolean = false
    private var isShuffle: Boolean = false

    private lateinit var musicBrowserHelper: MusicBrowserHelper<MusicService>
    private var mLastClickTime: Long = 0
    private var hasChannelsChanged = false


    // When fragment is loaded
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //setHasOptionsMenu(true)
        context?.let { MusicLibrary.loadJetSetRadio(it) }
    }

    // load all view assets
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    // set up Data to run activity
    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        activity?.apply {
            if (this is AppCompatActivity) {
                setSupportActionBar(toolbar)
            }
        }
        //load icon slider
        loadSlider()
        setupClient()
        setupEvents()
    }

    // Set up the media client that handles messages from the music service
    private fun setupClient() {

        // create a musicControllerCallback  for the musicBrowserHelper
        val musicControllerCallback = object : MediaControllerCompat.Callback() {

            // Handle new song loaded
            override fun onMetadataChanged(metadata: MediaMetadataCompat?) {
                super.onMetadataChanged(metadata)
                showMusicInfoWhenMetadataChanged(metadata)
            }

            // Handle Play/Pause
            override fun onPlaybackStateChanged(state: PlaybackStateCompat?) {
                super.onPlaybackStateChanged(state)
                showPlayStateChanged(state)
            }
        }

        // Create a musicBrowserHelper
        musicBrowserHelper =
            object : MusicBrowserHelper<MusicService>(activity!!, MusicService::class.java) {

                override fun onConnected(mediaController: MediaControllerCompat) {
                    // Update UI on reconnection
                    if(mediaController.metadata != null){
                        Toast.makeText(context, "Welcome Back!", Toast.LENGTH_SHORT).show()
//                        playPauseImageView.isPressed = isPlaying
                        loadPlaystateImage(isPlaying)
                        musicTitleTextView.text =  mediaController.metadata.description.title
                        musicArtistTextView.text = mediaController.metadata.description.subtitle
                    }



//                    musicSeekBar.setMediaController(mediaController)
//                    this.setListener(
//                            MediaPlayer.OnCompletionListener {
//                        musicBrowserHelper.mediaController?.transportControls?.skipToNext()
//                    })
                }

                override fun onDisconnected() {}

                override fun onChildrenLoaded(parentId: String, children: MutableList<MediaBrowserCompat.MediaItem>) {
                    mediaController?.apply {
                        //remove
//                        if (!this.queue.isNullOrEmpty()){
//                            this.queue.forEach{removeQueueItem(it.description)}
//                        }
                        if(this.queue.isNullOrEmpty()){
                            children.forEach { addQueueItem(it.description) }
                        }
                        transportControls.prepare()
                    }
                }
            }.apply { addControllerCallback(musicControllerCallback) }
        }

    var handleSliderListenerDisable:Boolean = false

    // Update UI on when music changes
    private fun showMusicInfoWhenMetadataChanged(metadata: MediaMetadataCompat?) {
        metadata?.apply {
            handleSliderListenerDisable = true //disable the slider callback

            //for some reason if we don not have this check, the nextButton is disabled
            if(hasChannelsChanged||isShuffle){
                //updating the current item like this still calls the slider listener.
                //if we dont disable it via handleSliderListenerDisable then the slider will cycle forever
                stationIconSlider.currentItem = MusicLibrary.getCurrStation()
            }
            //enable the slider listener
            handleSliderListenerDisable = false
            hasChannelsChanged = false

            musicTitleTextView.text = getString(MediaMetadataCompat.METADATA_KEY_TITLE)
            musicArtistTextView.text = getString(MediaMetadataCompat.METADATA_KEY_ARTIST)
//            musicDurationTextView.text =
//                getLong(MediaMetadataCompat.METADATA_KEY_DURATION).toTimeString("mm:ss")

            context?.apply {

                val stationImages = MusicLibrary.getStationBitmaps( this, getString(MediaMetadataCompat.METADATA_KEY_GENRE))

                val descImage = stationImages?.get(1)
                // set station description
                stationDescription.setImageBitmap(descImage)

                val bgImage = stationImages?.get(2)
                // set station bg
                stationBackground.setImageBitmap(bgImage)
            }
        }
    }

    // Update UI on Play state change
    private fun showPlayStateChanged(playbackState: PlaybackStateCompat?) {
        playbackState?.apply {
            when (state) {
                PlaybackStateCompat.STATE_PLAYING -> {
                    isPlaying = true
                    loadPlaystateImage(isPlaying)
//                    playPauseImageView.isPressed = isPlaying
                }
                PlaybackStateCompat.STATE_PAUSED -> {
                    isPlaying = false
                    loadPlaystateImage(isPlaying)
//                    playPauseImageView.isPressed = isPlaying
                }
                PlaybackStateCompat.STATE_SKIPPING_TO_NEXT -> {
                    isPlaying = false
                    musicBrowserHelper.mediaController?.transportControls?.skipToNext()
                    loadPlaystateImage(isPlaying)
//                    playPauseImageView.isPressed = isPlaying
                }

            }
        }
    }



    // Set up event/click listeners (button handling)
    private fun setupEvents() {




        // Next SONG Button
        nextMusicImageView.setOnClickListener {
            //Prevent spam
            // mis-clicking prevention, using threshold of 500 ms
            if (SystemClock.elapsedRealtime() - mLastClickTime < 500){
                return@setOnClickListener;
            }

            mLastClickTime = SystemClock.elapsedRealtime();
            musicBrowserHelper.mediaController?.transportControls?.skipToNext()
        }


        //  Shuffle Button
        //TODO make proper CUSTOM_ACTION CALLS
        shuffleMusicImageView.setOnClickListener {
            if(!isShuffle) {
                shuffleMusicImageView.alpha = 1.0F
                isShuffle = true
                musicBrowserHelper.mediaController?.transportControls?.sendCustomAction(CUSTOM_ACTION_SHUFFLE,null)

//                MusicLibrary.setShuffle(true)
            }
            else{
                shuffleMusicImageView.alpha = 0.5F
                isShuffle = false
                musicBrowserHelper.mediaController?.transportControls?.sendCustomAction(CUSTOM_ACTION_SHUFFLE,null)
//                MusicLibrary.setShuffle(false)
            }
        }

        // Play / Pause Button
        playPauseImageView.setOnClickListener {
            if (isPlaying) {
                // play/pausing the music
                musicBrowserHelper.mediaController?.transportControls?.pause()
            } else {
                musicBrowserHelper.mediaController?.transportControls?.play()
            }
        }

        // Next STATION button Press Handling
        nextStationButton.setOnClickListener{

            // mis-clicking prevention, using threshold of 500 ms
            if (SystemClock.elapsedRealtime() - mLastClickTime < 500){
                return@setOnClickListener;
            }
            hasChannelsChanged = true
            mLastClickTime = SystemClock.elapsedRealtime();
            // clear playlist
            musicBrowserHelper.mediaController?.apply {
                //remove
                if (!this.queue.isNullOrEmpty()) {
                    this.queue.forEach { removeQueueItem(it.description) }
                }
            }
//

            musicBrowserHelper.mediaController?.transportControls?.sendCustomAction(CUSTOM_ACTION_STATION_NEXT,null)

        }

        // PREV STATION button press handling
        prevStationButton.setOnClickListener{
            // mis-clicking prevention, using threshold of 500 ms
            if (SystemClock.elapsedRealtime() - mLastClickTime < 500){
                return@setOnClickListener;
            }
            hasChannelsChanged = true
            mLastClickTime = SystemClock.elapsedRealtime();

            // clear playlist
            musicBrowserHelper.mediaController?.apply {
                //remove
                if (!this.queue.isNullOrEmpty()) {
                    this.queue.forEach { removeQueueItem(it.description) }
                }
            }

            musicBrowserHelper.mediaController?.transportControls?.sendCustomAction(CUSTOM_ACTION_STATION_PREV,null)

        }
    }



    override fun onStart() {
        super.onStart()
        musicBrowserHelper.onStart()
//        musicBrowserHelper.mediaController?.transportControls?.play()
    }

    override fun onResume() {
        super.onResume()
        loadPlaystateImage(isPlaying)
//        playPauseImageView.isPressed = isPlaying
    }

    override fun onPause() {
        super.onPause()
        loadPlaystateImage(isPlaying)
//        playPauseImageView.isPressed = isPlaying
    }

    override fun onStop() {
        super.onStop()
//        super.onStop()
//        musicBrowserHelper.onStop()
//        musicSeekBar.disconnectMediaController()
    }

    // load menu options
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_home_option, menu)
    }

    // Handle on Menu select
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // todo make settings
        view?.apply { Snackbar.make(this, "Menu clicked", Snackbar.LENGTH_SHORT).show() }
        return true
    }

    companion object {
        fun newInstance() = HomeFragment()
    }


    fun onWindowFocusChange(){
        showPlayStateChanged(musicBrowserHelper.mediaController?.playbackState)
//        playPauseImageView.isPressed = isPlaying
    }


    private fun loadSlider() {

        //TODO move the icons here 
        //Get all station Icons
        val stationIconList: MutableList<Int> = arrayListOf();

        for(index in MusicLibrary.stationImageData){
            stationIconList.add(index[0])
        }

        stationIconSlider.adapter = context?.let { SliderAdapter(it, stationIconList) }
        stationIconSlider.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {
                // IF this is enabled...
                if(!handleSliderListenerDisable){
                    var stationConversionTemp = (position - 4999977)
                    val tet= stationConversionTemp
                    when {
                        stationConversionTemp < 0 -> {
                            val temp = MusicLibrary.getNumStations()
                            stationConversionTemp = temp - (kotlin.math.abs(stationConversionTemp) % temp)
                            if(stationConversionTemp == temp){
                                stationConversionTemp = 0
                            }
                        }
                        else -> {
                            stationConversionTemp %= MusicLibrary.getNumStations()
                        }
                    }

                    hasChannelsChanged = true
                    val bundle = Bundle()
                    bundle.putInt("STATION_POSITION", stationConversionTemp)
                    musicBrowserHelper.mediaController?.transportControls?.sendCustomAction(CUSTOM_ACTION_STATION_SET, bundle)
                }
            }
        })
    }

    // change the play/pause button image based on if the music player is playing or not
    private fun loadPlaystateImage(isPlaying: Boolean){
        if(isPlaying){
            playPauseImageView.setImageResource(R.drawable.pausetrackbutton)
        }
        else{
            playPauseImageView.setImageResource(R.drawable.playtrackbutton)
        }
    }

}


