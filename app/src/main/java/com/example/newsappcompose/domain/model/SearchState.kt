package com.example.newsappcompose.domain.model

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val article: Flow<PagingData<Article>>? = null
)
