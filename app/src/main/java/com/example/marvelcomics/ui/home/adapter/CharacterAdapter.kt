package com.example.marvelcomics.ui.home.adapter

import com.example.marvelcomics.R
import com.example.marvelcomics.domain.models.Character
import com.example.marvelcomics.ui.home.HomeInteractionListener

class CharacterAdapter(items: List<Character>, listener: HomeInteractionListener) :
    com.example.marvelcomics.ui.base.BaseAdapter<Character>(items, listener) {
    override val layoutID = R.layout.item_home
}