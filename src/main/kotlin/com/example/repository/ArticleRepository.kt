package com.example.repository

import com.example.model.Article
import com.example.database.DatabaseFactory.dbQuery
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class ArticleRepository {

    // Пример использования ORM библиотеки Exposed
    fun getAllArticles(): List<Article> = dbQuery {
        Articles.selectAll().map {
            Article(
                id = it[Articles.id],
                title = it[Articles.title],
                content = it[Articles.content]
            )
        }
    }

    fun saveArticle(article: Article) = dbQuery {
        Articles.insert {
            it[title] = article.title
            it[content] = article.content
        }
    }
}
