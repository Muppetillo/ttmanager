package com.example.ttmanager2.retrofit

import com.example.ttmanager2.model.FactionDataResponse
import com.example.ttmanager2.model.PositionalDataResponse
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



}