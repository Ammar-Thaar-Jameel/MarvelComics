package com.example.marvelcomics.data.remote

import com.example.marvelcomics.data.remote.response.BaseResponse
import com.example.marvelcomics.data.remote.response.CharactersDto
import com.example.marvelcomics.data.remote.response.Data
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MarvelService {

//    @GET("/characters")
//    suspend fun getCharacters(
////        @Query("ts") ts: String = "12345678",
////        @Query("apikey") apiKey: String = Constant.PUBLIC_API_KEY,
////        @Query("hash") hash: String = "c05fa4d2443d606ac15bdbdbc603d3b0"
//    ): Response<Data>
//
//    @GET("characters")
//    suspend fun getAllCharacters(): Response<BaseResponse>

    @GET("characters")
    suspend fun getAllCharacters(): Response<BaseResponse<CharactersDto>>

//    @GET("characters")
//    suspend fun getAllComics(
//        @Query("name") text: String,
//    ): Response<Data>
}