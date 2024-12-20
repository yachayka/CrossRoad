package com.example.model

data class Comment(
    val id: Int,
    val articleId: Int,
    val userId: Int,
    val content: String
)
