package com.example.marvelcomics.ui.comics.adapter

import com.example.marvelcomics.R
import com.example.marvelcomics.data.remote.response.CharactersDto
import com.example.marvelcomics.ui.base.BaseAdapter
import com.example.marvelcomics.ui.comics.ComicsInteractionListener

class ComicsPagingAdapter(list: List<CharactersDto>, listener: ComicsInteractionListener) :
    BaseAdapter<CharactersDto>(list, listener) {

    override var layoutID = R.layout.item_comics
}