package com.jetsetradio.live

import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import com.jetsetradio.live.ui.HomeFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .add(R.id.container, HomeFragment.newInstance())
            .commit()
    }
}
