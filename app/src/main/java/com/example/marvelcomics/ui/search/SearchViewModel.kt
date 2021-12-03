package com.example.marvelcomics.ui.search

import androidx.lifecycle.MutableLiveData
import com.example.marvelcomics.data.remote.State
import com.example.marvelcomics.data.remote.response.BaseResponse
import com.example.marvelcomics.data.remote.response.CharactersDto
import com.example.marvelcomics.data.remote.response.Data
import com.example.marvelcomics.domain.MarvelRepository
import com.example.marvelcomics.domain.MarvelRepositoryImpl
import com.example.marvelcomics.ui.base.BaseViewModel

class SearchViewModel : BaseViewModel(),SearchInteractionListener {

    private val repository: MarvelRepository = MarvelRepositoryImpl()

    var characterSearchResult = MutableLiveData<State<BaseResponse<Data<CharactersDto>>?>>()

    val characterName = MutableLiveData<String?>()


    fun searchForCharacter() {
        collectValue(
            repository.getCharactersByName(characterName.value.toString()),
            characterSearchResult
        )

    }
}
