package com.example.marvelcomics.ui.home

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvelcomics.domain.MarvelRepository
import com.example.marvelcomics.domain.MarvelRepositoryImpl
import com.example.marvelcomics.domain.models.Character
import com.example.marvelcomics.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class HomeViewModel : BaseViewModel(), HomeInteractionListener {

    private val repository: MarvelRepository = MarvelRepositoryImpl()


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


