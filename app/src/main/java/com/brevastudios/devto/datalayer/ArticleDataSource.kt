package com.brevastudios.devto.datalayer

import com.brevastudios.devto.network.ApiService
import javax.inject.Inject

class ArticleDataSource @Inject constructor(private val apiService: ApiService) {

    suspend fun getAllArticles() = apiService.getAllArticles()
}