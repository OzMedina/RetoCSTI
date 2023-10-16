package com.oscar.data.response

import com.google.gson.annotations.SerializedName
import com.oscar.domain.model.User

data class UserResponse(
    @SerializedName("data")
    val `data`: List<DataResponse>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("per_page")
    val perPage: Int,
    @SerializedName("support")
    val support: SupportResponse,
    @SerializedName("total")
    val total: Int,
    @SerializedName("total_pages")
    val totalPages: Int,
)

data class SupportResponse(
    @SerializedName("text")
    val text: String,
    @SerializedName("url")
    val url: String,
)

data class DataResponse(
    @SerializedName("avatar")
    val avatar: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("last_name")
    val lastName: String,
)

fun DataResponse.toDomain() =
    User(id = id, email = email, firstName = firstName, lastName = lastName, avatar = avatar)
