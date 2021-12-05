package com.example.marvelcomics.ui.search

import androidx.lifecycle.MutableLiveData
import com.example.marvelcomics.data.remote.State
import com.example.marvelcomics.data.remote.response.BaseResponse
import com.example.marvelcomics.data.remote.response.CharactersDto
import com.example.marvelcomics.data.remote.response.Data
import com.example.marvelcomics.domain.MarvelRepository
import com.example.marvelcomics.domain.MarvelRepositoryImpl
import com.example.marvelcomics.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: MarvelRepository
) : BaseViewModel(), SearchInteractionListener {



    var characterSearchResult = MutableLiveData<State<BaseResponse<Data<CharactersDto>>?>>()

    val characterName = MutableLiveData<String?>()


    fun searchForCharacter() {
        collectValue(
            repository.getCharactersByName(characterName.value.toString()),
            characterSearchResult
        )

    }
}
