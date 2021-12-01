package com.example.marvelcomics.domain

import com.example.marvelcomics.data.remote.State
import com.example.marvelcomics.data.remote.response.CharactersDto
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {

        fun getCharacters():Flow<State<CharactersDto?>>

}