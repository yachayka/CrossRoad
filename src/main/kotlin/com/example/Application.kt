package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import io.ktor.server.routing.*
import io.ktor.server.response.respondText
import io.ktor.http.HttpStatusCode
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation
import io.ktor.serialization.kotlinx.json.json
import io.ktor.server.plugins.calllogging.CallLogging
import io.ktor.server.plugins.statuspages.StatusPages
import io.ktor.server.sessions.Sessions
import kotlinx.html.*
import kotlinx.html.stream.appendHTML

fun Application.module() {
    // Устанавливаем плагин для сериализации JSON
    install(ContentNegotiation) {
        json() // Для сериализации JSON
    }

    // Устанавливаем плагин для логирования
    install(CallLogging) {
        level = org.slf4j.event.Level.INFO // Логирование на уровне INFO
    }

    // Обработка ошибок с использованием StatusPages
    configureErrorHandling()

    // Устанавливаем плагин для работы с сессиями (если потребуется)
    install(Sessions) {
        // Конфигурация сессий, если будет нужно (например, для авторизации)
    }

    // Основной маршрут, который отдает главную страницу
    routing {
        // Главная страница
        route("/") {
            // Используем suspend для асинхронной работы
            get {
                // Вызываем suspend функцию для генерации HTML
                call.respondText(generateHtml(), contentType = io.ktor.http.ContentType.Text.Html, status = HttpStatusCode.OK)
            }
        }
    }
}

