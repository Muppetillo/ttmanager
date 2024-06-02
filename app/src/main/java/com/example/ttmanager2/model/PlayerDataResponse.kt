package com.example.ttmanager2.model

import com.google.gson.annotations.SerializedName

data class PlayerDataResponse (
    @SerializedName("response") val response: String,
    @SerializedName("data") val positionals: List<PlayerItemResponse>
)

data class PlayerItemResponse (
    @SerializedName("number") val number: Int,
    @SerializedName("name")val name: String,
    @SerializedName("positional") val positional: String,
    @SerializedName("ma")val ma: Int,
    @SerializedName("st")val st: Int,
    @SerializedName("ag") val ag: Int,
    @SerializedName("pa") val pa: Int,
    @SerializedName("av") val av: Int,
    @SerializedName("skills")val skills: String,
    @SerializedName("mng") val mng: Boolean,
    @SerializedName("spp") val spp: Int,
    @SerializedName("td")val td: Int,
    @SerializedName("cas")val cas: Int,
    @SerializedName("com") val com: Int,
    @SerializedName("int") val int: Int,
    @SerializedName("mvp") val mvp: Int,
    @SerializedName("value")val value: Int,

    )
