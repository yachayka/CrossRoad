package com.example.repository

import com.example.model.User
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

class UserRepository {

    fun createUser(username: String, email: String, passwordHash: String): User {
        return transaction {
            val id = Users
                .insertAndGetId {
                    it[Users.username] = username
                    it[Users.email] = email
                    it[Users.passwordHash] = passwordHash
                }
            User(id.value, username, email, passwordHash)
        }
    }

    fun findByUsername(username: String): User? {
        return transaction {
            Users.select { Users.username eq username }
                .map {
                    User(it[Users.id].value, it[Users.username], it[Users.email], it[Users.passwordHash])
                }.singleOrNull()
        }
    }
}
