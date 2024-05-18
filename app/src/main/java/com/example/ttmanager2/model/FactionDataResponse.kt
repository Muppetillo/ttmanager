package com.example.ttmanager2.model

import com.example.ttmanager2.R
import com.google.gson.annotations.SerializedName


data class FactionDataResponse(
    @SerializedName("response") val response: String,
    @SerializedName("data") val factions: List<FactionItemResponse>
)

data class FactionItemResponse (
    @SerializedName("ID") val id: String,
    @SerializedName("name")val name: String,
    @SerializedName("reroll")val reroll: Int,
    @SerializedName("apothecary")val apothecary: Int,
    @SerializedName("tier") val tier: Int,
    @SerializedName("icon") val icon: String?,
)

