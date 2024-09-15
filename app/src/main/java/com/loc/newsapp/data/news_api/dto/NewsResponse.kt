package com.loc.newsapp.data.news_api.dto

import com.loc.newsapp.data.models.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)