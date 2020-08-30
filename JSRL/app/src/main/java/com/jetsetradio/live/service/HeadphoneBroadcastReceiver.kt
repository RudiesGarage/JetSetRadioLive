package com.jetsetradio.live.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.localbroadcastmanager.content.LocalBroadcastManager
import com.jetsetradio.live.ui.HomeFragment

class HeadphoneBroadcastReceiver(private val HomeFrag: HomeFragment): BroadcastReceiver(){

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