package ar.com.wolox.android.example.ui.example.home

import android.support.v7.recyclerview.extensions.ListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News

class HomeNewsViewAdapter(private val dataSet: List<News>) :
        ListAdapter<News, HomeNewsViewAdapter.NewsItemViewHolder>(HomeNewsViewAdapter
                .NewsDiffCallback()) {

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

    class NewsDiffCallback : DiffUtil.ItemCallback<News>() {

        override fun areContentsTheSame(n0: News, n1: News): Boolean = n0 == n1

        override fun areItemsTheSame(n0: News, n1: News): Boolean = n0 == n1
    }
}
