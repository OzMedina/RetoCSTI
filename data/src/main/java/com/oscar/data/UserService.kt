package com.oscar.data

import com.oscar.data.request.UserRequest
import com.oscar.data.response.UserLoginResponse
import com.oscar.data.response.UserRegisterResponse
import com.oscar.data.response.UserResponse
import retrofit2.http.GET
import retrofit2.http.POST

interface UserService {
    @GET("users")
    suspend fun getUsersByPage(): UserResponse

    @POST("register")
    suspend fun registerUser(request: UserRequest): UserRegisterResponse

    @POST("login")
    suspend fun loginUser(request: UserRequest): UserLoginResponse
}
