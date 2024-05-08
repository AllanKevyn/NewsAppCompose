package com.example.newsappcompose.domain.usecase.news

import com.example.newsappcompose.data.local.NewsDao
import com.example.newsappcompose.domain.model.Article

class DeleteArticle(
    private val newsDao: NewsDao
) {

    suspend operator fun invoke(article: Article) {
        newsDao.delete(article)
    }
}