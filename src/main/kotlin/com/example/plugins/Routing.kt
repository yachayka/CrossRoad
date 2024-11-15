package com.example.plugins

import io.ktor.server.application.*
import io.ktor.server.http.content.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.thymeleaf.*
import org.thymeleaf.templateresolver.ClassLoaderTemplateResolver

fun Application.configureRouting() {
    routing {
        // Отдача статических файлов из папки resources/static
        static("/static") {
            resources("static")
        }
        // Главная страница - выводим HTML файл
        get("/") {
            call.respond(ThymeleafContent("index", emptyMap()))
        }
        // Пример маршрута для отображения HTML файла
        get("/example") {
            call.respond(ThymeleafContent("example", emptyMap()))
        }
    }
}



