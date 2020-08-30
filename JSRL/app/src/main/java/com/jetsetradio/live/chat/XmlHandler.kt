package com.jetsetradio.live.chat

import android.util.Log
import org.jsoup.Jsoup
import org.jsoup.nodes.Document
import org.jsoup.select.Elements
import org.xml.sax.Attributes
import org.xml.sax.SAXException
import org.xml.sax.helpers.DefaultHandler

// this class does all heavy lifting on parsing the xml requests from jsrl
class XmlHandler() : DefaultHandler() {
    var messages = ArrayList<aMessage>()
    var currentElement = false
    var currentValue = ""
    var item: aMessage? = null


    fun getFeed():ArrayList<aMessage>{
        return messages
    }


    @Throws(SAXException::class)
    override fun characters(ch: CharArray?, start: Int, length: Int) {
        if (currentElement) {
            currentValue += String(ch!!, start, length)
        }
    }

    @Throws(SAXException::class)
    override fun startDocument() {
        Log.e("XMLHANDLER","START DOCUMENT")
    }

    @Throws(SAXException::class)
    override fun endDocument() {
        Log.e("XMLHANDLER","END DOCUMENT")
    }

    @Throws(SAXException::class)
    override fun startElement(uri: String?, lName: String?, qName: String?, attr: Attributes?) {
        currentElement = true
        currentValue = ""
        if (lName.equals("message")) {
            item = aMessage()
        }

    }

    @Throws(SAXException::class)
    override fun endElement(uri: String?, localName: String?, qName: String?) {
        currentElement = false;

        /** set value */
        // this is a check for curl injections in the xml file
        // ie if you go to /save.php with no vars, then the username will not exist
        if(!currentValue.isBlank()) {
            when {
                localName.equals(username) -> item?.username = parseHTML(currentValue) + ":"
                localName.equals(ip) -> item?.ip = currentValue
                localName.equals(text) -> item?.text = parseHTML(currentValue)
                localName.equals(timestamp) -> item?.timestamp = currentValue
                localName.equals("message") -> item?.let { messages.add(it) }
            }
        }
    }

    private fun parseHTML(input:String):String{
        //element is html
        if(input[0] == '<') {
            val doc: Document = Jsoup.parseBodyFragment(input).normalise()
            val fontEle: Elements? = doc.getElementsByTag("font")

            val iframeEle: Elements? = doc.getElementsByTag("iframe")
            if(iframeEle!=null){
                if(!iframeEle.isEmpty()){
                    return iframeEle[0]?.attr("src").toString()
                }
            }

            // Get image src
            val ImgEle: Elements? = doc.getElementsByTag("img")
            if(ImgEle!=null){
                if(!ImgEle.isEmpty()){
                    item?.image = ImgEle[0]?.attr("src").toString()
                    if(item?.image?.contains("gif")!!){
                        item?.isGIF = true
                    }
                    return ImgEle[0].text()
                }
            }

            //get text color
            if(fontEle!=null){
                if(!fontEle.isEmpty()){
                    //replace font HTML tag with proper XML tag
                    val line = "<font style=\'color:"
                    val newline = "<font color=\'"
                    var t =input.replace(line,newline)
                    t = t.replace(";\'>","'>")

                    return t
                }
            }



        }
        return input
    }

    companion object {
        private const val username = "username"
        private const val text = "text"
        private const val ip = "ip"
        private const val timestamp = "timestamp"
    }
}