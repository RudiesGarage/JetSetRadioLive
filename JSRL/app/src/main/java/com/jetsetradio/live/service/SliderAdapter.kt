package com.jetsetradio.live.service

import android.animation.ObjectAnimator
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.jetsetradio.live.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.station_icon.view.*

class SliderAdapter(context: Context, IconArray: List<Int>) : PagerAdapter() {
    var context: Context? = context
    var stationImageData: List<Int>? = IconArray


    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return stationImageData?.size!!
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View = LayoutInflater.from(context).inflate(R.layout.station_icon,container,false)

        val icon: ImageView = view.findViewById(R.id.stationIcon)
        stationImageData?.get(position)?.let { icon.setImageResource(it) }

        val StationIconRatation = ObjectAnimator.ofFloat(view, "rotationY", 0.0f, 360f)
        StationIconRatation.duration = 3600
        StationIconRatation.repeatCount = ObjectAnimator.INFINITE
        StationIconRatation.interpolator = AccelerateDecelerateInterpolator()
        StationIconRatation.start()

        container.addView(view)
        return view

    }



}