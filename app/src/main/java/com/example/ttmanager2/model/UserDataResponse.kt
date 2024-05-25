package com.example.ttmanager2.model

import com.google.gson.annotations.SerializedName

data class UserDataResponse(
    @SerializedName("response") val response: String,
    @SerializedName("data") val user: List<UserItemResponse>
)

data class UserItemResponse (
    @SerializedName("ID")val id: Int,
    @SerializedName("name")val name: String
    )