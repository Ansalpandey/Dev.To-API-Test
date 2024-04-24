package com.brevastudios.devto.uilayer

import com.brevastudios.devto.model.ArticleItem

/**
 * Represents the state of an article.
 *
 * @property isLoading True if the article is loading, false otherwise.
 * @property data The list of articles.
 * @property error The error message, if any.
 */
data class ArticleStateHolder(
    val isLoading: Boolean = false,
    val data: List<ArticleItem>? = null,
    val error: String = "",
)