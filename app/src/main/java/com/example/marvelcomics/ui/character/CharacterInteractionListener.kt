package com.example.marvelcomics.ui.character

import com.example.marvelcomics.ui.base.BaseInteractionListener

interface CharacterInteractionListener:BaseInteractionListener {
    fun onItemClicked(id : Long)
}