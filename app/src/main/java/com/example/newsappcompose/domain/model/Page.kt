package com.example.newsappcompose.domain.model

import androidx.annotation.DrawableRes
import com.example.newsappcompose.R

data class Page(
    val title: String,
    val description: String,
    @DrawableRes val image: Int
)

val pages = listOf(
    Page(
        "Meu título 1",
        "descrição da notícia numero 1",
        R.drawable.ic_launcher_background
    ),
    Page(
        "Meu título 2",
        "descrição da notícia numero 2",
        R.drawable.ic_launcher_background
    ),
    Page(
        "Meu título 3",
        "descrição da notícia numero 3",
        R.drawable.ic_launcher_background
    )
)
