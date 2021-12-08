package com.example.marvelcomics.ui.details

import com.example.marvelcomics.ui.base.BaseInteractionListener

interface DetailsInteractionListener : BaseInteractionListener {
    fun onItemLoad(id: Long)
}