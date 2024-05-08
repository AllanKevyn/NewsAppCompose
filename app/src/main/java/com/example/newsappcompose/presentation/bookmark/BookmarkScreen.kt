package com.example.newsappcompose.presentation.bookmark

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import com.example.newsappcompose.domain.model.BookMarkState
import com.example.newsappcompose.presentation.common.ArticlesList
import com.example.newsappcompose.presentation.navgraph.Route
import com.example.newsappcompose.util.Dimens.MediumPadding

@Composable
fun BookMarkScreen(
    state: BookMarkState,
    navigate: (String) -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .statusBarsPadding()
            .padding(top = MediumPadding, start = MediumPadding, end = MediumPadding)
    ) {

        Text(
            text = "Bookmark",
            style = MaterialTheme.typography.displayMedium.copy(fontWeight = FontWeight.Bold),
            color = Color.Black
        )

        Spacer(modifier = Modifier.height(MediumPadding))
        
        ArticlesList(articles = state.articles, onClick = { navigate(Route.DetailsScreen.route) })
    }
}