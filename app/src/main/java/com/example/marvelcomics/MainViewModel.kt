package com.example.marvelcomics

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvelcomics.domain.repository.MarvelRepository
import com.example.marvelcomics.domain.repository.MarvelRepositoryImpl
import com.example.marvelcomics.model.State
import com.example.marvelcomics.model.response.CharactersDto
import com.example.marvelcomics.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class MainViewModel:BaseViewModel() {

    private val repository: MarvelRepository = MarvelRepositoryImpl()
    val character= MutableLiveData<State<CharactersDto?>>()
    init {
           // getChar()
    }
    fun getChar(){
      // collectValue(repository.getCharacters(),character)
        Log.i("ooo","this..toString()")
        viewModelScope.launch {
           val x= repository.getCharacters()
            Log.i("sss",x.toString())
        }
    }
}