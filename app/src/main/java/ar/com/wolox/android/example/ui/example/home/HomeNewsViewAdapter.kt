package ar.com.wolox.android.example.ui.example.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News

class HomeNewsViewAdapter(private val dataSet: List<News>) :
        RecyclerView.Adapter<HomeNewsViewAdapter.NewsItemViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsItemViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.fragment_home_news_item, parent, false)

        return NewsItemViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: NewsItemViewHolder, position: Int) {
        val itemData: News = dataSet[position]
        holder.title.text = itemData.title
        holder.description.text = itemData.description
    }

    override fun getItemCount(): Int = dataSet.size

    class NewsItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.vHomeNewsItemTitle)
        val description: TextView = itemView.findViewById(R.id.vHomeNewsItemDescription)
    }
}
