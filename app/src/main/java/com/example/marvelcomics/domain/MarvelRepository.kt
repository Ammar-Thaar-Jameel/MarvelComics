package com.example.marvelcomics.domain

import com.example.marvelcomics.data.remote.State
import com.example.marvelcomics.domain.models.Character
import com.example.marvelcomics.domain.models.CharacterSearchResult
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {


    suspend fun cachingCharactersInDataBase()

    suspend fun transferDataFromEntityToCharacter(): List<Character>

    suspend fun cachingSearchResult(characterName: String)

    fun getSearchResult(): Flow<List<CharacterSearchResult>>

    fun getCharacterDetailsById(characterId: Long): Flow<State<Character>>
}