package com.example.marvelcomics.ui.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.marvelcomics.data.remote.State
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


abstract class BaseViewModel : ViewModel() {

    fun <T> collectValue(repoValue: Flow<State<T?>>, liveValue: MutableLiveData<State<T?>>) {
        viewModelScope.launch {
            repoValue
                .catch { }
                .collect { liveValue.value = it }
        }
    }

}