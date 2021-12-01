package com.example.marvelcomics.ui.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.marvelcomics.databinding.FragmentSearchBinding
import com.example.marvelcomics.ui.base.BaseFragment

class SearchFragment : BaseFragment<FragmentSearchBinding>() {
    override val viewModel: SearchViewModel by activityViewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentSearchBinding =
        FragmentSearchBinding::inflate
}