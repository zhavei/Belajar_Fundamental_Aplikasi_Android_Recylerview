package com.syafei.belajarfundamentalaplikasiandroidrecylerview.myrecylerview.ui.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.syafei.belajarfundamentalaplikasiandroidrecylerview.R

class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
    var tvDescription: TextView = itemView.findViewById(R.id.tv_item_description)

}