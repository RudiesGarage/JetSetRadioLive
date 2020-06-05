package com.jetsetradio.live.extensions

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created on 3/21/19 by Sang
 * Description:
 **/
fun Long.toTimeString(format: String, locale: Locale = Locale.getDefault()): String {
    val dateFormat = SimpleDateFormat(format, locale)
    return dateFormat.format(Date(this))
}
