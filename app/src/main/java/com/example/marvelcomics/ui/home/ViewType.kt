package com.example.marvelcomics.ui.home

import com.example.marvelcomics.R

enum class ViewType (val id: Int, val index: Int) {
    CHARACTER(R.layout.item_home_recycler, 0),
    COMICS(R.layout.item_home_character_recycler, 1),
    CHARACTER_THREE(R.layout.item_home_recycler, 2),
    CHARACTER_FOUR(R.layout.item_home_recycler, 3)
}