package com.example.marvelcomics.domain

import com.example.marvelcomics.data.lacal.entity.CharactersEntity
import com.example.marvelcomics.data.remote.State
import com.example.marvelcomics.data.remote.response.BaseResponse
import com.example.marvelcomics.data.remote.response.Data
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {

        fun getCharacters():Flow<List<CharactersEntity?>>

        fun getAllCharacters():Flow<State<BaseResponse?>>
        fun getAllComics(text:String):Flow<State<Data?>>

        suspend fun loadCharactersFromDataBase()
}