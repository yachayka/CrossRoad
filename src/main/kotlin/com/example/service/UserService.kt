package com.example.service

import com.example.repository.UserRepository
import com.example.model.User

class UserService(private val userRepository: UserRepository) {

    fun registerUser(username: String, email: String, passwordHash: String): User {
        return userRepository.createUser(username, email, passwordHash)
    }

    fun authenticateUser(username: String, passwordHash: String): User? {
        val user = userRepository.findByUsername(username)
        return if (user != null && user.passwordHash == passwordHash) {
            user
        } else null
    }
}
