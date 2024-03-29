package com.jetsetradio.live.ui

import android.content.SharedPreferences
import android.os.Bundle
import android.os.SystemClock
import android.support.v4.media.MediaBrowserCompat
import android.support.v4.media.MediaMetadataCompat
import android.support.v4.media.session.MediaControllerCompat
import android.support.v4.media.session.PlaybackStateCompat
import android.util.Log
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import com.jetsetradio.live.R
import com.jetsetradio.live.channelSelect.SliderAdapter
import com.jetsetradio.live.client.MusicBrowserHelper
import com.jetsetradio.live.data.MusicLibrary
import com.jetsetradio.live.service.*
import kotlinx.android.synthetic.main.fragment_home.*


// this is the home fragment that has the main radio functionality
class HomeFragment : Fragment() {
    private var isPlaying: Boolean = false
    private var isShuffle: Boolean = false
    private lateinit var musicBrowserHelper: MusicBrowserHelper<MusicService>
    private var mLastClickTime: Long = 0
    private var hasChannelsChanged = false
    private val PRIVATE_MODE = 0
    private val SETTINGS_NAME = "JSR SETTINGS"
    private var sharedPref: SharedPreferences? = null
    private val LAST_STATION = "LastStation"
    var handleSliderListenerDisable:Boolean = false


    // When fragment is loaded
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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
        sharedPref = context?.getSharedPreferences(SETTINGS_NAME, PRIVATE_MODE)
        //load icon slider
        loadSlider()
        setupClient()
        setupEvents()

        // Load the last saved station
        stationIconSlider.currentItem = sharedPref?.getInt(LAST_STATION,0)!!
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
                        Log.d("HOME FRAGMENT", "HomeFragment Reloaded")
//                        playPauseImageView.isPressed = isPlaying
                        loadPlaystateImage(isPlaying)
                        musicTitleTextView.text =  mediaController.metadata.description.title
                        musicArtistTextView.text = mediaController.metadata.description.subtitle
                    }
                }

                override fun onDisconnected() {}

                override fun onChildrenLoaded(parentId: String, children: MutableList<MediaBrowserCompat.MediaItem>) {
                    mediaController?.apply {

                        if(this.queue.isNullOrEmpty()){
                            children.forEach {
                                addQueueItem(it.description) }
                        }
                        transportControls.prepare()
                    }
                }
            }.apply { addControllerCallback(musicControllerCallback) }
        }



    // Update UI on when music changes
    private fun showMusicInfoWhenMetadataChanged(metadata: MediaMetadataCompat?) {
        metadata?.apply {

            //for some reason if we don not have this check, the nextButton is disabled
            if(hasChannelsChanged||isShuffle){
                //updating the current item like this still calls the slider listener.
                //if we dont disable it via handleSliderListenerDisable then the slider will cycle forever
                handleSliderListenerDisable = true //disable the slider callback
                hasChannelsChanged = false
                stationIconSlider.currentItem = MusicLibrary.getCurrStation()

                //save the new station into the cache
                val editor = sharedPref?.edit()
                editor?.putInt(LAST_STATION, MusicLibrary.getCurrStation())
                editor?.apply()

            }

            //enable the slider listener
            handleSliderListenerDisable = false



            musicTitleTextView.text = getString(MediaMetadataCompat.METADATA_KEY_TITLE)
            musicArtistTextView.text = getString(MediaMetadataCompat.METADATA_KEY_ARTIST)

            context?.apply {
                // set station bg
                if(getString(MediaMetadataCompat.METADATA_KEY_GENRE) != "bump"){
                  stationBackground.setImageBitmap(MusicLibrary.getStationBackgroundBitmap( this, getString(MediaMetadataCompat.METADATA_KEY_GENRE).toInt() ))
                }
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
                }
                PlaybackStateCompat.STATE_PAUSED -> {
                    isPlaying = false
                    loadPlaystateImage(isPlaying)
                }
                PlaybackStateCompat.STATE_SKIPPING_TO_NEXT -> {
                    isPlaying = false
                    musicBrowserHelper.mediaController?.transportControls?.skipToNext()
                    loadPlaystateImage(isPlaying)
                }

                PlaybackStateCompat.STATE_BUFFERING -> {
                    TODO()
                }
                PlaybackStateCompat.STATE_CONNECTING -> {
                    TODO()
                }
                PlaybackStateCompat.STATE_ERROR -> {
                    TODO()
                }
                PlaybackStateCompat.STATE_FAST_FORWARDING -> {
                    TODO()
                }
                PlaybackStateCompat.STATE_NONE -> {
                    TODO()
                }
                PlaybackStateCompat.STATE_REWINDING -> {
                    TODO()
                }
                PlaybackStateCompat.STATE_SKIPPING_TO_PREVIOUS -> {
                    TODO()
                }
                PlaybackStateCompat.STATE_SKIPPING_TO_QUEUE_ITEM -> {
                    TODO()
                }
                PlaybackStateCompat.STATE_STOPPED -> {
                    TODO()
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
        shuffleMusicImageView.setOnClickListener {
            if(!isShuffle) {
                // make button fully visable
                shuffleMusicImageView.alpha = 1.0F
                isShuffle = true
            }
            else{
                //make button opaque
                shuffleMusicImageView.alpha = 0.5F
                isShuffle = false
            }
            // Run the shuffle intent
            musicBrowserHelper.mediaController?.transportControls?.sendCustomAction(CUSTOM_ACTION_SHUFFLE,null)
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
    }

    override fun onResume() {
        super.onResume()
        loadPlaystateImage(isPlaying)
    }

    override fun onPause() {
        super.onPause()
        loadPlaystateImage(isPlaying)
    }

    override fun onStop() {
        super.onStop()
        musicBrowserHelper.onStop()

    }


    fun onWindowFocusChange(){
        showPlayStateChanged(musicBrowserHelper.mediaController?.playbackState)
        //TODO update ui to current song
        loadPlaystateImage(isPlaying)
    }

    // handle Station quick select
    fun onStationQuickSelect(position:Int){
        showPlayStateChanged(musicBrowserHelper.mediaController?.playbackState)
        stationIconSlider.currentItem = position
        loadPlaystateImage(isPlaying)
    }


    private fun loadSlider() {

        //Get all station Icons
        val stationIconList: ArrayList<ArrayList<Int>> = MusicLibrary.getStationData().getAllIcons()

        stationIconSlider.adapter = context?.let { SliderAdapter(it, stationIconList, activity) }

        stationIconSlider.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(state: Int) {}
            override fun onPageScrolled(position: Int, positionOffset: Float, positionOffsetPixels: Int) {}
            override fun onPageSelected(position: Int) {


                // IF this is enabled...
                if(!handleSliderListenerDisable){
                    var stationConversionTemp = (position - 4999995)
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

    // Headphone listener response
    fun handleHeadphonePlugging(Microphone_Plugged_in:Boolean){
        if(Microphone_Plugged_in){
            if(isPlaying){
                musicBrowserHelper.mediaController?.transportControls?.play()
            }
        }
        else{
            musicBrowserHelper.mediaController?.transportControls?.pause()
        }
    }

}


