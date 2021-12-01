package com.example.marvelcomics.domain

import com.example.marvelcomics.data.remote.State
import com.example.marvelcomics.data.remote.API
import com.example.marvelcomics.data.remote.response.CharactersDto
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class MarvelRepositoryImpl: MarvelRepository {

    override fun getCharacters(): Flow<State<CharactersDto?>> {
        return wrapWithFlow { API.apiService.getCharacters() }
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
                State.Success(result.body())

            } else {
                State.Error(result.message())
            }
        } catch (e: Exception) {
            State.Error(e.message.toString())
        }
}