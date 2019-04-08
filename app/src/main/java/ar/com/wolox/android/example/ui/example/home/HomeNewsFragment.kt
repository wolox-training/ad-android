package ar.com.wolox.android.example.ui.example.home

import android.support.v7.widget.LinearLayoutManager
import ar.com.wolox.android.R
import ar.com.wolox.android.example.model.News
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import kotlinx.android.synthetic.main.fragment_home_news.*
import javax.inject.Inject

class HomeNewsFragment @Inject constructor() : WolmoFragment<BasePresenter<Any>>() {

    override fun init() {
        vHomeNewsRecyclerView.apply {
            // TODO FOR NEXT PR (Backend): change this list for data from a request to DB/API
            adapter = HomeNewsViewAdapter(listOf(News("Hello",
                    "Description of the hello"), News("Bye",
                    "Description of the bye")))
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun layout(): Int = R.layout.fragment_home_news
}
