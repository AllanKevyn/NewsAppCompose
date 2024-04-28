package com.example.newsappcompose.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.paging.compose.LazyPagingItems
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.newsappcompose.R
import com.example.newsappcompose.domain.model.Article
import com.example.newsappcompose.util.Dimens.MediumPadding

@Composable
fun HomeScreen(
    article: LazyPagingItems<Article>,
    navigate: (String) -> Unit
) {

    val titles by remember {
        derivedStateOf {
            if (article.itemCount > 10) {
                article.itemSnapshotList.items.slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = " \uD83d\uDFE5 ") { it.title }
            } else {
                ""
            }
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = MediumPadding)
            .statusBarsPadding()
    ) {
        Image(
            painter = painterResource(id = R.drawable.news_icon),
            contentDescription = null,
            modifier = Modifier
                .width(150.dp)
                .height(30.dp)
                .padding(horizontal = MediumPadding)
        )
    }
    
    Spacer(modifier = Modifier.height(MediumPadding))
}