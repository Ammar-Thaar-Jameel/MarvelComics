package com.example.marvelcomics.model.network

import com.example.marvelcomics.model.response.CharactersDto
import retrofit2.Response
import retrofit2.http.GET

interface MarvelService {

    @GET("/characters")
    suspend fun getCharacters(
//        @Query("ts") ts: String = "12345678",
//        @Query("apikey") apiKey: String = Constant.PUBLIC_API_KEY,
//        @Query("hash") hash: String = "c05fa4d2443d606ac15bdbdbc603d3b0"
    ): Response<CharactersDto>

}