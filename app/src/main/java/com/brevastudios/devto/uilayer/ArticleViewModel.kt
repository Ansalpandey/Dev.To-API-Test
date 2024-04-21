package com.brevastudios.devto.uilayer

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brevastudios.devto.datalayer.ArticleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ArticleViewModel @Inject constructor(private val repository: ArticleRepository) : ViewModel() {

    val articalStateHolder = mutableStateOf(ArticleStateHolder())

    init {
        getAllArticles()
    }

    private fun getAllArticles() {
        viewModelScope.launch {
            try {
                val articles = repository.getArticleList()
                articalStateHolder.value = ArticleStateHolder(data = articles.data)
            } catch (e: Exception) {
                articalStateHolder.value = ArticleStateHolder(error = "Failed to fetch articles: ${e.message}")
            }
        }
    }
}
