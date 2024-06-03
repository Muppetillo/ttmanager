package com.example.ttmanager2.retrofit

import android.media.MediaDrm.PlaybackComponent
import com.example.ttmanager2.model.FactionDataResponse
import com.example.ttmanager2.model.PlayerDataResponse
import com.example.ttmanager2.model.PositionalDataResponse
import com.example.ttmanager2.model.TeamDataResponse
import com.example.ttmanager2.model.UserDataResponse
import retrofit2.Response
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface ApiService {
    @GET("getFactions.php")
    suspend fun getFactions(): Response<FactionDataResponse>

    @GET("getPositionalInfo.php")
    suspend fun getPositionalInfo(@Query("faction_Id") factionId: String): Response<PositionalDataResponse>

    @GET("getUserID.php")
    suspend fun getUserID(@Query("userName") userName: String,@Query("pwd") pwd: String,): Response<UserDataResponse>

    @FormUrlEncoded
    @POST("insertNewUser.php")
    suspend fun insertNewUser(
        @Field("name") name:String,
        @Field("pwd") pwd: String,
        @Field("email") email:String,
        ): Response <UserDataResponse>

    @GET("getUserName.php")
    suspend fun getUserName(@Query("ID") ID: Int): Response<UserDataResponse>

    @FormUrlEncoded
    @POST("insertNewTeam.php")
    suspend fun insertNewTeam(
        @Field("name")name: String,
        @Field("faction_Id")factionId: String,
        @Field("user_Id") userId: Int
    ): Response <TeamDataResponse>

    @GET("getTeam.php")
    suspend fun getTeamInfo (
        @Query("name")name: String,
        @Query("faction_Id")factionID: String,
        @Query("user_Id")userID: Int
    ): Response<TeamDataResponse>

    @GET("getTeamByID.php")
    suspend fun getTeamInfoByID (
        @Query("ID") id: Int,
    ): Response<TeamDataResponse>

    @GET("getTeamsByUserID.php")
    suspend fun getTeamsByUserID (
        @Query("user_Id") userID: Int,
    ): Response<TeamDataResponse>

    @GET ("getPlayersByTeamID.php")
    suspend fun getPlayersByTeamID (
        @Query("team_Id") team_Id: Int
    ): Response <PlayerDataResponse>

    @FormUrlEncoded
    @POST ("updateTeam.php")
    suspend fun updateTeam (
        @Field("ID")id: Int,
        @Field("value")value: Int,
    ): Response <TeamDataResponse>

    @FormUrlEncoded
    @POST("insertNewPlayer.php")
    suspend fun insertNewPlayer(
        @Field("name") name:String,
        @Field("team_Id") team_Id: Int,
        @Field("faction_Id") faction_Id:String,
    ): Response <PlayerDataResponse>

}