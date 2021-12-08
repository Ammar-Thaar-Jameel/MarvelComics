package com.example.marvelcomics.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvelcomics.data.remote.State
import com.example.marvelcomics.domain.MarvelRepository
import com.example.marvelcomics.domain.models.Character
import com.example.marvelcomics.ui.base.BaseViewModel
import com.example.marvelcomics.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MarvelRepository
) : BaseViewModel(), HomeInteractionListener {


    val character = MutableLiveData<List<Character>>()


    private val _navigateToDetails = MutableLiveData<Event<Long>>()
    val navigateToDetails: LiveData<Event<Long>> = _navigateToDetails



    init {

        viewModelScope.launch {
            caching()
        }


    }

    private fun caching() {
        viewModelScope.launch {
            repository.cachingCharactersInDataBase()
            character.postValue(repository.transferDataFromEntityToCharacter())
        }
    }

    override fun onItemClicked(id: Long) = _navigateToDetails.postValue(Event(id))

}


