package com.oscar.domain.repository

import com.oscar.domain.model.User
import com.oscar.domain.model.UserToken

interface UserRepository {
    suspend fun getUsersByPage(): List<User>
    suspend fun login(email: String, password: String): UserToken
    suspend fun register(email: String, password: String): UserToken
}
