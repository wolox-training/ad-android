package ar.com.wolox.android.example.ui.example.home

import android.content.Intent
import android.support.v7.widget.DividerItemDecoration
import android.support.v7.widget.LinearLayoutManager
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.ui.example.signup.SignUpActivity
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import kotlinx.android.synthetic.main.fragment_home_news.*
import javax.inject.Inject

class HomeNewsFragment @Inject constructor() : WolmoFragment<HomeNewsPresenter>(), IHomeNewsView {

    override fun init() {
        vHomeNewsRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
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
    }

    override fun layout(): Int = R.layout.fragment_home_news

    override fun onNewsGetFromDatabase(news: List<News>?) {
        if (news != null) {
            vHomeNewsRecyclerView.adapter = HomeNewsViewAdapter(news)
        }
    }
}