// Функция для генерации HTML-кода с использованием kotlinx.html
fun generateHtml(): String {
    return StringBuilder().apply {
        // Создание HTML страницы с помощью kotlinx.html
        appendHTML().html {
            head {
                title("Перекресток.doc - Обсуждения и статьи")
                meta(charset = "UTF-8")
                meta(name = "viewport", content = "width=device-width, initial-scale=1.0")

                // Вставка инлайнового CSS
                style {
                    +"""
                        body {
                            margin: 0;
                            font-family: Arial, sans-serif;
                            line-height: 1.6;
                        }
                        
                        .container {
                            max-width: 1200px;
                            padding: 0 20px;
                            margin: 0 auto;
                        }
                        
                        header {
                            background: #f8f8f8;
                            padding: 20px 0;
                        }
                        
                        .header-content {
                            display: flex;
                            justify-content: space-between;
                            align-items: center;
                        }
                        
                        .logo {
                            color: #285c85;
                            text-transform: uppercase;
                            font-weight: bold;
                        }
                        
                        .main-nav {
                            display: flex;
                            justify-content: space-around;
                        }
                        
                        .nav-item {
                            color: #333;
                            text-decoration: none;
                            padding: 10px 20px;
                            transition: color 0.3s ease;
                        }
                        
                        .nav-item:hover {
                            color: #007BFF;
                        }
                        
                        .login-btn:hover {
                            transform: translateY(-5px);
                            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
                        }
                        
                        .login-btn {
                            background-color: #285c85;
                            color: white;
                            border-radius: 5px;
                            padding: 10px 15px;
                            border: none;
                            border-radius: 25px;
                            font-size: 16px;
                            font-weight: bold;
                            cursor: pointer;
                            transition: all 0.3s ease;
                        }
                        
                        .hero {
                            background: #285c85;
                            color: white;
                            padding: 100px 0;
                            text-align: center;
                        }
                        
                        .features {
                            display: flex;
                            justify-content: space-around;
                            margin: 20px 0;
                        }
                        
                        .feature {
                            background: #f4f4f4;
                            padding: 20px;
                            flex: 1;
                            margin: 0 10px;
                            border-radius: 5px;
                            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
                            border: none;
                            text-align: center;
                            cursor: pointer;
                            transition: all 0.3s ease;
                        }
                        
                        .feature:hover {
                            transform: translateY(-5px);
                            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
                        }
                        
                        
                        .feature h3 {
                            color: #285c85;
                        }
                        
                        .articles {
                            padding: 40px 0;
                        }
                        
                        .article {
                            background-color: #fff;
                            border-radius: 8px;
                            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
                            margin-bottom: 20px;
                            padding: 20px;
                            transition: transform 0.3s, box-shadow 0.3s;
                        }
                        
                        .article:hover {
                            transform: translateY(-5px);
                            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
                        }
                        
                        .article h4 {
                            font-size: 1.5em;
                            margin-bottom: 10px;
                            color: #285c85;
                        }
                        
                        .article p {
                            font-size: 1em;
                            color: #555;
                        }
                        
                        footer {
                            background: #333;
                            color: white;
                            text-align: center;
                            padding: 10px 0;
                        }
                        
                        /* Общие стили для кнопок */
                        .btn {
                            padding: 12px 24px;
                            border: none;
                            border-radius: 25px;
                            font-size: 16px;
                            font-weight: bold;
                            cursor: pointer;
                            transition: all 0.3s ease;
                        
                        }
                        
                        .primary-btn {
                            background: #0088ff4e;
                            color: white;
                        }
                        
                        .primary-btn:hover {
                            transform: translateY(-5px);
                            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
                        }
                        
                        .secondary-btn {
                            background: linear-gradient(90deg, #6c757d, #5a6268);
                            color: white;
                        }
                        
                        .secondary-btn:hover {
                            transform: translateY(-5px);
                            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
                        }

                    """.trimIndent()
                }
            }
            body {
                header {
                    div(classes = "container header-content") {
                        h1(classes = "logo") {
                            +"Перекресток.doc"
                        }
                        nav(classes = "main-nav") {
                            a(href = "#", classes = "nav-item") { +"Главная" }
                            a(href = "#", classes = "nav-item") { +"Статьи" }
                            a(href = "#", classes = "nav-item") { +"Обсуждения" }
                            a(href = "#", classes = "nav-item") { +"Сообщество" }
                            a(href = "#", classes = "nav-item login-btn") { +"Вход" }
                        }
                    }
                }
                main(classes = "container") {
                    section(classes = "hero") {
                        h2 { +"Добро пожаловать на платформу Перекресток.doc!" }
                        p {
                            +"Здесь пользователи могут создавать обсуждения, задавать вопросы и публиковать статьи на интересующие их темы. "
                            +"Наша цель — создать активное сообщество, где каждый может выразить своё мнение и получить обратную связь."
                        }
                        button(classes = "btn primary-btn") {
                            +"Написать статью"
                        }
                        button(classes = "btn primary-btn") {
                            +"Начать обсуждение"
                        }
                    }
                    section(classes = "features") {
                        div(classes = "feature") {
                            h3 { +"Обсуждения" }
                            p { +"Начните новое обсуждение и делитесь своими мыслями с другими пользователями." }
                        }
                        div(classes = "feature") {
                            h3 { +"Вопросы" }
                            p { +"Задайте вопросы и получите ответы от опытных участников сообщества." }
                        }
                        div(classes = "feature") {
                            h3 { +"Статьи" }
                            p { +"Публикуйте статьи и делитесь своими знаниями с другими." }
                        }
                        div(classes = "feature") {
                            h3 { +"Сообщество" }
                            p { +"Присоединяйтесь к обсуждениям и станьте частью нашего активного сообщества." }
                        }
                    }
                    section(classes = "latest-articles") {
                        h2 { +"Интересные статьи" }
                        div(classes = "article") {
                            h4 { +"Как создать свой первый сайт" }
                            p { +"В этой статье мы рассмотрим основные шаги по созданию своего первого сайта с нуля." }
                        }
                        div(classes = "article") {
                            h4 { +"10 советов по программированию" }
                            p { +"Эти советы помогут вам стать более продуктивным разработчиком и улучшить свои навыки программирования." }
                        }
                    }
                }
                footer {
                    div(classes = "container") {
                        p { +"&copy; 2024 PKR-Groupe. Все права защищены." }
                    }
                }
            }
        }
    }.toString()
}

// Функция для обработки ошибок с использованием StatusPages
fun Application.configureErrorHandling() {
    install(StatusPages) {
        //exception<Throwable> { cause ->
        // Теперь используем `call` корректно в контексте приостановленной функции
        //call.respond(HttpStatusCode.InternalServerError, "Произошла ошибка: ${cause.localizedMessage}")
        //}
    }
}

fun main() {
    embeddedServer(Netty, port = 8080, module = Application::module).start(wait = true)
}