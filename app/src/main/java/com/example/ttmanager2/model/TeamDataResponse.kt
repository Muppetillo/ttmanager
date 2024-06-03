package com.example.ttmanager2.model

import com.example.ttmanager2.view.NewTeamActivity
import com.google.gson.annotations.SerializedName

data class TeamDataResponse(
    @SerializedName("response") val response: String,
    @SerializedName("data") val teams: List<TeamItemResponse>
)

data class TeamItemResponse (
    @SerializedName("faction") val faction: String,
    @SerializedName("ID")val id: Int,
    @SerializedName("name")val name: String,
    @SerializedName("faction_Id") val factionId: String,
    @SerializedName("rerolls")val rerolls: Int,
    @SerializedName("hasApothecary")val hasApothecary: Int,
    @SerializedName("teamValue")val teamValue: Int,
    @SerializedName("dedicatedFans")val dedicatedFans: Int,
    @SerializedName("cheerleaders")val cheerleaders: Int,
    @SerializedName("assistantCoaches")val assistanCoaches: Int,
    @SerializedName("treasury")val treasury: Int,
    @SerializedName("wins")val wins: Int,
    @SerializedName("draws")val draws: Int,
    @SerializedName("losses")val losses: Int,
)