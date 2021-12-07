package com.example.marvelcomics.ui.search

import com.example.marvelcomics.R
import com.example.marvelcomics.domain.models.Character
import com.example.marvelcomics.domain.models.CharacterSearchResult
import com.example.marvelcomics.ui.base.BaseAdapter

class SearchAdapter(list: List<CharacterSearchResult>, listener: SearchInteractionListener) :
    BaseAdapter<CharacterSearchResult>(list, listener) {

    override var layoutID = R.layout.item_search
}