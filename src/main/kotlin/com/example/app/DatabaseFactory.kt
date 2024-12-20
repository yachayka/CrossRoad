package com.example.app

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import io.ktor.application.Application
import io.ktor.features.ContentNegotiation
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty

// Определение объектов таблиц
object Users : Table() {
    val id = integer("id").autoIncrement().primaryKey()
    val username = varchar("username", 100).uniqueIndex()
    val email = varchar("email", 255).uniqueIndex()
    val passwordHash = varchar("password_hash", 255)
    val createdAt = datetime("created_at")
}

// Прочие таблицы: Articles, Discussions, Comments аналогичны

fun initDatabase() {
    val hikariConfig = HikariConfig().apply {
        jdbcUrl = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1"
        driverClassName = "org.h2.Driver"
        username = "root"
        password = "password"
    }
    val dataSource = HikariDataSource(hikariConfig)

    Database.connect(dataSource)

    transaction {
        SchemaUtils.create(Users, Articles, Discussions, Comments) // Создаем таблицы
    }
}

fun Application.module() {
    install(ContentNegotiation) {
        // Устанавливаем сериализацию JSON
    }

    initDatabase()  // Инициализация базы данных

    // Пример маршрутов
    routing {
        get("/") {
            call.respondText("Hello, world!")
        }
    }
}
