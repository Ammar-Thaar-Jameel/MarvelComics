package com.example.marvelcomics.ui.home

import com.example.marvelcomics.ui.base.BaseInteractionListener

interface HomeInteractionListener : BaseInteractionListener {
    fun onItemClicked(id : Long)
}