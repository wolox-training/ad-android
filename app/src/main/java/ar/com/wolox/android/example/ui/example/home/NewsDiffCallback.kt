package ar.com.wolox.android.example.ui.example.home

import android.support.v7.util.DiffUtil
import ar.com.wolox.android.example.model.News

class NewsDiffCallback : DiffUtil.ItemCallback<News>() {

    override fun areContentsTheSame(n0: News, n1: News): Boolean = n0.hasSameContent(n1)

    override fun areItemsTheSame(n0: News, n1: News): Boolean = n0 == n1
}