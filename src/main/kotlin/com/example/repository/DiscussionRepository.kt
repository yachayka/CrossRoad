package com.example.repository

import com.example.model.Discussion
import com.example.database.DatabaseFactory.dbQuery
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class DiscussionRepository {

    // Получить все обсуждения для статьи
    fun getDiscussionsByArticleId(articleId: Int): List<Discussion> = dbQuery {
        Discussions.select { Discussions.articleId eq articleId }
            .map {
                Discussion(
                    id = it[Discussions.id],
                    articleId = it[Discussions.articleId],
                    userId = it[Discussions.userId],
                    content = it[Discussions.content]
                )
            }
    }

    // Сохранить обсуждение
    fun saveDiscussion(discussion: Discussion) = dbQuery {
        Discussions.insert {
            it[articleId] = discussion.articleId
            it[userId] = discussion.userId
            it[content] = discussion.content
        }
    }
}
