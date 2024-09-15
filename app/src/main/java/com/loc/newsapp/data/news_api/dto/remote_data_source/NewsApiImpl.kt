package com.loc.newsapp.data.news_api.dto.remote_data_source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.loc.newsapp.core.constants.UserSettings.API_KEY
import com.loc.newsapp.data.models.Article

class NewsPagingSource(private val newsApi: NewsApi, private val source: String) : PagingSource<Int, Article>() {

    private var totalLoadedArticle = 0

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        // Get the anchor position from the state
        val anchorPosition = state.anchorPosition ?: return null

        // Find the closest page to the anchor position
        val anchorPage = state.closestPageToPosition(anchorPosition) ?: return null

        // Return the key for the closest page to the anchor position
        return anchorPage.prevKey?.plus(1) ?: anchorPage.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {

        val page = params.key ?: 1
        try {
            val response =
                newsApi.getNews(page = page, apiKey = API_KEY, sources = source)
            totalLoadedArticle += response.articles.size
            return LoadResult.Page(
                data = response.articles.distinctBy { it.title },
                prevKey = null,
                nextKey = if (totalLoadedArticle == response.totalResults) null else page +1
            )
        } catch (e: Exception) {
            e.printStackTrace()
            return LoadResult.Error(throwable = e)
        }
    }


}