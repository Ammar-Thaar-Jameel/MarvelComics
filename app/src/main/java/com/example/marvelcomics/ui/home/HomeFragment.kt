package com.example.marvelcomics.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.marvelcomics.data.remote.response.Comics
import com.example.marvelcomics.data.remote.response.Data
import com.example.marvelcomics.databinding.FragmentHomeBinding
import com.example.marvelcomics.domain.models.Character
import com.example.marvelcomics.ui.base.BaseFragment
import com.example.marvelcomics.ui.home.adapter.HomeNestedAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val viewModel: HomeViewModel by viewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        binding.homeRecycler.adapter =
//            CharacterAdapter(viewModel.character.value?.toData() ?: emptyList(),viewModel)


        val items = mutableListOf(
            emptyList<Character>(),
            emptyList<Data<Character>>(),
            emptyList<Comics>(),
            emptyList<Character>()
        )
        val adapter = HomeNestedAdapter(items, viewModel)

        viewModel.transfer.observe(this, { state ->

            adapter.setItemsAt(state as List<Character>, ViewType.CHARACTER.index)


        })
        viewModel.transfer.observe(this, { state ->

            adapter.setItemsAt(state as List<Character>, ViewType.CHARACTERTWO.index)


        })
        viewModel.transfer.observe(this, { state ->

            adapter.setItemsAt(state as List<Character>, ViewType.CHARACTERTHREE.index)


        })
        viewModel.transfer.observe(this, { state ->

            adapter.setItemsAt(state as List<Character>, ViewType.CHARACTERF.index)


        })


        binding.adapter = adapter
    }

}