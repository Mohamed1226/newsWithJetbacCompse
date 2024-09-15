package com.loc.newsapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.loc.newsapp.core.repository.NewsRepository
import com.loc.newsapp.core.usecases.news_screen.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class NewsViewModel @Inject constructor(useCases: NewsUseCases) : ViewModel() {


    val news = useCases.invoke(sources = listOf("bbc-news", "abc-news", "al-jazeera-english"))
        .cachedIn(viewModelScope)
}