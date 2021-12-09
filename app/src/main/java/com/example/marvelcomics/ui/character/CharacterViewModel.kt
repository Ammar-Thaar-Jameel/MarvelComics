package com.example.marvelcomics.ui.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.marvelcomics.data.remote.response.CharactersDto
import com.example.marvelcomics.domain.MarvelRepository
import com.example.marvelcomics.ui.base.BaseViewModel
import com.example.marvelcomics.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel @Inject constructor(
    private val repository: MarvelRepository
) : BaseViewModel(), CharacterInteractionListener {



    private val _navigateToDetails = MutableLiveData<Event<Long>>()
    val navigateToDetails: LiveData<Event<Long>> = _navigateToDetails





    fun getCharacterByPaging(): Flow<PagingData<CharactersDto>> {
        return repository.getCharacterByPaging(pagingConfig = getDefaultPageConfig())
            .cachedIn(viewModelScope)
    }

    private fun getDefaultPageConfig(): PagingConfig {
        return PagingConfig(pageSize = 20)
    }

    override fun onItemClicked(id: Long)  = _navigateToDetails.postValue(Event(id))

}