package com.jetsetradio.live.utils

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.jetsetradio.live.R
import com.jetsetradio.live.data.ImageModel
import java.util.*


class GridBaseAdapter(private val ctx: Context?, private val cardViewHolderArrayList: ArrayList<ImageModel>) : BaseAdapter() {

    inner class CardViewHolder {
        var icon: ImageView? = null
        var name: TextView? = null
    }

    override fun getView(position: Int, tempView: View?, parent: ViewGroup?): View? {

        var convertView = tempView  //trying to reuse a recycled view
        val holder: CardViewHolder
        if (convertView == null) {
            //The view is not a recycled one: we have to inflate
            convertView = LayoutInflater.from(ctx).inflate(R.layout.grid_item, parent,false)

            holder = CardViewHolder()
            holder.name = convertView?.findViewById(R.id.StationName)
            holder.icon = convertView?.findViewById(R.id.StationQuickIcon)
            convertView.tag = holder
        }
        else {
            // View recycled !
            // no need to inflate
            // no need to findViews by id
            holder = convertView.tag as CardViewHolder
        }
        if (ctx != null) {
            holder.icon?.setImageBitmap(BitmapFactory.decodeResource(ctx.resources, cardViewHolderArrayList[position].image_drawable))
        }
        holder.name?.text = cardViewHolderArrayList[position].name

        return convertView
    }


    override fun getItem(position: Int): ImageModel {
        return cardViewHolderArrayList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return cardViewHolderArrayList.size
    }




}