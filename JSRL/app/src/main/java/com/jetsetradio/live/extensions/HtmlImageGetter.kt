package com.jetsetradio.live.extensions

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.sufficientlysecure.htmltextview.HtmlResImageGetter
import java.io.InputStream
import java.net.HttpURLConnection
import java.net.URL

class HtmlImageGetter(context: Context) : HtmlResImageGetter(context){
    private val lock = Any()
    override fun getDrawable(source: String?): Drawable {
        var x: Bitmap? = null

        synchronized (lock) {
            CoroutineScope(Dispatchers.IO).launch{

                    val connection: HttpURLConnection =  URL(source).openConnection() as HttpURLConnection
                    connection.connect();
                    val input: InputStream = connection.inputStream;

                    x = BitmapFactory.decodeStream(input);
                }

            return  BitmapDrawable(Resources.getSystem(), x);
        }
    }


}
