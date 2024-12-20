package com.example.routes

import com.example.model.Discussion
import com.example.service.DiscussionService
import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.request.receive
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get
import io.ktor.routing.post

fun Route.discussionRoutes() {
    val discussionService = DiscussionService()

    // Получить все обсуждения для статьи
    get("/articles/{articleId}/discussions") {
        val articleId = call.parameters["articleId"]?.toIntOrNull() ?: return@get call.respond(HttpStatusCode.BadRequest, "Invalid article ID")
        val discussions = discussionService.getDiscussionsForArticle(articleId)
        call.respond(HttpStatusCode.OK, discussions)
    }

    // Создать новое обсуждение
    post("/articles/{articleId}/discussions") {
        val articleId = call.parameters["articleId"]?.toIntOrNull() ?: return@post call.respond(HttpStatusCode.BadRequest, "Invalid article ID")
        val discussion = call.receive<Discussion>()
        discussionService.createDiscussion(discussion.copy(articleId = articleId))
        call.respond(HttpStatusCode.Created, discussion)
    }
}

