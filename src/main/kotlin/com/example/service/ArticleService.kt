package com.example.service

import com.example.model.Article
import com.example.repository.ArticleRepository

class ArticleService {
    private val articleRepository = ArticleRepository()

    fun getAllArticles(): List<Article> = articleRepository.getAllArticles()

    fun createArticle(article: Article) {
        articleRepository.saveArticle(article)
    }
}
