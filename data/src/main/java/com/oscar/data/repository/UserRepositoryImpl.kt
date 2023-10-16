package com.oscar.data.repository

import com.oscar.data.UserService
import com.oscar.data.request.UserRequest
import com.oscar.data.response.toDomain
import com.oscar.domain.model.User
import com.oscar.domain.model.UserToken
import com.oscar.domain.repository.UserRepository
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val userService: UserService) :
    UserRepository {
    override suspend fun getUsersByPage(): List<User> {
        return userService.getUsersByPage().data.map { it.toDomain() }
    }

    override suspend fun login(email: String, password: String): UserToken {
        return userService.loginUser(request = UserRequest(email = email, password = password))
            .toDomain()
    }

    override suspend fun register(email: String, password: String): UserToken {
        return userService.registerUser(
            request = UserRequest(
                email = email,
                password = password,
            ),
        ).toDomain()
    }
}
