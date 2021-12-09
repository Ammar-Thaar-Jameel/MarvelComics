package com.example.marvelcomics.ui.main

import androidx.navigation.findNavController
import com.example.marvelcomics.R
import com.example.marvelcomics.databinding.ActivityMainBinding
import com.example.marvelcomics.ui.base.BaseActivity
import com.example.marvelcomics.utils.onNavDestinationSelected
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {
    // override val theme = R.style.Theme_MarvelComics
    override val viewID = R.layout.activity_main


    override fun onResume() {
        super.onResume()
        initNavBar()
    }

    private fun initNavBar() {
        val navController = findNavController(R.id.fragment_container_view)

        binding.bubbleTabBar.apply {
            addBubbleListener { id ->
                onNavDestinationSelected(id, navController)
            }

            navController.addOnDestinationChangedListener { _, destination, _ ->
                this.setSelectedWithId(destination.id, false)
            }
        }
    }
}