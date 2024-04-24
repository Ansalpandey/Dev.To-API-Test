package com.brevastudios.devto.datalayer

import com.brevastudios.devto.network.ApiService
import javax.inject.Inject

/**
 * A data source that provides access to articles.
 *
 * @param apiService The API service used to fetch articles.
 */
class ArticleDataSource @Inject constructor(private val apiService: ApiService) {

    /**
     * Fetches all articles from the API.
     *
     * @return A list of articles.
     */
    suspend fun getAllArticles() = apiService.getAllArticles()
}