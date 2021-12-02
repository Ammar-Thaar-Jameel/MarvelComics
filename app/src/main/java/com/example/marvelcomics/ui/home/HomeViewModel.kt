package com.example.marvelcomics.ui.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asLiveData
import com.example.marvelcomics.data.remote.State
import com.example.marvelcomics.data.remote.response.BaseResponse
import com.example.marvelcomics.data.remote.response.CharactersDto
import com.example.marvelcomics.data.remote.response.Data
import com.example.marvelcomics.domain.MarvelRepository
import com.example.marvelcomics.domain.MarvelRepositoryImpl
import com.example.marvelcomics.domain.models.Character
import com.example.marvelcomics.ui.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

class HomeViewModel : BaseViewModel(),HomeInteractionListener {

    private val repository: MarvelRepository = MarvelRepositoryImpl()

    val character: List<Character>? = repository.getCharacterstoobject()


    val comics = MutableLiveData<State<Data?>>()

    init {
        getAllCharectores()
        getAllComics()
    }

    private fun getAllComics() {
//        val x=repository.getAllComics("Ironman")
//        collectValue(x,comics)
//        Log.v("comics",x.toString())
    }

    fun getAllCharectores() {
     //   collectValue(repository.getAllCharacters(), character)
//        viewModelScope.launch {
//            val resopnse=repository.getAllCharacters()
//            Log.i("base",resopnse.toString())
//        }
    }


}