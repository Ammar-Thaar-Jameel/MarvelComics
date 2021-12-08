package com.example.marvelcomics.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvelcomics.data.remote.State
import com.example.marvelcomics.domain.MarvelRepository
import com.example.marvelcomics.domain.models.CharacterSearchResult
import com.example.marvelcomics.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: MarvelRepository
) : BaseViewModel(), SearchInteractionListener {





    val characterSearchResult: LiveData<State<List<CharacterSearchResult>>> =
        repository.getSearchResult().asLiveData()

    val characterName = MutableLiveData<String?>()


    fun searchForCharacter() {
        viewModelScope.launch {
            repository.cachingSearchResult(characterName.value.toString())

        }

    }

}
