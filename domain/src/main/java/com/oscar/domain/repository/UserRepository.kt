package com.oscar.domain.repository

import com.oscar.domain.model.User

interface UserRepository {
    suspend fun getUsersByPage(): List<User>
    suspend fun login(email: String, password: String): String
    suspend fun register(email: String, password: String): String
}
