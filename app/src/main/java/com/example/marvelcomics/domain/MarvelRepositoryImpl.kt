package com.example.marvelcomics.domain

import android.util.Log
import com.example.marvelcomics.data.lacal.MarvelDataBase
import com.example.marvelcomics.data.remote.MarvelService
import com.example.marvelcomics.data.remote.State
import com.example.marvelcomics.domain.mapper.BaseMapper
import com.example.marvelcomics.domain.models.Character
import com.example.marvelcomics.domain.models.CharacterSearchResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import retrofit2.Response
import javax.inject.Inject

class MarvelRepositoryImpl @Inject constructor(
    private val apiService: MarvelService,
    private val marvelDataBase: MarvelDataBase,
    private val baseMapper: BaseMapper

) : MarvelRepository {


//    override fun getCharactersByName(characterName: String): Flow<State<BaseResponse<Data<CharactersDto>>?>> {
//        return wrapWithFlow { apiService.getCharactersByName(characterName) }
//    }

    override suspend fun cachingCharactersInDataBase() {
        try {
            val response = apiService.getAllCharacters()

            val items = response.body()?.data?.results?.map { charactersDto ->
                baseMapper.mapCharacterDtoToEntity(charactersDto)

            }
            items?.let { marvelDataBase.marvelCharactersDao().addCharacters(it) }
        } catch (e: Exception) {
        }
    }


    override suspend fun transferDataFromEntityToCharacter(): List<Character> {
        return marvelDataBase.marvelCharactersDao().getCharacters().map { charactersEntity ->
            baseMapper.mapCharacterEntityToCharacterDomain(charactersEntity)
        }
    }

    override suspend fun cachingSearchResult(characterName: String) {
        try {
            val response = apiService.getCharactersByName(characterName = characterName)

            val items = response.body()?.data?.results?.map { charactersSearchDto ->
                baseMapper.mapCharacterDtoSearchToEntity(charactersSearchDto)

            }
            items?.let { marvelDataBase.marvelCharactersDao().addSearchResult(it) }
        } catch (e: Exception) {
        }
    }

    override suspend fun getSearchResult(): List<CharacterSearchResult> {
        return marvelDataBase.marvelCharactersDao().getSearchResult()
            .map { charactersSearchEntity ->
                baseMapper.mapCharacterSearchEntityToCharacterDomain(charactersSearchEntity)
            }
    }

    override fun getCharacterDetailsById(characterId: Long): Flow<State<Character>> {
        return flow {
            emit(State.Loading)
            try {
                val result = apiService.getCharactersById(characterId)
                    .body()?.data?.results?.map { characterList ->
                        baseMapper.mapCharacterDtoToCharacterDomain(characterList)

                    }
                result?.let { State.Success(it[0]) }?.let { emit(it) }

            } catch (e: Exception) {

            }
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