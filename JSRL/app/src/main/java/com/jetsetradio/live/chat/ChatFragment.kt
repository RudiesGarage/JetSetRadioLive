package com.jetsetradio.live.chat

import android.app.Activity
import android.content.SharedPreferences
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.jetsetradio.live.R
import kotlinx.android.synthetic.main.fragment_chat.*
import kotlinx.android.synthetic.main.fragment_colorpicker.*
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import okhttp3.*
import org.xml.sax.InputSource
import org.xml.sax.XMLReader
import java.io.IOException
import java.net.URL
import java.util.*
import javax.xml.parsers.SAXParser
import javax.xml.parsers.SAXParserFactory
import kotlin.collections.ArrayList
import kotlin.properties.Delegates


class ChatFragment : Fragment(){
    //TODO implement  notifications

    // Observable to handle when new messages have been received
    private var MessageArray by Delegates.observable(ArrayList<aMessage>()) { _, oldValue, newValue ->
        if(oldValue.isEmpty()){
            loadFetchDataOnMainThread(newValue)
        }
        else if(!oldValue.last().isEqual(newValue.last())){
            loadFetchDataOnMainThread(newValue)
            //TODO set up notification on update
        }
    }
    private var PRIVATE_MODE = 0
    private val SETTINGS_NAME = "JSR SETTINGS"
    private val USERNAME = "CHAT_USERNAME"
    private val CHAT_COLOR = "CHAT_COLOR"
    private var sharedPref: SharedPreferences? = null
    private var adapter: ChatAdapter? = null
    private var color: String? = "#FFFFFF"

