package com.example.marvelcomics.domain

import android.util.Log
import com.example.marvelcomics.data.lacal.MarvelDataBase
import com.example.marvelcomics.data.remote.API
import com.example.marvelcomics.data.remote.State
import com.example.marvelcomics.data.remote.response.BaseResponse
import com.example.marvelcomics.data.remote.response.CharactersDto
import com.example.marvelcomics.data.remote.response.Data
import com.example.marvelcomics.domain.mapper.CharacterMapper
import com.example.marvelcomics.domain.models.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class MarvelRepositoryImpl : MarvelRepository {

    val charactersDao = MarvelDataBase.getInstance.marvelCharactersDao()
    val charactersMapper = CharacterMapper()

    override fun getCharacters(): Flow<State<List<Character>?>> {
        return flow {
            emit(State.Loading)
            try {
                val character =
                    API.apiService.getAllCharacters().body()?.data?.results?.map { charactersDto ->

                        charactersMapper.map(charactersDto)
                    }
                emit(State.Success(character))
            } catch (error: Throwable) {
                emit(State.Error(error.toString()))
            }
        }
    }




    override fun getCharactersByName(characterName:String): Flow<State<BaseResponse<Data<CharactersDto>>?>> {
       return wrapWithFlow { API.apiService.getCharactersByName(characterName) }
    }




    private fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<State<T?>> =
        flow {

            emit(State.Loading)
            emit(checkIfSuccessful(function()))
        }.catch {
            emit(State.Error(it.message.toString()))
        }

    private fun <T> checkIfSuccessful(result: Response<T>): State<T?> =
        try {
            if (result.isSuccessful) {
                Log.v("result", result.body().toString())
                State.Success(result.body())

            } else {
                Log.v("error", result.body().toString())
                State.Error(result.message())
            }
        } catch (e: Exception) {
            Log.v("e", e.toString())
            State.Error(e.message.toString())
        }
}