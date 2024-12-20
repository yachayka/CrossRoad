package com.example.routes

import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.post
import io.ktor.routing.get
import com.example.service.ArticleService
import com.example.model.Article

fun Route.articleRoutes() {
    val articleService = ArticleService()

    // Получение списка всех статей
    get("/articles") {
        val articles = articleService.getAllArticles()
        call.respond(HttpStatusCode.OK, articles)
    }

    // Создание новой статьи
    post("/articles") {
        val article = call.receive<Article>()
        articleService.createArticle(article)
        call.respond(HttpStatusCode.Created, article)
    }
}
