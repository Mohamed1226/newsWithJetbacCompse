package com.loc.newsapp.core.repository

import androidx.paging.PagingData
import com.loc.newsapp.data.models.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {


    fun getNews(sources : List<String>) : Flow<PagingData<Article>>
}