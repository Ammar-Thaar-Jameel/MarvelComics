package com.example.marvelcomics.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.marvelcomics.databinding.FragmentSearchBinding
import com.example.marvelcomics.ui.base.BaseFragment
import com.example.marvelcomics.ui.home.adapter.CharacterAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    override val viewModel: SearchViewModel by viewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentSearchBinding =
        FragmentSearchBinding::inflate

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchRecyclerView.adapter =
            SearchAdapter(viewModel.characterSearchResult.value ?: emptyList(),viewModel)
    }
}