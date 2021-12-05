package com.example.marvelcomics.ui.main

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvelcomics.data.lacal.entity.CharactersEntity
import com.example.marvelcomics.domain.MarvelRepository
import com.example.marvelcomics.domain.MarvelRepositoryImpl
import com.example.marvelcomics.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : BaseViewModel() {

//    private val repository: MarvelRepository = MarvelRepositoryImpl()
//
//    val character: LiveData<List<CharactersEntity?>> = repository.getCharacters().asLiveData(Dispatchers.IO)
//
//    init {
//        viewModelScope.launch {
//            repository.loadCharactersFromDataBase()
//        }
//
//
//    }



    fun getChar() {
        // collectValue(repository.getCharacters(),character)
//        Log.i("ooo", "this..toString()")
//        viewModelScope.launch {
//            val x = repository.getCharacters()
//            Log.i("sss", x.toString())
        }
    }
