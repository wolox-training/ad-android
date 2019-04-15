package ar.com.wolox.android.example.ui.example.home

import ar.com.wolox.android.example.model.News
import ar.com.wolox.android.example.network.NewsService
import ar.com.wolox.wolmo.core.presenter.BasePresenter
import ar.com.wolox.wolmo.networking.retrofit.RetrofitServices
import ar.com.wolox.wolmo.networking.retrofit.callback.NetworkCallback
import okhttp3.ResponseBody
import java.util.LinkedList
import javax.inject.Inject

class HomeNewsPresenter @Inject constructor() : BasePresenter<IHomeNewsView>() {

    @Inject lateinit var retrofitService: RetrofitServices

    fun onInit() {
        retrofitService.getService(NewsService::class.java).getNews().enqueue(
                object : NetworkCallback<List<News>>() {

                    override fun onResponseSuccessful(news: List<News>?) {
                        view.onNewsGetFromDatabase(triplicateNews(news))
                    }

                    override fun onCallFailure(throwable: Throwable) {
                        //TODO: if is necessary, we can call a function on view to make a Toast
                    }

                    override fun onResponseFailed(body: ResponseBody?, code: Int) {
                        //TODO: if is necessary, we can call a function on view to make a Toast
                    }
                }
        )
    }

    /**
     * This is just for test scrolling and infinite scrolling because the DB has only three items
     */
    private fun triplicateNews(news: List<News>?): LinkedList<News> {
        val triplicatedNews: LinkedList<News> = LinkedList(news)

        if (news != null) {
            triplicatedNews.addAll(news)
            triplicatedNews.addAll(news)
        }

        return triplicatedNews
    }
}