package com.example.marvelcomics.domain

import com.example.marvelcomics.data.remote.State
import com.example.marvelcomics.data.remote.response.BaseResponse
import com.example.marvelcomics.data.remote.response.CharactersDto
import com.example.marvelcomics.data.remote.response.Data
import com.example.marvelcomics.domain.models.Character
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {



    fun getCharactersByName(characterName: String): Flow<State<BaseResponse<Data<CharactersDto>>?>>


    suspend fun cachingCharactersInDataBase()

    suspend fun transferDataFromEntityToCharacter(): List<Character>


}