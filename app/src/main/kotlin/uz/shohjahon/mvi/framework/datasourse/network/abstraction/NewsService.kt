package uz.shohjahon.mvi.framework.datasourse.network.abstraction

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import uz.shohjahon.mvi.framework.datasourse.network.model.response.NewsResponse

interface NewsService {

    @GET("top-headlines?country=us&apiKey=API_KEY")
    suspend fun getNews(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String,
        @Query("category") category: String,
        @Query("pageSize") pageSize: String,
        @Query("page") page: String
    ): Response<NewsResponse>
}