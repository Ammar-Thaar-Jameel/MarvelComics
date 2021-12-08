package com.example.marvelcomics.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.marvelcomics.data.remote.State
import com.example.marvelcomics.data.remote.response.BaseResponse
import com.example.marvelcomics.data.remote.response.CharactersDto
import com.example.marvelcomics.data.remote.response.Data
import com.example.marvelcomics.domain.MarvelRepository
import com.example.marvelcomics.domain.models.Character
import com.example.marvelcomics.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val repository: MarvelRepository
): BaseViewModel(),DetailsInteractionListener {



    var characterDetails = MutableLiveData<State<Character>>()


    override fun onItemLoad(id: Long) {
        viewModelScope.launch {
            repository.getCharacterDetailsById(id).collect {
                characterDetails.postValue(it)
            }
        }

    }
}