package com.example.marvelcomics.ui.comics

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.ExperimentalPagingApi
import com.example.marvelcomics.databinding.FragmentComicsBinding
import com.example.marvelcomics.ui.base.BaseFragment
import com.example.marvelcomics.ui.comics.adapter.AdapterTest
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@ExperimentalPagingApi
@AndroidEntryPoint
class ComicsFragment : BaseFragment<FragmentComicsBinding>() {
    override val viewModel: ComicsViewModel by viewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentComicsBinding =
        FragmentComicsBinding::inflate

    lateinit var adapter: AdapterTest

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // binding.comicsRecyclerView.adapter = ComicsPagingAdapter(emptyList(), viewModel)

        initMembers()
        initRecycler()

    }

    private fun initMembers() {
        adapter = AdapterTest()
    }

    private fun initRecycler() {
        lifecycleScope.launch {
            viewModel.getCharacterByPaging().distinctUntilChanged().collectLatest {
                adapter.submitData(it)
                Log.i("result", it.toString())
            }
        }
    }
}

