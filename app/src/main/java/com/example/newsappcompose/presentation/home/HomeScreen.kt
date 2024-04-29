package com.example.newsappcompose.presentation.home

import android.content.res.Configuration
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.remember
import androidx.paging.compose.LazyPagingItems
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.newsappcompose.R
import com.example.newsappcompose.domain.model.Article
import com.example.newsappcompose.presentation.common.ArticleCardShimmerEffect
import com.example.newsappcompose.presentation.common.ArticlesList
import com.example.newsappcompose.presentation.common.SearchBar
import com.example.newsappcompose.presentation.navgraph.Route
import com.example.newsappcompose.ui.theme.NewsAppComposeTheme
import com.example.newsappcompose.util.Dimens.MediumPadding

@OptIn(ExperimentalFoundationApi::class)
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

    SearchBar(
        modifier = Modifier
            .padding(horizontal = MediumPadding)
            .fillMaxWidth(),
        text = "Search",
        readOnly = true,
        onValueChange = {},
        onClick = { navigate(Route.SearchScreen.route) },
        onSearch = {}
    )

    Spacer(modifier = Modifier.height(MediumPadding))

    Text(
        text = titles,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = MediumPadding)
            .basicMarquee(),
        fontSize = 12.sp,
        color = Color.Gray
    )

    Spacer(modifier = Modifier.height(MediumPadding))

    ArticlesList(
        modifier = Modifier.padding(horizontal = MediumPadding),
        articles = article,
        onClick = {
            navigate(Route.DetailsScreen.route)
        }
    )
}
