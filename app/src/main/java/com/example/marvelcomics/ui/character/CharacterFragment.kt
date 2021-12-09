package com.example.marvelcomics.ui.character

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.ExperimentalPagingApi
import androidx.recyclerview.widget.RecyclerView
import com.example.marvelcomics.databinding.FragmentCharacterBinding
import com.example.marvelcomics.ui.base.BaseFragment
import com.example.marvelcomics.ui.character.adapter.CharacterPagingAdapter
import com.example.marvelcomics.utils.EventObserver
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@ExperimentalPagingApi
@AndroidEntryPoint
class CharacterFragment : BaseFragment<FragmentCharacterBinding>() {
    override val viewModel: CharacterViewModel by viewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentCharacterBinding =
        FragmentCharacterBinding::inflate

    lateinit var adapter: CharacterPagingAdapter
    private lateinit var comicsRecyclerView: RecyclerView

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        initMembers()
        setUpViews()
        initRecycler()
        observe()

    }

    private fun initMembers() {
        adapter = CharacterPagingAdapter()
    }

    private fun initRecycler() {
        lifecycleScope.launch {
            viewModel.getCharacterByPaging().distinctUntilChanged().collectLatest {
                adapter.submitData(it)
                Log.i("result", it.toString())
            }
        }
    }

    private fun setUpViews() {
        comicsRecyclerView = binding.characterRecyclerView
        comicsRecyclerView.adapter = adapter
    }

    private fun observe() {
        viewModel.navigateToDetails.observe(viewLifecycleOwner, EventObserver { onNavigate(it) })
    }

    private fun onNavigate(characterId: Long) {
        findNavController().navigate(
            CharacterFragmentDirections.actionCharacterFragmentToDetailsFragment(characterId) )
    }
}

