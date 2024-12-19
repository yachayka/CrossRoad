
val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "2.0.21" // Используем актуальную версию Kotlin
    id("io.ktor.plugin") version "3.0.0" // Плагин для Ktor
    id("org.jetbrains.dokka") version "1.8.10" // Для генерации документации
}

group = "com.example"
version = "0.0.1"

application {
    mainClass.set("io.ktor.server.netty.EngineMain") // Основной класс для запуска приложения
    val isDevelopment: Boolean = project.ext.has("development")
    applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

repositories {
    mavenCentral() // Подключаем центральный репозиторий Maven
}

dependencies {
    // Основные зависимости для Ktor
    implementation("io.ktor:ktor-server-core-jvm:2.3.0") // Основной серверный модуль
    implementation("io.ktor:ktor-server-netty-jvm:2.3.0") // Сервер с поддержкой Netty
    implementation("io.ktor:ktor-server-html-builder:2.3.0") // Для работы с HTML-шаблонами
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.0") // Сериализация JSON
    implementation("io.ktor:ktor-server-content-negotiation:2.3.0") // Для Content Negotiation

    // Логирование
    implementation("io.ktor:ktor-server-call-logging:2.3.0") // Логирование запросов

    // Для обработки ошибок
    implementation("io.ktor:ktor-server-status-pages:2.3.0") // Статусы ошибок

    // Для сессий
    implementation("io.ktor:ktor-server-sessions:2.3.0") // Поддержка сессий

    // Для тестирования
    testImplementation("io.ktor:ktor-server-test-host-jvm:2.3.0") // Для тестирования сервера
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version") // Для работы с тестами через JUnit

    // Логирование (logback)
    implementation("ch.qos.logback:logback-classic:$logback_version") // Логирование с помощью Logback
    // Для работы с HTML-шаблонами
    implementation("io.ktor:ktor-server-html-builder:2.3.0")
}











