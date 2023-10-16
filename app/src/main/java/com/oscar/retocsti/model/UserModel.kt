package com.oscar.retocsti.model

import com.oscar.domain.model.User

data class UserModel(
    val id: Int,
    val email: String,
    val firstName: String,
    val lastName: String,
    val avatar: String,
)

fun User.toModel() =
    UserModel(id = id, email = email, firstName = firstName, lastName = lastName, avatar = avatar)

fun List<User>.toModel() = map { it.toModel() }
