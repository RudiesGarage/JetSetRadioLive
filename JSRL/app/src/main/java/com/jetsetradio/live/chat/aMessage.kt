package com.jetsetradio.live.chat

// This class holds the information of a chat message
class aMessage() {
    var username: String = ""
    var text: String = ""
    var ip: String = ""
    var timestamp: String = ""
    var image: String = ""
    var isGIF: Boolean = false

    fun isEqual(msg:aMessage):Boolean{
        if(this.timestamp == msg.timestamp) return true
        return false
    }

}