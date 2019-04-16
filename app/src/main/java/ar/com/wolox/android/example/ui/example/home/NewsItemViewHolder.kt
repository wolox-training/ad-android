package ar.com.wolox.android.example.ui.example.home

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import ar.com.wolox.android.R
import com.facebook.drawee.view.SimpleDraweeView

class NewsItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    val image: SimpleDraweeView = itemView.findViewById(R.id.vHomeNewsItemImageView)
    val title: TextView = itemView.findViewById(R.id.vHomeNewsItemTitle)
    val description: TextView = itemView.findViewById(R.id.vHomeNewsItemDescription)
    val time: TextView = itemView.findViewById(R.id.vHomeNewsItemTime)
    val like: ImageButton = itemView.findViewById(R.id.vHomeNewsItemLikeButton)
}