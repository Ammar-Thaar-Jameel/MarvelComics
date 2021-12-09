package com.example.marvelcomics.data.remote

import com.example.marvelcomics.data.remote.response.BaseResponse
import com.example.marvelcomics.data.remote.response.CharactersDto
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MarvelService {


    @GET("characters")
    suspend fun getAllCharacters(): Response<BaseResponse<CharactersDto>>

    @GET("characters")
    suspend fun getCharactersByName(
        @Query("nameStartsWith") characterName: String,
    ): Response<BaseResponse<CharactersDto>>

    @GET("characters/{characterId}")
    suspend fun getCharactersById(
        @Path("characterId") characterId: Long,
    ): Response<BaseResponse<CharactersDto>>

    @GET("characters")
    suspend fun getAllCharactersByPaging(
        @Query("limit") limit: Int,
    ): Response<BaseResponse<CharactersDto>>


}