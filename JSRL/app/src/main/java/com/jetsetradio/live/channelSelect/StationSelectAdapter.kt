package com.jetsetradio.live.channelSelect

import android.content.Context
import android.graphics.Color
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.android.material.card.MaterialCardView
import com.jetsetradio.live.R
import java.util.*


class StationSelectAdapter(private val ctx: Context?, private val cardViewHolderArrayList: ArrayList<ImageModel>) : BaseAdapter() {

    inner class CardViewHolder {
        var icon: ImageView? = null
        var name: TextView? = null
        var card: MaterialCardView? = null
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
            holder.card = convertView?.findViewById(R.id.card_view)
            convertView.tag = holder
        }
        else {
            // View recycled !
            // no need to inflate
            // no need to findViews by id
            holder = convertView.tag as CardViewHolder
        }
        if (ctx != null) {
            //load the station icon into the card view
            holder.icon?.let { Glide.with(ctx).load(cardViewHolderArrayList[position].image_drawable).into(it) }
        }
        holder.name?.text = cardViewHolderArrayList[position].name
        holder.card?.apply { // border color
            // border color
            strokeColor = Color.parseColor(cardViewHolderArrayList[position].color)
            // border width in dp
            strokeWidth = 4.toDp(context)
            // card corner radius
            radius = 12.toDp(context).toFloat()
        }
        return convertView
    }

    // extension method to convert pixels to dp
    private fun Int.toDp(context: Context):Int = TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,this.toFloat(),context.resources.displayMetrics
    ).toInt()

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