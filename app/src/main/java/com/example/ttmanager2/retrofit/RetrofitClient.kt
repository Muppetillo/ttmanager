package com.example.ttmanager2.retrofit

import retrofit2.Retrofit
import com.example.ttmanager2.Constants.CPIFP_URL
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    val retrofitClient = Retrofit
    .Builder()
    .baseUrl(CPIFP_URL)
    .addConverterFactory(GsonConverterFactory.create())
    .build()

    val apiCall = retrofitClient.create(ApiService::class.java)
}