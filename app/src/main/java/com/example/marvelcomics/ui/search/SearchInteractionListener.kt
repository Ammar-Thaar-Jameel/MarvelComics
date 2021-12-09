package com.example.marvelcomics.ui.search

import com.example.marvelcomics.ui.base.BaseInteractionListener

interface SearchInteractionListener : BaseInteractionListener {
    fun onItemClicked(id: Long)
}