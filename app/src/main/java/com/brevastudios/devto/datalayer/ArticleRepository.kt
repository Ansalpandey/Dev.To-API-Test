package com.brevastudios.devto.datalayer

import com.brevastudios.devto.common.Resource
import com.brevastudios.devto.model.ArticleItem
import javax.inject.Inject

class ArticleRepository @Inject constructor(private val articleDataSource: ArticleDataSource) {
    suspend fun getArticleList(): Resource<List<ArticleItem>> {
        return try {
            Resource.Success(data = articleDataSource.getAllArticles())
        } catch (e: Exception) {
            Resource.Error(message = e.message.toString())
        }
    }
}