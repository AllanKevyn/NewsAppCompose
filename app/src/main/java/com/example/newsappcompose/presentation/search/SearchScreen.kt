package com.example.newsappcompose.presentation.search

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.paging.compose.collectAsLazyPagingItems
import com.example.newsappcompose.domain.model.SearchState
import com.example.newsappcompose.presentation.common.ArticlesList
import com.example.newsappcompose.presentation.common.SearchBar
import com.example.newsappcompose.presentation.navgraph.Route
import com.example.newsappcompose.util.Dimens.MediumPadding

@Composable
fun SearchScreen(
    searchState: SearchState,
    event: (SearchEvent) -> Unit,
    navigate: (String) -> Unit
) {

    Column(
        modifier = Modifier
            .padding(top = MediumPadding, start = MediumPadding, end = MediumPadding)
            .statusBarsPadding()
            .fillMaxSize()
    ) {

        SearchBar(
            text = searchState.searchQuery,
            readOnly = false,
            onValueChange = { event(SearchEvent.UpdateSearchQuery(it)) },
            onSearch = { event(SearchEvent.SearchNews) }
        )

        Spacer(modifier = Modifier.height(MediumPadding))

        searchState.article?.let {
            val articles = it.collectAsLazyPagingItems()
            ArticlesList(articles = articles, onClick = { navigate(Route.DetailsScreen.route) })
        }
    }
}