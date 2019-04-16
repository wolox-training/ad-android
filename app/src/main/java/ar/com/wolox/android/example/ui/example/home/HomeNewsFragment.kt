package ar.com.wolox.android.example.ui.example.home

import android.content.Intent
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.ui.example.signup.SignUpActivity
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.fragment_home_news.*
import java.util.LinkedList
import javax.inject.Inject

class HomeNewsFragment @Inject constructor() : WolmoFragment<HomeNewsPresenter>(), IHomeNewsView {

    private val newsViewAdapter = HomeNewsViewAdapter()
    private val newsList = LinkedList<News>()

    override fun init() {
        vHomeNewsSwipeRefreshLayout.setColorSchemeResources(R.color.colorWoloxGreen,
                R.color.colorWoloxBlue)

        vHomeNewsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            adapter = newsViewAdapter
        }

        presenter.onInit()
    }

    override fun setListeners() {
        vHomeNewsAddButton.setOnClickListener {
            val intent = Intent(context, SignUpActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_NEW_TASK
            }

            startActivity(intent)
        }

        vHomeNewsSwipeRefreshLayout.setOnRefreshListener {
            presenter.onRefresh()
        }
    }

    override fun layout(): Int = R.layout.fragment_home_news

    override fun onNewsGotFromDatabase(news: List<News>?) {
        if (news != null) {
            for (n in news) {
                newsList.push(n)
            }

            newsViewAdapter.submitList(LinkedList<News>(newsList))
        }
    }

    override fun onRefresh(news: List<News>?) {
        // This list is a hardcoded one, for test. Instead using the given from parameter
        val newestNews = LinkedList<News>()
        newestNews.add(News(69, 1, "2019-01-18T14:00:29.985Z", "Training",
                "https://avatars2.githubusercontent.com/u/48364172?s=60&v=4",
                "Hardcoded new to test refresh", ArrayList()))
        onNewsGotFromDatabase(newestNews)
        vHomeNewsSwipeRefreshLayout.isRefreshing = false
    }
}
