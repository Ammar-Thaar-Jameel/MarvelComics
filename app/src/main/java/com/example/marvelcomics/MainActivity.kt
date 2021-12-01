package com.example.marvelcomics

import android.os.Bundle
import androidx.activity.viewModels
import com.example.marvelcomics.databinding.ActivityMainBinding
import com.example.marvelcomics.ui.base.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {
    override val theme = R.style.Theme_MarvelComics
    override val viewID = R.layout.activity_main
    override val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
}