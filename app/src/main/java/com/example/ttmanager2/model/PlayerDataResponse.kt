package com.example.ttmanager2.model

import com.google.gson.annotations.SerializedName

data class PlayerDataResponse (
    @SerializedName("response") val response: String,
    @SerializedName("data") val players: List<PlayerItemResponse>
)

data class PlayerItemResponse (
    @SerializedName("name")val name: String,
    @SerializedName("number") val number: Int,
    @SerializedName("MA")val ma: Int,
    @SerializedName("ST")val st: Int,
    @SerializedName("AG") val ag: Int,
    @SerializedName("PA") val pa: Int,
    @SerializedName("AV") val av: Int,
    @SerializedName("VALUE")val value: Int,
    @SerializedName("Skills")val skills: String,
    @SerializedName("MNG") val mng: Boolean,
    @SerializedName("SPP") val spp: Int,
    @SerializedName("TD")val td: Int,
    @SerializedName("CAS")val cas: Int,
    @SerializedName("COM") val com: Int,
    @SerializedName("INTF") val int: Int,
    @SerializedName("mvp") val mvp: Int,
    @SerializedName("team_Id") val team_Id: Int,
    @SerializedName("positional") val positional: String,
    )
