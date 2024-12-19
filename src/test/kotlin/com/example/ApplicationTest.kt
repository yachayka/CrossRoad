package com.example

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import io.ktor.utils.io.*
import kotlin.test.*

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        application {
            configureRouting()
        }
        client.get("/").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello World!", bodyAsText())
        }
    }

    @Test
    fun testGetSomeResource() = testApplication {
        application {
            configureRouting()
        }
        client.get("/some-resource").apply {
            assertEquals(HttpStatusCode.OK, status)
            // Предположим, что вы ожидаете какой-то конкретный ответ для этого ресурса
            assertEquals("Expected Resource Response", bodyAsText())
        }
    }

    @OptIn(InternalAPI::class)
    @Test
    fun testPostResource() = testApplication {
        application {
            configureRouting()
        }
        client.post("/create-resource") {
            contentType(ContentType.Application.Json)
            body = """{"name": "New Resource"}"""
        }.apply {
            assertEquals(HttpStatusCode.Created, status)
            assertEquals("Resource created", bodyAsText())
        }
    }

    private fun configureRouting() {
        TODO("Not yet implemented")
    }

    @OptIn(InternalAPI::class)
    @Test
    fun testPutResource() = testApplication {
        application {
            configureRouting()
        }
        client.put("/update-resource/1") {
            contentType(ContentType.Application.Json)
            body = """{"name": "Updated Resource"}"""
        }.apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Resource updated", bodyAsText())
        }
    }

    @Test
    fun testDeleteResource() = testApplication {
        application {
            configureRouting()
        }
        client.delete("/delete-resource/1").apply {
            assertEquals(HttpStatusCode.NoContent, status)
        }
    }

}
