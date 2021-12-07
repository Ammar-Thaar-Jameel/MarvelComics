package com.example.marvelcomics.ui.home.adapter

import com.example.marvelcomics.BR
import com.example.marvelcomics.domain.models.Character
import com.example.marvelcomics.ui.base.BaseAdapter
import com.example.marvelcomics.ui.home.HomeInteractionListener
import com.example.marvelcomics.ui.home.ViewType

class HomeNestedAdapter(
    private var _items: MutableList<List<Any>>,
    private val _listener: HomeInteractionListener
) : BaseAdapter<Any>(_items, _listener) {
    override val layoutIDs = ViewType.values().map { it.id }
    override var layoutID: Int = layoutIDs.first()

    override fun getItemViewType(position: Int): Int {
        layoutID = layoutIDs[position]
        return super.getItemViewType(position)
    }

    fun setItemsAt(newItems: List<Any>, index: Int) {
        _items[index] = newItems
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        val adapter = when (ViewType.values()[position]) {
            ViewType.CHARACTER -> CharacterAdapter(
                _items[position] as List<Character>,
                _listener
            )

            ViewType.CHARACTERTWO -> CharacterTopAdapter(
                _items[position] as List<Character>,
                _listener
            )
            ViewType.CHARACTERTHREE -> CharacterAdapter(
                _items[position] as List<Character>,
                _listener
            )
            ViewType.CHARACTERF -> CharacterAdapter(
                _items[position] as List<Character>,
                _listener
            )
        }
        (holder as ItemViewHolder).binding.setVariable(BR.adapter, adapter)
    }

    override fun getItemCount() = layoutIDs.size
}