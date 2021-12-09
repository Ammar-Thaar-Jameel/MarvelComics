package com.example.marvelcomics.domain

import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.marvelcomics.data.remote.State
import com.example.marvelcomics.data.remote.response.CharactersDto
import com.example.marvelcomics.domain.models.Character
import com.example.marvelcomics.domain.models.CharacterSearchResult
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {


    suspend fun cachingCharactersInDataBase()

    fun transferDataFromEntityToCharacter(): Flow<List<Character>>

    suspend fun cachingSearchResult(characterName: String)

    fun getSearchResult(): Flow<List<CharacterSearchResult>>

    fun getCharacterDetailsById(characterId: Long): Flow<State<Character>>


    fun getCharacterByPaging(pagingConfig: PagingConfig): Flow<PagingData<CharactersDto>>
}