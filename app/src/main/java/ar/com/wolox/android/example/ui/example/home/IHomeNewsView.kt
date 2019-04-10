package ar.com.wolox.android.example.ui.example.home

import ar.com.wolox.android.example.model.News

interface IHomeNewsView {
    fun onNewsGetFromDatabase(news: List<News>?)
}