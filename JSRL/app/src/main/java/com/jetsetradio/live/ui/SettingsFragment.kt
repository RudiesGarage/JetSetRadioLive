package com.jetsetradio.live.ui

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.TextView.OnEditorActionListener
import androidx.fragment.app.Fragment
import com.jetsetradio.live.R
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlin.random.Random


class SettingsFragment: Fragment() {
    private var PRIVATE_MODE = 0
    private val SETTINGS_NAME = "JSR SETTINGS"
    private val BUMPS = "Bumps"
    private val USERNAME = "CHAT_USERNAME"
    private val CHAT_NOTIFICATIONS = "Chat_Notifications"
    private var sharedPref: SharedPreferences? = null


    // When fragment is loaded
    override fun onAttach(context: Context) {
        super.onAttach(context)
        sharedPref = context.getSharedPreferences(SETTINGS_NAME, PRIVATE_MODE)
        loadSettings()
    }

    override fun onStart() {
        super.onStart()
        usernameInput.setText( sharedPref!!.getString(USERNAME,"RUDIE_DEFAULT"))
        bumpsSwitch.isChecked = sharedPref!!.getBoolean(BUMPS,true)
        chatSwitch.isChecked = sharedPref!!.getBoolean(CHAT_NOTIFICATIONS,true)
        setClients()
    }


    // load all view assets
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_settings, container, false)
    }

    private fun loadSettings(){

        if (sharedPref != null) {

            //Chat Username
            if (!sharedPref!!.contains(USERNAME)) {
                val editor = sharedPref!!.edit()
                val name = "Rudie_" + Random.nextInt(10,300)
                editor.putString(USERNAME, name)
                editor.apply()
                Log.d("SETTINGS_CHAT_USERNAME", name)
            } else {
                Log.d("SETTINGS_CHAT_USERNAME", sharedPref!!.getString(USERNAME,"RUDIE_DEFAULT"))
            }
             //Bumps
            if (!sharedPref!!.contains(BUMPS)) {
                val editor = sharedPref!!.edit()
                editor.putBoolean(BUMPS, true)
                editor.apply()
                Log.d("SETTINGS_BUMPS", sharedPref!!.getBoolean(BUMPS,true).toString())
            } else {
                Log.d("SETTINGS_BUMPS", sharedPref!!.getBoolean(BUMPS,true).toString())
            }

            //Chat Notifications
            if (!sharedPref!!.contains(CHAT_NOTIFICATIONS)) {
                val editor = sharedPref!!.edit()
                editor.putBoolean(CHAT_NOTIFICATIONS, true)
                editor.apply()
                Log.d("SETTINGS_CHAT_NOTIF", sharedPref!!.getBoolean(CHAT_NOTIFICATIONS,true).toString())
            } else {
                Log.d("SETTINGS_CHAT_NOTIF", sharedPref!!.getBoolean(CHAT_NOTIFICATIONS,true).toString())
            }

        }
    }

    private fun setClients() {
        //Handle Username
        usernameInput.setOnEditorActionListener(OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {

                // apply changes to settings
                val editor = sharedPref!!.edit()
                editor.putString(USERNAME, usernameInput.text.toString())
                editor.apply()

                // Hide the keyboard
                val imm: InputMethodManager = context!!.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                imm.hideSoftInputFromWindow(view!!.windowToken, 0)

                //remove focus
                usernameInput.clearFocus()
                return@OnEditorActionListener true
            }
            false
        })
        //Handle Bumps
        bumpsSwitch.setOnClickListener {
            val editor = sharedPref!!.edit()
            editor.putBoolean(BUMPS, bumpsSwitch.isChecked)
            editor.apply()
        }
        //handle Chat notifications
        chatSwitch.setOnClickListener {
            val editor = sharedPref!!.edit()
            editor.putBoolean(CHAT_NOTIFICATIONS, bumpsSwitch.isChecked)
            editor.apply()
        }
    }

}