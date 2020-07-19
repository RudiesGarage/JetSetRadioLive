package com.jetsetradio.live

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.jetsetradio.live.ui.HomeFragment


// this is the main class that loads the fragments
class MainActivity : AppCompatActivity() {
    private var wasPaused: Boolean = false // tell if the app was running in the background
    private var HomeFrag: HomeFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        HomeFrag = HomeFragment.newInstance()
        supportFragmentManager.beginTransaction()
            .add(R.id.container, HomeFrag!!)
            .commit()
    }

    override fun onResume() {
        super.onResume()
        if(wasPaused){
            setLockStatus(false)
        }
    }

    override fun onPause() {
        super.onPause()
        setLockStatus(true)
    }

    override fun onStop() {
        super.onStop()
        setLockStatus(true)
    }


    fun setLockStatus(status:Boolean){
        this.wasPaused = status
    }

    override fun onWindowFocusChanged(hasFocus: Boolean) {
        super.onWindowFocusChanged(hasFocus)
        HomeFrag?.onWindowFocusChange()
    }

}
