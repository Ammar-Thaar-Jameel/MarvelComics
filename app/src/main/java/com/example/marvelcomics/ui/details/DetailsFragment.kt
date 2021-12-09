package com.example.marvelcomics.ui.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.marvelcomics.databinding.FragmentDetailsBinding
import com.example.marvelcomics.ui.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailsFragment :BaseFragment<FragmentDetailsBinding>(){
    override val viewModel:DetailsViewModel by viewModels()
    override val inflate: (LayoutInflater, ViewGroup?, attachToRoot: Boolean) -> FragmentDetailsBinding
        get() =FragmentDetailsBinding::inflate

    private val args: DetailsFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onItemLoad(args.characterId)

    }
}