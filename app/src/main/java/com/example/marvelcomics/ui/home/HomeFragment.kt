package com.example.marvelcomics.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.marvelcomics.data.remote.State
import com.example.marvelcomics.data.remote.response.Data
import com.example.marvelcomics.databinding.FragmentHomeBinding
import com.example.marvelcomics.domain.models.Character
import com.example.marvelcomics.ui.base.BaseFragment
import com.example.marvelcomics.ui.home.adapter.CharacterAdapter
import com.example.marvelcomics.ui.home.adapter.HomeNestedAdapter

class HomeFragment : BaseFragment<FragmentHomeBinding>() {
    override val viewModel: HomeViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentHomeBinding =
        FragmentHomeBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.homeRecycler.adapter =
            CharacterAdapter(viewModel.character.value?.toData() ?: emptyList(),viewModel)


        val items = mutableListOf(
            emptyList<Character>(),
            emptyList<Data>(),
            emptyList<Character>(),
            emptyList<Character>()
        )
        val adapter = HomeNestedAdapter(items, viewModel)

//        viewModel.character.observe(this, { state ->
//            if (state is State.Success) {
//                state.data?.let { data ->
//                    adapter.setItemsAt(data, ViewType.CHARACTER.index)
//                }
//            }
//
//        })
//
//        viewModel.character.observe(this, { state ->
//            if (state is State.Success) {
//                state.data?.let { data ->
//                    adapter.setItemsAt(data, ViewType.CHARACTERTWO.index)
//                }
//            }
//        })
//
//        viewModel.character.observe(this, { state ->
//            if (state is State.Success) {
//                state.data?.let { data ->
//                    adapter.setItemsAt(data, ViewType.CHARACTERTHREE.index)
//                }
//            }
//        })
//
//        viewModel.character.observe(this, { state ->
//            if (state is State.Success) {
//                state.data?.let { data ->
//                    adapter.setItemsAt(data, ViewType.CHARACTERF.index)
//                }
//            }
//        })

        binding.adapter = adapter
    }

}