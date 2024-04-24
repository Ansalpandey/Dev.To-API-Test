package com.brevastudios.devto.datalayer

import com.brevastudios.devto.common.Resource
import com.brevastudios.devto.model.ArticleItem
import javax.inject.Inject

/**
 * A repository class that provides access to article data.
 *
 * @param articleDataSource The data source for articles.
 */
class ArticleRepository @Inject constructor(private val articleDataSource: ArticleDataSource) {

    /**
     * Gets a list of articles.
     *
     * @return A Resource object containing either a list of articles or an error message.
     */
    suspend fun getArticleList(): Resource<List<ArticleItem>> {
        return try {
            Resource.Success(data = articleDataSource.getAllArticles())
        } catch (e: Exception) {
            Resource.Error(message = e.message.toString())
        }
    }
}