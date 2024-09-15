package com.loc.newsapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.loc.newsapp.core.repository.NewsRepository
import com.loc.newsapp.data.models.Article
import com.loc.newsapp.data.news_api.dto.remote_data_source.NewsApi
import com.loc.newsapp.data.news_api.dto.remote_data_source.NewsPagingSource
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(private  val newsApi: NewsApi) : NewsRepository {
    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
       return  Pager(
           config = PagingConfig(
               pageSize = 10
           ),
           pagingSourceFactory = {
               NewsPagingSource(newsApi = newsApi, source = sources.joinToString(separator = ","))
           }
       ).flow
    }
}