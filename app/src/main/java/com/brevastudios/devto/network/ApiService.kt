package com.brevastudios.devto.network

import com.brevastudios.devto.model.ArticleItem
import retrofit2.http.GET

/**
 * An interface for interacting with an API.
 */
interface ApiService {
    /**
     * Retrieves a list of all articles.
     *
     * @return A list of ArticleItem objects.
     */
    @GET("articles")
    suspend fun getAllArticles() : List<ArticleItem>
}