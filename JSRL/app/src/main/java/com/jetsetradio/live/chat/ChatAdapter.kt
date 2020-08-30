package com.jetsetradio.live.chat

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.felipecsl.gifimageview.library.GifImageView
import com.jetsetradio.live.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.io.ByteArrayOutputStream
import java.io.IOException
import java.io.InputStream
import java.net.URL


class ChatAdapter(val ctx:Context?,var data: ArrayList<aMessage>) : RecyclerView.Adapter<ChatAdapter.ViewHolder>(){
    private var mData: ArrayList<aMessage> = data
    private var mInflater: LayoutInflater = LayoutInflater.from(ctx)
    private var mClickListener: View.OnClickListener? = null

    // parent class of view holders that holds the username
    open class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var usernameView: TextView = itemView.findViewById(R.id.usernameTEXT)
    }

     class MessageViewHolder(itemView: View) : ViewHolder(itemView) {
        var textView: TextView = itemView.findViewById(R.id.messageTEXT)
    }

    class GifViewHolder(itemView: View) : ViewHolder(itemView) {
        var myGifView: GifImageView = itemView.findViewById(R.id.messageGIF)
    }

    class ImageViewHolder(itemView: View) : ViewHolder(itemView) {
        var myImageView: ImageView = itemView.findViewById(R.id.messageIMG)
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return when (viewType) {
            1 -> {
                val view: View = mInflater.inflate(R.layout.message_row_gif, parent, false)
                GifViewHolder(view)
            }
            2 -> {
                val view: View = mInflater.inflate(R.layout.message_row_image, parent, false)
                ImageViewHolder(view)
            }
            else -> {
                val view: View = mInflater.inflate(R.layout.message_row, parent, false)
                MessageViewHolder(view)
            }
        }
    }

    override fun getItemViewType(position: Int): Int {
        if(getItem(position)?.image == ""){
            return 0  // if no image then just display message
        }
        // check if the image is a gif
        else if(getItem(position)?.isGIF!!){
            return 1
        }
        return 2 //otherwise display image only
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val message = mData[position]

        // load username
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.usernameView.setText(Html.fromHtml(message.username,  Html.FROM_HTML_MODE_LEGACY), TextView.BufferType.SPANNABLE)
        } else {
            holder.usernameView.setText(Html.fromHtml(message.username), TextView.BufferType.SPANNABLE)
        }

        // If gif message
        if(holder is GifViewHolder){
            // Todo this should be in separate thread
            CoroutineScope(Dispatchers.IO).launch{
                val url = URL(message.image)
                val baos = ByteArrayOutputStream()
                var `is`: InputStream? = null
                try {
                    `is` = url.openStream()
                    val byteChunk = ByteArray(4096) // Or whatever size you want to read in at a time.
                    var n: Int
                    while (`is`.read(byteChunk).also { n = it } > 0) {
                        baos.write(byteChunk, 0, n)
                    }
                } catch (e: IOException) {
                    System.err.printf("Failed while reading bytes from %s: %s", url.toExternalForm(), e.message)
                    e.printStackTrace()
                    // Perform any other exception handling that's appropriate.
                } finally {
                    `is`?.close()

                    //Android studio says this will not be null but async might says otherwise
                    if(baos!= null){
                        holder.myGifView.setBytes(baos.toByteArray())
                        holder.myGifView.startAnimation()
                    }
                }
            }
            holder.myGifView.setOnClickListener({
                //TODO set copy image
            })
        }
        // If text message
        else if(holder is MessageViewHolder){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                holder.textView.setText(Html.fromHtml(message.text,  Html.FROM_HTML_MODE_LEGACY), TextView.BufferType.SPANNABLE)
            } else {
                holder.textView.setText(Html.fromHtml(message.text), TextView.BufferType.SPANNABLE)
            }
            holder.itemView.setOnClickListener({
                //TODO set copy message
            })
        }
        // if static image
        else if (holder is ImageViewHolder){
            if (ctx != null) {
                Glide.with(ctx).asBitmap().load(message.image).into(holder.myImageView)
            }
            holder.myImageView.setOnClickListener({
                //TODO set copy image
            })
        }
    }

    // convenience method for getting data at click position
    private fun getItem(id: Int): aMessage? {
        return mData[id]
    }

    // allows clicks events to be caught
    fun setClickListener(itemClickListener: View.OnClickListener?) {
        mClickListener = itemClickListener
    }

    // parent activity will implement this method to respond to click events
    interface ItemClickListener {
        fun onItemClick(view: View?, position: Int)
    }


}