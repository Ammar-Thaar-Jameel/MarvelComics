package com.example.marvelcomics.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.marvelcomics.databinding.FragmentSearchBinding
import com.example.marvelcomics.ui.base.BaseFragment
import com.example.marvelcomics.ui.home.HomeFragmentDirections
import com.example.marvelcomics.utils.EventObserver
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    override val viewModel: SearchViewModel by viewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentSearchBinding =
        FragmentSearchBinding::inflate


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchRecyclerView.adapter =
            SearchAdapter(viewModel.characterSearchResult.value ?: emptyList(), viewModel)
        observe()
    }


    private fun observe() {
        viewModel.navigateToDetails.observe(viewLifecycleOwner, EventObserver { onNavigate(it) })
    }

    private fun onNavigate(characterId: Long) {
        findNavController().navigate(
            SearchFragmentDirections.actionSearchFragmentToDetailsFragment(characterId)
        )
    }
}