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
                        view.onNewsGotFromDatabase(triplicateNews(news))
                    }

                    override fun onCallFailure(throwable: Throwable) {
                        view.onInvalidCallError()
                    }

                    override fun onResponseFailed(body: ResponseBody?, code: Int) {
                        view.onServerError()
                    }
                }
        )
    }

    fun onRefresh() {
        // This must check for newest news. I will get all of them again because of the API design
        retrofitService.getService(NewsService::class.java).getNews().enqueue(
                object : NetworkCallback<List<News>>() {

                    override fun onResponseSuccessful(news: List<News>?) {
                        view.onRefresh(news)
                    }

                    override fun onCallFailure(throwable: Throwable) {
                        view.onInvalidCallError()
                    }

                    override fun onResponseFailed(body: ResponseBody?, code: Int) {
                        view.onServerError()
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