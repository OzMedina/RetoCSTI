package com.oscar.data.response

import com.oscar.domain.model.UserToken

data class UserLoginResponse(val token: String)

fun UserLoginResponse.toDomain() =
    UserToken(id = 0, token = token)
