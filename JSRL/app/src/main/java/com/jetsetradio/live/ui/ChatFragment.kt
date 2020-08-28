package com.jetsetradio.live.ui

import android.app.Activity
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.jetsetradio.live.R
import com.jetsetradio.live.data.aMessage
import com.jetsetradio.live.service.ChatAdapter
import com.jetsetradio.live.service.XmlHandler
import kotlinx.android.synthetic.main.fragment_chat.*
import kotlinx.android.synthetic.main.fragment_settings.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.Dispatchers.Main
import kotlinx.coroutines.launch
import okhttp3.*
import org.json.JSONException
import org.json.JSONObject
import org.xml.sax.InputSource
import org.xml.sax.XMLReader
import java.io.BufferedReader
import java.io.IOException
import java.net.HttpURLConnection
import java.net.URL
import javax.xml.parsers.SAXParser
import javax.xml.parsers.SAXParserFactory
import kotlin.properties.Delegates
import kotlin.random.Random


class ChatFragment : Fragment() , ChatAdapter.ItemClickListener{
    //TODO implement chat fragment and notifications
    //todo implement keyboard and send
    private var MessageArray by Delegates.observable(ArrayList<aMessage>()) { _, oldValue, newValue ->
        loadFetchDataOnMainThread(newValue)
    }
    private var PRIVATE_MODE = 0
    private val SETTINGS_NAME = "JSR SETTINGS"
    private val USERNAME = "CHAT_USERNAME"

    var adapter: ChatAdapter? = null
    // When fragment is loaded
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)

    }



    @Throws(IOException::class)
    fun postRequest() {
        val url = URL("http://jetsetradio.live/chat/save.php?")
        val text = sendMessage.text.toString()
        val MEDIA_TYPE = MediaType.parse("application/x-www-form-urlencoded")
        val sharedPref: SharedPreferences? = context?.getSharedPreferences(SETTINGS_NAME, PRIVATE_MODE)
        val username = sharedPref?.getString(USERNAME,"RUDIE_DEFAULT")
        val body = RequestBody.create(MEDIA_TYPE, "chatmessage=!#ffffff "+text+"&username="+username)

        val client = OkHttpClient()
        val request: Request = Request.Builder()
                .url(url)
                .post(body)
                .header("Content-Type", "application/x-www-form-urlencoded")
                .build()

//        Response response = client.newCall(request).execute();
//        Log.e(TAG, response.body().string());
        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call?, e: IOException) {
                val mMessage: String = e.localizedMessage.toString()
                Log.w("failure Response", mMessage)
                //call.cancel();
            }

            @Throws(IOException::class)
            override fun onResponse(call: Call?, response: Response) {
                val mMessage: String = response.body()?.string() ?: "No Response"
                Log.e("", mMessage)
                CoroutineScope(IO).launch{
                    fetch()
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


    private  fun loadFetchDataOnMainThread(data: ArrayList<aMessage>){
        CoroutineScope(Main).launch{
            adapter = ChatAdapter(context, data)
            recyclerView.adapter = adapter
            recyclerView.layoutManager = LinearLayoutManager(context)
            adapter?.itemCount?.minus(1)?.let { recyclerView.scrollToPosition(it) }
            logThread("loadFetchDataOnMainThread")
        }
    }

    private fun fetch(){
        logThread("fetch")
        val url = URL("https://jetsetradio.live/chat/messages.xml")

        val factory: SAXParserFactory = SAXParserFactory.newInstance()
        val parser: SAXParser = factory.newSAXParser()
        val xmlreader: XMLReader = parser.xmlReader
        val theRSSHandler =  XmlHandler()
        xmlreader.contentHandler = theRSSHandler
        val stream = InputSource(url.openStream())
        xmlreader.parse(stream)
        MessageArray = theRSSHandler.getFeed()

    }

    private fun logThread(methodname:String){
        Log.e("debug: $methodname", Thread.currentThread().name)
    }

    override fun onStart() {
        super.onStart()

        CoroutineScope(IO).launch{
            fetch()
        }
        sendButton.setOnClickListener {
            Log.e("","Send button clicked")
            postRequest()
        }

        adapter?.itemCount?.minus(1)?.let { recyclerView.scrollToPosition(it) }
    }

    // load all view assets
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    override fun onItemClick(view: View?, position: Int) {
        TODO("Not yet implemented")
    }


}