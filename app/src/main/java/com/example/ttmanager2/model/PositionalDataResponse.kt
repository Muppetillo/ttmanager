package com.example.ttmanager2.model

import com.google.gson.annotations.SerializedName


data class PositionalDataResponse(
    @SerializedName("response") val response: String,
    @SerializedName("data") val positionals: List<PositionalItemResponse>
)

data class PositionalItemResponse (
    @SerializedName("name")val name: String,
    @SerializedName("ma")val ma: Int,
    @SerializedName("st")val st: Int,
    @SerializedName("ag") val ag: Int,
    @SerializedName("pa") val pa: Int,
    @SerializedName("av") val av: Int,
    @SerializedName("skills")val skills: String,
    @SerializedName("price")val price: Int,
    @SerializedName("maxQty")val maxQty: Int,

)

