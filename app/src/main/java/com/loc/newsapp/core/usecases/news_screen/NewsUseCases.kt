package com.loc.newsapp.core.usecases.news_screen

import androidx.paging.PagingData
import com.loc.newsapp.core.repository.NewsRepository
import com.loc.newsapp.data.models.Article
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class NewsUseCases (private val  newsRepository: NewsRepository) {


    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> =  newsRepository.getNews(sources = sources)


}