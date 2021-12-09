package com.example.marvelcomics.ui.comics.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.ExperimentalPagingApi
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelcomics.R
import com.example.marvelcomics.data.remote.response.CharactersDto
import com.example.marvelcomics.databinding.ItemComicsBinding

@ExperimentalPagingApi
class AdapterTest : PagingDataAdapter<CharactersDto,
        AdapterTest.ItemViewHolder>(diffCallback) {


    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemComicsBinding.bind(view)
    }

    companion object {
        val diffCallback = object : DiffUtil.ItemCallback<CharactersDto>() {
            override fun areItemsTheSame(oldItem: CharactersDto, newItem: CharactersDto): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: CharactersDto,
                newItem: CharactersDto
            ): Boolean {
                return oldItem == newItem
            }
        }
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_comics, parent, false)

        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val currentCharacter = getItem(position)
        holder.binding.item = currentCharacter

    }


}


