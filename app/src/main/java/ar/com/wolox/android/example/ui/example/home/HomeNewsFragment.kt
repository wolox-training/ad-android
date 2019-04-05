package ar.com.wolox.android.example.ui.example.home

import ar.com.wolox.android.R
import ar.com.wolox.wolmo.core.fragment.WolmoFragment
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import javax.inject.Inject

class HomeNewsFragment @Inject constructor() : WolmoFragment<BasePresenter<Any>>() {

    override fun init() {}

    override fun layout(): Int {
        return R.layout.fragment_home_news
    }
}
