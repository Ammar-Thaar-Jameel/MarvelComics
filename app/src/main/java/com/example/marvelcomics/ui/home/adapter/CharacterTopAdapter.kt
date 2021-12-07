package com.example.marvelcomics.ui.home.adapter

import com.example.marvelcomics.R
import com.example.marvelcomics.domain.models.Character
import com.example.marvelcomics.ui.base.BaseAdapter
import com.example.marvelcomics.ui.home.HomeInteractionListener

class CharacterTopAdapter(items: List<Character>, listener: HomeInteractionListener) :
    BaseAdapter<Character>(items, listener) {
    override val layoutID = R.layout.item_home_character_top
}