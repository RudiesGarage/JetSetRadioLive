package com.jetsetradio.live


import android.content.*
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.jetsetradio.live.data.MusicLibrary
import com.jetsetradio.live.chat.ChatFragment
import com.jetsetradio.live.ui.HomeFragment
import com.jetsetradio.live.ui.SettingsFragment
import com.jetsetradio.live.channelSelect.StationSelectFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random


// this is the main class that loads the fragments
class MainActivity : AppCompatActivity(), StationSelectFragment.OnHeadlineSelectedListener {
    private var wasPaused: Boolean = false // tell if the app was running in the background
    private var HomeFrag: HomeFragment = HomeFragment()
    private var mReceiver: BroadcastReceiver? = null
    private val receiverFilter = IntentFilter(Intent.ACTION_HEADSET_PLUG)

    private var activeFragmentTag = ""


    private var PRIVATE_MODE = 0
    private val SETTINGS_NAME = "JSR SETTINGS"
    private val BUMPS = "Bumps"
    private val USERNAME = "CHAT_USERNAME"
    private val CHAT_NOTIFICATIONS = "Chat_Notifications"
    private val LAST_STATION = "LastStation"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        // Load the app settings
        loadSettings()

        // Load the headphone receiver and toolbar handling
        loadClients()

        // Start the home/music fragment
        supportFragmentManager.beginTransaction()
                .add(R.id.container, HomeFrag,"Home")
                .commit()
    }


    private fun loadClients(){

        mReceiver = HeadphoneBroadcastReceiver()


        stationBanner.setOnClickListener{
            val nextFrag = StationSelectFragment()
            val fragmentManager: FragmentManager? = this.supportFragmentManager
            val fragmentTransaction: FragmentTransaction? = fragmentManager?.beginTransaction()
            if (fragmentTransaction != null && activeFragmentTag!="StationSelect") {
                activeFragmentTag = "StationSelect"
                closeFrags()
                fragmentTransaction.add(R.id.container, nextFrag, "StationSelect")
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }
            else if(fragmentTransaction != null && activeFragmentTag=="StationSelect"){
                activeFragmentTag = ""
                closeFrags()
                fragmentTransaction.commit()
            }
        }

        // Load the settings menu
        settingsMenuButton.setOnClickListener{
            val nextFrag = SettingsFragment()
            val fragmentManager: FragmentManager? = this.supportFragmentManager
            val fragmentTransaction: FragmentTransaction? = fragmentManager?.beginTransaction()
            if (fragmentTransaction != null && activeFragmentTag!="Settings") {
                activeFragmentTag="Settings"
                closeFrags()
                fragmentTransaction.add(R.id.container, nextFrag, "Settings")

                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }
            else if(fragmentTransaction != null && activeFragmentTag=="Settings"){
                activeFragmentTag = ""
                closeFrags()
                fragmentTransaction.commit()
            }
        }

        //Load the chat fragment
        chatMenuButton.setOnClickListener{
            val nextFrag = ChatFragment()
            val fragmentManager: FragmentManager? = this.supportFragmentManager
            val fragmentTransaction: FragmentTransaction? = fragmentManager?.beginTransaction()
            if (fragmentTransaction != null && activeFragmentTag!="Chat") {
                activeFragmentTag="Chat"

                closeFrags()
                fragmentTransaction.add(R.id.container, nextFrag, "Chat")
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }
            else if(fragmentTransaction != null && activeFragmentTag=="Chat"){
                activeFragmentTag = ""
                closeFrags()
                fragmentTransaction.commit()
            }
        }

    }

    override fun onResume() {
        super.onResume()
        if(wasPaused){
            setLockStatus(false)
        }
        registerReceiver(mReceiver, receiverFilter)

    }

    override fun onPause() {
        super.onPause()
        setLockStatus(true)
        unregisterReceiver(mReceiver)
    }

    override fun onStop() {
        super.onStop()
        setLockStatus(true)
    }


    private fun setLockStatus(status:Boolean){
        this.wasPaused = status
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        HomeFrag.onWindowFocusChange()
    }

    override fun onArticleSelected(position: Int) {
        // The user selected the headline of an article from the HeadlinesFragment
        // Do something here to display that article
        supportFragmentManager.findFragmentByTag("StationSelect")?.let {
            supportFragmentManager.beginTransaction().remove(it)
                .commit()
            activeFragmentTag ="StationSelect"
        }
        HomeFrag.onStationQuickSelect(position)
    }

    override fun onAttachFragment(fragment: Fragment) {
        if (fragment is StationSelectFragment) {
            fragment.setOnHeadlineSelectedListener(this)
            activeFragmentTag ="StationSelect"
        }
    }


    //Load Setting Preferences
    private fun loadSettings(){
        val sharedPref: SharedPreferences = getSharedPreferences(SETTINGS_NAME, PRIVATE_MODE)
        //Chat Username
        if (!sharedPref.contains(USERNAME)) {
            val editor = sharedPref.edit()
            val name = "Rudie_" + Random.nextInt(10,300)
            editor.putString(USERNAME, name)
            editor.apply()
            Log.d("USERNAME", sharedPref.getString(USERNAME,"RUDIE_DEFAULT"))
        } else {
            Log.d("USERNAME", sharedPref.getString(USERNAME,"RUDIE_DEFAULT"))
        }
        //Bumps
        if (!sharedPref.contains(BUMPS)) {
            val editor = sharedPref.edit()
            editor.putBoolean(BUMPS, true)
            editor.apply()
            Log.d("BUMPS", sharedPref.getBoolean(BUMPS,true).toString())
        } else {
            Log.d("BUMPS", sharedPref.getBoolean(BUMPS,true).toString())
        }
        //Chat Notifications
        if (!sharedPref.contains(CHAT_NOTIFICATIONS)) {
            val editor = sharedPref.edit()
            editor.putBoolean(CHAT_NOTIFICATIONS, true)
            editor.apply()
            Log.d("CHAT_NOTIFICATIONS", sharedPref.getBoolean(CHAT_NOTIFICATIONS,true).toString())
        } else {
            Log.d("CHAT_NOTIFICATIONS", sharedPref.getBoolean(CHAT_NOTIFICATIONS,true).toString())
        }
        //Set Last station
        if (!sharedPref.contains(LAST_STATION)) {
            val editor = sharedPref.edit()
            editor.putInt(LAST_STATION, 0)
            editor.apply()
            Log.d("LAST_STATION", sharedPref.getInt(LAST_STATION,0).toString())
        } else {
            MusicLibrary.setCurrStation(sharedPref.getInt(LAST_STATION,0))
            Log.d("LAST_STATION", sharedPref.getInt(LAST_STATION,0).toString())
        }
    }

    private fun closeFrags(tag: String){
        val fragmentA: Fragment? =  this.supportFragmentManager.findFragmentByTag(tag)
        if (fragmentA == null) {
            // not exist
        } else {
            this.supportFragmentManager.beginTransaction().remove(fragmentA).commit()
            this.supportFragmentManager.popBackStack()
        }
    }

    private fun closeFrags(){
        val tags = arrayOf("StationSelect","Settings","Chat")
        for(tag:String in tags){
            closeFrags(tag)
        }
    }

    inner class HeadphoneBroadcastReceiver(): BroadcastReceiver(){

        val  HEADPHONE_ACTIONS: Array<String> =  arrayOf(Intent.ACTION_HEADSET_PLUG,
                "android.bluetooth.headset.action.STATE_CHANGED",
                "android.bluetooth.headset.profile.action.CONNECTION_STATE_CHANGED"
        )

        override fun onReceive(context: Context?, intent: Intent) {

            var broadcast = false

            // Wired headset monitoring
            if (intent.action == HEADPHONE_ACTIONS[0]){
                val state = intent.getIntExtra("state", 0);
                HomeFrag.handleHeadphonePlugging(state > 0)
                broadcast = true;
            }

            // Bluetooth monitoring
            // Works up to and including Honeycomb
            if (intent.action == HEADPHONE_ACTIONS[1]) {
                val state = intent.getIntExtra("android.bluetooth.headset.extra.STATE", 0);
                HomeFrag.handleHeadphonePlugging(state == 2)
                broadcast = true;
            }

            // Works for Ice Cream Sandwich
            if (intent.action == HEADPHONE_ACTIONS[2]) {
                val state = intent.getIntExtra("android.bluetooth.profile.extra.STATE", 0);
                HomeFrag.handleHeadphonePlugging(state == 2)
                broadcast = true;
            }

            // Used to inform interested activities that the headset state has changed
            if (broadcast) {
                if (context != null) {
                    LocalBroadcastManager.getInstance(context).sendBroadcast( Intent("headsetStateChange"))
                };
            }
        }

    }

}
