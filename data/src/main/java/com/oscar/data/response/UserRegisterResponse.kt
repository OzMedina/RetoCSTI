package com.oscar.data.response

import com.oscar.domain.model.UserToken

data class UserRegisterResponse(val id: Int, val token: String)

fun UserRegisterResponse.toDomain() =
    UserToken(id = id, token = token)
