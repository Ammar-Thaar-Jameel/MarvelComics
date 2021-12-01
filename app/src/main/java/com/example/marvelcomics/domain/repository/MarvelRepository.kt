package com.example.marvelcomics.domain.repository

import com.example.marvelcomics.model.State
import com.example.marvelcomics.model.response.CharactersDto
import kotlinx.coroutines.flow.Flow

interface MarvelRepository {

        fun getCharacters():Flow<State<CharactersDto?>>

}