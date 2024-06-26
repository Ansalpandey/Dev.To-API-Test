package com.brevastudios.devto

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.brevastudios.devto.ui.theme.DevToTheme
import com.brevastudios.devto.uilayer.screens.ArticleList
import dagger.hilt.android.AndroidEntryPoint

/**
 * The main activity of the application.
 */
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContent {
      DevToTheme {
        // A surface container using the 'background' color from the theme
        Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background) {
            /**
             * Represents a list of articles.
             */
            ArticleList()
        }
      }
    }
  }
}
