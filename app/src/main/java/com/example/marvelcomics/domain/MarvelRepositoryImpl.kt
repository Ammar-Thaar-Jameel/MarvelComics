package com.example.marvelcomics.domain

import android.util.Log
import com.example.marvelcomics.data.lacal.MarvelDataBase
import com.example.marvelcomics.data.lacal.entity.CharactersEntity
import com.example.marvelcomics.data.remote.API
import com.example.marvelcomics.data.remote.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response

class MarvelRepositoryImpl : MarvelRepository {

    val charactersDao = MarvelDataBase.getInstance.marvelCharactersDao()

    override fun getCharacters(): Flow<List<CharactersEntity>> {
        return charactersDao.getCharacters()
    }

    override suspend fun loadCharactersFromDataBase() {
        try {

            val response = API.apiService.getCharacters()
            Log.i("ddd",response.body()?.results.toString())
            val items = response.body()?.results?.map {
                Log.i("www", it.name.toString())
                CharactersEntity(
                    id = it.id?.toLong() ?: 0L,
                    name = it.name ?: "",


                    )
            }
            items?.let { charactersDao.addCharacters(it) }
        } catch (e: Exception) {
        }

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