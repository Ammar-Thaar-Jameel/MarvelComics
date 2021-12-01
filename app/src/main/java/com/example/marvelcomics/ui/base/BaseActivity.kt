package com.example.marvelcomics.ui.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import com.example.marvelcomics.BR


abstract class BaseActivity<VDB : ViewDataBinding> : AppCompatActivity() {

    abstract val theme: Int
    abstract val viewID: Int
    private lateinit var _binding: VDB
    protected val binding get() = _binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, viewID)
        _binding.lifecycleOwner = this
    }

}