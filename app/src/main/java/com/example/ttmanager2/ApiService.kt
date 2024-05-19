package com.example.ttmanager2

import com.example.ttmanager2.model.FactionDataResponse
import com.example.ttmanager2.model.PositionalDataResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("getFactions.php")
    suspend fun getFactions(): Response<FactionDataResponse>

    @GET("getPositionalInfo.php")
    suspend fun getPositionalInfo(@Query("faction_Id") factionId: String): Response<PositionalDataResponse>
}