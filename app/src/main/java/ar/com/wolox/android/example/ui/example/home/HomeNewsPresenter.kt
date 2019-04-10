package ar.com.wolox.android.example.ui.example.home

import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.network.NewsService
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import ar.com.wolox.wolmo.networking.retrofit.callback.NetworkCallback
import okhttp3.ResponseBody
import javax.inject.Inject

class HomeNewsPresenter : BasePresenter<IHomeNewsView>() {

    @Inject lateinit var retrofitService: RetrofitServices

    fun onFirstInit() {
        retrofitService.getService(NewsService::class.java).getNews().enqueue(
                object : NetworkCallback<List<News>>() {

                    override fun onResponseSuccessful(news: List<News>?) {
                        view.onNewsGetFromDatabase(news)
                    }

                    override fun onCallFailure(throwable: Throwable) {

                    }

                    override fun onResponseFailed(body: ResponseBody?, code: Int) {

                    }
                }
        )
    }
}