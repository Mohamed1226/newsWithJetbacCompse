package com.loc.newsapp.data.news_api.dto.remote_data_source

import com.loc.newsapp.data.news_api.dto.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("everything")
    suspend fun getNews(
        @Query("page") page: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String,
    ): NewsResponse
}