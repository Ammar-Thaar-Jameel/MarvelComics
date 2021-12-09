package com.example.marvelcomics.ui.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvelcomics.domain.MarvelRepository
import com.example.marvelcomics.domain.models.CharacterSearchResult
import com.example.marvelcomics.ui.base.BaseViewModel
import com.example.marvelcomics.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val repository: MarvelRepository
) : BaseViewModel(), SearchInteractionListener {


    val characterSearchResult: LiveData<List<CharacterSearchResult>> =
        repository.getSearchResult().asLiveData()


    val characterName = MutableLiveData<String?>()

    private val _navigateToDetails = MutableLiveData<Event<Long>>()
    val navigateToDetails: LiveData<Event<Long>> = _navigateToDetails

    fun searchForCharacter() {
        viewModelScope.launch {
            repository.cachingSearchResult(characterName.value.toString())

        }

    }

    override fun onItemClicked(id: Long) = _navigateToDetails.postValue(Event(id))
}
