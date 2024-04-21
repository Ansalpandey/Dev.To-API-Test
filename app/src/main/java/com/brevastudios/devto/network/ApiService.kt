package com.brevastudios.devto.network

import com.brevastudios.devto.model.ArticleItem
import retrofit2.http.GET

interface ApiService {
    @GET("articles")
    suspend fun getAllArticles() : List<ArticleItem>
}