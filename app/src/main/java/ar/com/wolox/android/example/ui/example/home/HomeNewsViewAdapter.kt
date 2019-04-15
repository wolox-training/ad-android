package ar.com.wolox.android.example.ui.example.home

import android.net.Uri
import android.support.v7.recyclerview.extensions.ListAdapter
import android.view.LayoutInflater
import android.view.ViewGroup
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News
import org.ocpsoft.prettytime.PrettyTime
import java.text.SimpleDateFormat

class HomeNewsViewAdapter(private val dataSet: List<News>) :
        ListAdapter<News, NewsItemViewHolder>(NewsDiffCallback()) {

    val prettyTime: PrettyTime = PrettyTime()
    var formatter: SimpleDateFormat = SimpleDateFormat("YYYY-MM-dd'T'HH:mm:ss.SSS'Z'")

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_home_news_item, parent, false)

        return NewsItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        val itemData: News = dataSet[position]
        holder.image.setImageURI(Uri.parse(itemData.picture))
        holder.title.text = itemData.title
        holder.description.text = itemData.text
        holder.time.text = prettyTime.format(formatter.parse(itemData.createdAt))
    }

    override fun getItemCount(): Int = dataSet.size
}
