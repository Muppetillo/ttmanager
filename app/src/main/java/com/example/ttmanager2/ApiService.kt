package com.example.ttmanager2

import com.example.ttmanager2.model.FactionDataResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("getFactions.php")
    suspend fun getFactions(): Response<FactionDataResponse>
}