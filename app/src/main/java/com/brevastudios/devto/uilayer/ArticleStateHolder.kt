package com.brevastudios.devto.uilayer

import com.brevastudios.devto.common.Resource
import com.brevastudios.devto.model.ArticleItem

data class ArticleStateHolder(
    val isLoading: Boolean = false,
    val data: List<ArticleItem>? = null,
    val error: String = ""
)