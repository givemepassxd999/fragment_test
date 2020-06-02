package com.example.myapplication

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class SingerDetailItemHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val info: TextView = itemView.findViewById(R.id.info)
}