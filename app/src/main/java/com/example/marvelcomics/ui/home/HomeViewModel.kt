package com.example.marvelcomics.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvelcomics.domain.MarvelRepository
import com.example.marvelcomics.domain.models.Character
import com.example.marvelcomics.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: MarvelRepository
) : BaseViewModel(), HomeInteractionListener {


    val transfer = MutableLiveData<List<Character>>()


    init {

        viewModelScope.launch {
            caching()
        }


    }

    private fun caching() {
        viewModelScope.launch {
            repository.cachingCharactersInDataBase()
            transfer.postValue(repository.transferDataFromEntityToCharacter())
        }
    }

}


