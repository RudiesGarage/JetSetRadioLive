package com.jetsetradio.live.service

import android.animation.ObjectAnimator
import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateDecelerateInterpolator
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.viewpager.widget.PagerAdapter
import com.jetsetradio.live.R
import com.jetsetradio.live.ui.StationSelectFragment


class SliderAdapter(context: Context, IconArray: ArrayList<ArrayList<Int>>, sourceActivity: FragmentActivity?) : PagerAdapter() {
    var context: Context? = context
    var stationImageData: ArrayList<ArrayList<Int>> = IconArray
    private var activity: FragmentActivity? = sourceActivity

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return stationImageData.size
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View?)
    }


    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view: View = LayoutInflater.from(context).inflate(R.layout.station_icon,container,false)

        val icon: ImageView = view.findViewById(R.id.stationIcon)

        icon.setOnClickListener{
            val nextFrag = StationSelectFragment()
            val fragmentManager: FragmentManager? = activity?.supportFragmentManager
            val fragmentTransaction: FragmentTransaction? = fragmentManager?.beginTransaction()
            if (fragmentTransaction != null) {
                fragmentTransaction.add(R.id.container, nextFrag, "StationSelect")
                fragmentTransaction.addToBackStack(null)
                fragmentTransaction.commit()
            }
        }

        val desc: ImageView = view.findViewById(R.id.stationDescription)

        stationImageData.get(position).let {
            icon.setImageBitmap(BitmapFactory.decodeResource(context?.resources, it[0]))
            desc.setImageBitmap(BitmapFactory.decodeResource(context?.resources, it[1]))
        }

        val StationIconRatation = ObjectAnimator.ofFloat(icon, "rotationY", 0.0f, 360f)
        StationIconRatation.duration = 3600
        StationIconRatation.repeatCount = ObjectAnimator.INFINITE
        StationIconRatation.interpolator = AccelerateDecelerateInterpolator()
        StationIconRatation.start()

        container.addView(view)
        return view

    }



}