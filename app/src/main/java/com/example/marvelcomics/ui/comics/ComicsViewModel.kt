package com.example.marvelcomics.ui.comics

import androidx.lifecycle.viewModelScope
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.example.marvelcomics.data.remote.response.CharactersDto
import com.example.marvelcomics.domain.MarvelRepository
import com.example.marvelcomics.ui.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class ComicsViewModel @Inject constructor(
    private val repository: MarvelRepository
) : BaseViewModel(), ComicsInteractionListener {


    fun getCharacterByPaging(): Flow<PagingData<CharactersDto>> {
        return repository.getCharacterByPaging(pagingConfig = getDefaultPageConfig())
            .cachedIn(viewModelScope)
    }

    private fun getDefaultPageConfig(): PagingConfig {
        return PagingConfig(pageSize = 20)
    }

}