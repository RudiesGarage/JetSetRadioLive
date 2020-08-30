package com.jetsetradio.live.channelSelect


import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView.OnItemClickListener
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.jetsetradio.live.R
import com.jetsetradio.live.data.MusicLibrary
import kotlinx.android.synthetic.main.fragment_stationselect.*


class StationSelectFragment : Fragment() {
    private lateinit var callback: OnHeadlineSelectedListener

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.fragment_stationselect, container, false)
    }

    private fun populateList(): ArrayList<ImageModel> {
        val list: ArrayList<ImageModel> = ArrayList()
        //Get all station Icons
        val stationIconList: ArrayList<ArrayList<Any>> = MusicLibrary.getStationData().getQuickSelectData()

        for (icons in stationIconList) {
            val imageModel = ImageModel()
            imageModel.name = icons[0].toString()
            imageModel.image_drawable = icons[1] as Int
            imageModel.color = icons[2].toString()
            list.add(imageModel)
        }
        return list
    }

    override fun onStart() {
        super.onStart()

        val adapter = StationSelectAdapter(context, populateList())
        gv.adapter = adapter
        gv.onItemClickListener = OnItemClickListener { _, _, position, _ ->
            Toast.makeText(context, " Clicked Position: $position",
                    Toast.LENGTH_SHORT).show()
            Log.d("Station Select FRAGMENT", "Clicked Position: $position")
            callback.onArticleSelected(position)
        }
    }

    fun setOnHeadlineSelectedListener(callback: OnHeadlineSelectedListener) {
        this.callback = callback
    }

    // This interface can be implemented by the Activity, parent Fragment,
    // or a separate test implementation.
    interface OnHeadlineSelectedListener {
        fun onArticleSelected(position: Int)
    }

}
