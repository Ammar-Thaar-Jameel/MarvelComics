package com.example.marvelcomics.model.network

import com.example.marvelcomics.utils.Constant.BASE_URL
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object API {
    private val client = OkHttpClient.Builder().addInterceptor(AuthInterceptor()).build()
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val apiService = retrofit.create(MarvelService::class.java)
}


