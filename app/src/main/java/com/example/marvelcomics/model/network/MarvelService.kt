package com.example.marvelcomics.model.network

import com.example.marvelcomics.model.response.BaseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelService {

    @GET("/characters")
    suspend fun getCharacters(): Response<BaseResponse>
}