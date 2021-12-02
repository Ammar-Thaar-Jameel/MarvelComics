package com.example.marvelcomics.domain

import android.util.Log
import androidx.lifecycle.asLiveData
import com.example.marvelcomics.data.lacal.MarvelDataBase
import com.example.marvelcomics.data.remote.API
import com.example.marvelcomics.domain.mapper.CharacterEntityMapper
import com.example.marvelcomics.domain.mapper.CharacterMapper
import com.example.marvelcomics.domain.models.Character
import kotlinx.coroutines.flow.Flow

class MarvelRepositoryImpl : MarvelRepository {

    val charactersDao = MarvelDataBase.getInstance.marvelCharactersDao()
    val characterEntityMapper = CharacterEntityMapper()
    val charactersMapper = CharacterMapper()


//    override fun getCharacters(): Flow<List<CharactersEntity>> {
//        return charactersDao.getCharacters()
//    }


    override  fun getCharacterstoobject(): List<Character>? {

        val character = charactersDao.getCharacters().asLiveData().value?.map {

            charactersMapper.map(it)

        }
        return character
    }
    // return getCharacterstoobject()


//
//    override fun getAllCharacters() = wrapWithFlow { API.apiService.getAllCharacters() }
//    override fun getAllComics(text:String)=wrapWithFlow { API.apiService.getAllComics(text) }


    override suspend fun loadCharactersFromDataBase() {
        try {
            val response = API.apiService.getAllCharacters()
            Log.i("test",response.body()?.results.toString())
            val items = response.body()?.results?.map { charactersDto ->
                characterEntityMapper.map(charactersDto)

            }
            items?.let { charactersDao.addCharacters(it) }
        } catch (e: Exception) {
        }

    }


//    private fun <T> wrapWithFlow(function: suspend () -> Response<T>): Flow<State<T?>> =
//        flow {
//
//            emit(State.Loading)
//            emit(checkIfSuccessful(function()))
//        }.catch {
//            emit(State.Error(it.message.toString()))
//        }
//
//    private fun <T> checkIfSuccessful(result: Response<T>): State<T?> =
//        try {
//            if (result.isSuccessful) {
//                Log.v("result", result.body().toString())
//                State.Success(result.body())
//
//            } else {
//                Log.v("error", result.body().toString())
//                State.Error(result.message())
//            }
//        } catch (e: Exception) {
//            Log.v("e", e.toString())
//            State.Error(e.message.toString())
//        }
}