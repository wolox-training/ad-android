package ar.com.wolox.android.example.ui.example.home

import ar.com.wolox.android.example.model.News

interface IHomeNewsView {
    fun onNewsGotFromDatabase(news: List<News>?)

    fun onRefresh(news: List<News>?)

    fun onServerError()

    fun onInvalidCallError()
}