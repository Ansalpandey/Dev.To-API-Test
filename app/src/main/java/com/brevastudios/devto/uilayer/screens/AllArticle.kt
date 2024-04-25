package com.brevastudios.devto.uilayer.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil.compose.AsyncImage
import com.brevastudios.devto.model.ArticleItem
import com.brevastudios.devto.uilayer.ArticleViewModel

/**
 * A Composable function that displays a list of articles.
 *
 * @param viewModel The view model that provides the data for the list.
 */
@Composable
fun ArticleList(viewModel: ArticleViewModel = hiltViewModel()) {
  val result = viewModel.articleStateHolder.value

  if (result.isLoading) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
      CircularProgressIndicator()
    }
  }
  if (result.error.isNotBlank()) {
    Text(text = result.error)
  }
  result.data?.let { LazyColumn { items(result.data) { Article(it = it) } } }
}

/**
 * A Composable function that displays a single article.
 *
 * @param it The article to display.
 */
@Composable
fun Article(it: ArticleItem) {

  Card(modifier = Modifier.fillMaxWidth().padding(12.dp).clickable {}) {
    AsyncImage(
      model = it.cover_image,
      contentDescription = "cover_image",
      modifier = Modifier.fillMaxWidth().height(300.dp),
      contentScale = ContentScale.FillBounds,
    )
    Spacer(modifier = Modifier.height(10.dp))
    Column(modifier = Modifier.fillMaxWidth().padding(12.dp)) {
      Text(text = it.title, fontSize = 24.sp, fontWeight = FontWeight.Bold)
      Spacer(modifier = Modifier.height(8.dp))
      Text(text = it.description)

      Text(text = it.organization?.name.toString())
      Text(text = it.created_at)
      it.edited_at?.let { it1 -> Text(text = it1) }
    }
  }
}
