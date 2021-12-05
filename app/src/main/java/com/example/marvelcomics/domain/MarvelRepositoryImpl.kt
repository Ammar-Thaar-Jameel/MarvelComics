package com.example.marvelcomics.domain

import android.util.Log
import com.example.marvelcomics.data.lacal.MarvelDataBase
import com.example.marvelcomics.data.remote.MarvelService
import com.example.marvelcomics.data.remote.State
import com.example.marvelcomics.data.remote.response.BaseResponse
import com.example.marvelcomics.data.remote.response.CharactersDto
import com.example.marvelcomics.data.remote.response.Data
import com.example.marvelcomics.domain.mapper.CharacterDtoToEntity
import com.example.marvelcomics.domain.mapper.CharacterEntityToCharacter
import com.example.marvelcomics.domain.models.Character
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    private val apiService: MarvelService,
    private val characterDtoToEntity: CharacterDtoToEntity,
    private val characterEntityToCharacter: CharacterEntityToCharacter,
    private val marvelDataBase: MarvelDataBase

) : MarvelRepository {




    override fun getCharactersByName(characterName: String): Flow<State<BaseResponse<Data<CharactersDto>>?>> {
        return wrapWithFlow { apiService.getCharactersByName(characterName) }
    }

    override suspend fun cachingCharactersInDataBase() {
        try {
            val response = apiService.getAllCharacters()

            val items = response.body()?.data?.results?.map { charactersDto ->
                characterDtoToEntity.map(charactersDto)

            }
            items?.let { marvelDataBase.marvelCharactersDao().addCharacters(it) }
        } catch (e: Exception) {
        }
    }


    override suspend fun transferDataFromEntityToCharacter(): List<Character> {
        return marvelDataBase.marvelCharactersDao().getCharacters().map {
            characterEntityToCharacter.map(it)
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