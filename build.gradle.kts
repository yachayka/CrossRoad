plugins {
    // Apply the Kotlin plugin
    kotlin("jvm") version "1.8.0" // Ensure you're using the correct Kotlin version

    // Apply the application plugin for JVM-based applications
    application
}

repositories {
    mavenCentral() // Standard repository
    gradlePluginPortal() // Ensure access to Gradle plugins
}

dependencies {
    // Ktor server core dependencies
    implementation("io.ktor:ktor-server-core:2.3.0") // Ktor core
    implementation("io.ktor:ktor-server-netty:2.3.0") // Netty engine (you can replace it with another engine if needed)

    // Kotlin standard library
    implementation(kotlin("stdlib"))

    // For JSON handling, you'll need serialization (optional, based on your needs)
    implementation("io.ktor:ktor-serialization-kotlinx-json:2.3.0")

    // Database dependencies (ex. Exposed for SQL or H2 for a simple DB, adjust as needed)
    implementation("org.jetbrains.exposed:exposed-core:0.40.0")
    implementation("org.jetbrains.exposed:exposed-dao:0.40.0")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.40.0")

    // For database connection pooling (optional)
    implementation("org.apache.commons:commons-dbcp2:2.9.0")

    // For testing dependencies
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:1.8.0") // Use Kotlin's test library
    testImplementation("io.ktor:ktor-server-tests:2.3.0") // Ktor testing utilities
}

tasks.withType<Test> {
    useJUnitPlatform() // Make sure to use JUnit 5
}

application {
    mainClass.set("io.ktor.server.netty.EngineMain") // Main entry for Ktor applications using Netty
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(17)) // Ensure you're using a compatible Java version (17 or later for Ktor 2.x)
    }
}

