package ar.com.wolox.android.example.ui.example.home

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import ar.com.wolox.android.R

class NewsItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val title: TextView = itemView.findViewById(R.id.vHomeNewsItemTitle)
    val description: TextView = itemView.findViewById(R.id.vHomeNewsItemDescription)
}