    // When fragment is loaded
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
    }

    // POST message data
    private fun postRequest() {
        val url = URL("http://jetsetradio.live/chat/save.php?")
        val text = sendMessage.text.toString()
        val MEDIA_TYPE = MediaType.parse("application/x-www-form-urlencoded")
        val sharedPref: SharedPreferences? = context?.getSharedPreferences(SETTINGS_NAME, PRIVATE_MODE)
        val username = sharedPref?.getString(USERNAME,"RUDIE_DEFAULT")
        val body = RequestBody.create(MEDIA_TYPE, "chatmessage=!$color $text&username=$username")

        val client = OkHttpClient()
        val request: Request = Request.Builder()
                .url(url)
                .post(body)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .build()


        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call?, e: IOException) {
                val mMessage: String = e.localizedMessage.toString()
                Log.w("failure Response", mMessage)
                //call.cancel();
            }

            // fetch response
            override fun onResponse(call: Call?, response: Response) {
                val mMessage: String = response.body()?.string() ?: "No Response"
                Log.e("", mMessage)
                CoroutineScope(IO).launch{
                    fetch() //get new chat log
                }
            }
        })

        sendMessage.text?.clear()

        // Hide the keyboard
        val imm: InputMethodManager = context!!.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view!!.windowToken, 0)

        //remove focus
        sendMessage.clearFocus()

    }

    // load xml into UI
    private fun loadFetchDataOnMainThread(data: ArrayList<aMessage>){
        CoroutineScope(Main).launch{
            //TODO handle recycling to fix GIFS
            if(context!=null){
                adapter = ChatAdapter(context, data)
                recyclerView.adapter = adapter
                recyclerView.layoutManager = LinearLayoutManager(context)

                // scroll to bottom on update
                adapter?.itemCount?.minus(1)?.let { recyclerView.scrollToPosition(it) }
                logThread("loadFetchDataOnMainThread")
            }
        }
    }

    // Fetch XML from JSRL
    private fun fetch(){
        logThread("fetch")
        val url = URL("https://jetsetradio.live/chat/messages.xml")
        val factory: SAXParserFactory = SAXParserFactory.newInstance()
        val parser: SAXParser = factory.newSAXParser()
        val xmlreader: XMLReader = parser.xmlReader
        val theRSSHandler = XmlHandler()
        xmlreader.contentHandler = theRSSHandler
        val stream = InputSource(url.openStream())
        xmlreader.parse(stream)
        MessageArray = theRSSHandler.getFeed()
    }

    private fun logThread(methodname:String){
        Log.e("debug: $methodname", Thread.currentThread().name)
    }

    // Load preferences from settings
    private fun setPreferences(){
        sharedPref = context?.getSharedPreferences(SETTINGS_NAME, PRIVATE_MODE)

        //Chat Color
        if (!sharedPref!!.contains(CHAT_COLOR)) {
            val editor = sharedPref!!.edit()
            editor.putString(CHAT_COLOR, "#FFFFFF")
            editor.apply()
            color = sharedPref!!.getString(CHAT_COLOR,"#FFFFFF")
            colorPicker.setBackgroundColor(Color.parseColor(color))
            Log.d("CHAT_COLOR", sharedPref!!.getString(CHAT_COLOR,"#FFFFFF"))
        } else {
            color = sharedPref!!.getString(CHAT_COLOR,"#FFFFFF")
            colorPicker.setBackgroundColor(Color.parseColor(color))
            Log.d("CHAT_COLOR", sharedPref!!.getString(CHAT_COLOR,"#FFFFFF"))
        }

    }

    // set up onlcick listeners
    private fun setClients(){
        //Set sendButton click
        sendButton.setOnClickListener {
            Log.e("","Send button clicked")
            postRequest()
        }

        //Handle send message input onclick
        sendMessage.setOnClickListener {
            Log.e("","message input text clicked")
            adapter?.itemCount?.minus(1)?.let { recyclerView.scrollToPosition(it) }
        }

        //handle color picker toggle
        colorPicker.setOnClickListener {
            colorSelector.visibility = View.VISIBLE
            chatMessageContainer.visibility = View.GONE
        }

        // handle text picker change
        strColor.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable) {
                when (s.length) {
                    6 -> {
                        try{
                            colorR.progress = Integer.parseInt(s.substring(0..1), 16)
                            colorG.progress = Integer.parseInt(s.substring(2..3), 16)
                            colorB.progress = Integer.parseInt(s.substring(4..5), 16)
                        }
                        catch(e: NumberFormatException){
                            colorR.progress = 255
                            colorG.progress = 255
                            colorB.progress = 255
                        }
                    }
                    else -> {
                        colorR.progress = 255
                        colorG.progress = 255
                        colorB.progress = 255
                    }
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {
            }
        })

        // set up Red Bar
        colorR.max = 255
        colorR.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                           fromUser: Boolean) {
                val colorStr = getColorString()
                strColor.setText(colorStr.replace("#","").toUpperCase(Locale.ROOT))
                btnColorPreview.setBackgroundColor(Color.parseColor(colorStr))
            }
        })

        //set up green bar
        colorG.max = 255
        colorG.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                           fromUser: Boolean) {
                val colorStr = getColorString()
                strColor.setText(colorStr.replace("#","").toUpperCase(Locale.ROOT))
                btnColorPreview.setBackgroundColor(Color.parseColor(colorStr))
            }
        })

        //set up blue bar
        colorB.max = 255
        colorB.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                           fromUser: Boolean) {
                val colorStr = getColorString()
                strColor.setText(colorStr.replace("#","").toUpperCase(Locale.ROOT))
                btnColorPreview.setBackgroundColor(Color.parseColor(colorStr))
            }
        })


        colorCancelBtn.setOnClickListener {
            colorSelector.visibility = View.GONE
            chatMessageContainer.visibility = View.VISIBLE
        }

        colorOkBtn.setOnClickListener {
            val color:String = getColorString()
            colorPicker.setBackgroundColor(Color.parseColor(color))
            colorSelector.visibility = View.GONE
            chatMessageContainer.visibility = View.VISIBLE

            val editor = sharedPref!!.edit()
            editor.putString(CHAT_COLOR, color)
            editor.apply()
        }


    }


    override fun onStart() {
        super.onStart()
        //Load preferences
        setPreferences()

        // Run background thread to fetch chat updates
        val mylamda = Thread {
            while(true){
                fetch()
                Thread.sleep(30000) //fetch new chat every 30 secs
            }
        }
        startThread(mylamda)

        // scroll to bottom of the messages
        adapter?.itemCount?.minus(1)?.let { recyclerView.scrollToPosition(it) }

        //Load click listeners
        setClients()

        // Load color progress from settings
        loadColorString()

        // set the color preview to current bg
        btnColorPreview.setBackgroundColor(Color.parseColor(color))
    }

    fun startThread(mylamda: Thread) {
        mylamda.start()
    }

    // Convert color to string
    fun getColorString(): String {
        var r = Integer.toHexString(((255*colorR.progress)/colorR.max))
        if(r.length==1) r = "0$r"
        var g = Integer.toHexString(((255*colorG.progress)/colorG.max))
        if(g.length==1) g = "0$g"
        var b = Integer.toHexString(((255*colorB.progress)/colorB.max))
        if(b.length==1) b = "0$b"
        return "#$r$g$b"
    }

    //Load color progress from settings
    private fun loadColorString(){
        // Set current color text
        strColor.setText(color?.replace("#","")?.toUpperCase(Locale.ROOT))
        colorR.progress = Integer.parseInt(color!!.substring(1..2), 16)
        colorG.progress = Integer.parseInt(color!!.substring(3..4), 16)
        colorB.progress = Integer.parseInt(color!!.substring(5..6), 16)
    }

    // load all view assets
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }


}