package com.example.service

import com.example.model.Discussion
import com.example.repository.DiscussionRepository

class DiscussionService {
    private val discussionRepository = DiscussionRepository()

    // Получить обсуждения для статьи
    fun getDiscussionsForArticle(articleId: Int): List<Discussion> {
        return discussionRepository.getDiscussionsByArticleId(articleId)
    }

    // Создать новое обсуждение
    fun createDiscussion(discussion: Discussion) {
        discussionRepository.saveDiscussion(discussion)
    }
}
