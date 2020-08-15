package com.jetsetradio.live.ui

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jetsetradio.live.R
import org.w3c.dom.Document
import org.xml.sax.InputSource
import java.io.File
import java.net.URL
import javax.xml.parsers.DocumentBuilder
import javax.xml.parsers.DocumentBuilderFactory


class ChatFragment : Fragment(){

    //TODO implement chat fragment and notifications

    // When fragment is loaded
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(false)
        thread.start();

    }

    // load all view assets
    override fun onCreateView(
            inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_chat, container, false)
    }

    var thread: Thread =  Thread( Runnable() {

        run() {
            try  {
                val url = URL("https://jetsetradio.live/chat/messages.xml")
                val dbf: DocumentBuilderFactory = DocumentBuilderFactory.newInstance()
                val db: DocumentBuilder = dbf.newDocumentBuilder()
                val doc: Document = db.parse(InputSource(url.openStream()))
                doc.documentElement.normalize()
                //TODO populate view based on document children

                Log.e("Chat",doc.toString())
            } catch (e: Exception) {
                e.printStackTrace();
            }
        }
    });



}