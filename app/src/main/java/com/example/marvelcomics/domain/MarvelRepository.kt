package com.example.marvelcomics.domain

import com.example.marvelcomics.data.lacal.entity.CharactersEntity
import com.example.marvelcomics.data.remote.State
import com.example.marvelcomics.data.remote.response.CharactersDto
import com.example.marvelcomics.data.remote.response.Data
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {

        fun getCharacters():Flow<List<CharactersEntity?>>


        suspend fun loadCharactersFromDataBase()
}