package com.example.marvelcomics.utils

import android.view.View
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.marvelcomics.R
import com.example.marvelcomics.data.remote.State
import com.example.marvelcomics.ui.base.BaseAdapter
import com.google.android.material.imageview.ShapeableImageView

@BindingAdapter(value = ["app:showWhenLoading"])
fun <T> showWhenLoading(view: View, state: State<T>?) {
    view.isVisible = (state is State.Loading)
}

@BindingAdapter(value = ["app:showWhenError"])
fun <T> showWhenError(view: View, state: State<T>?) {
    view.isVisible = (state is State.Error)
}

@BindingAdapter(value = ["app:showWhenSuccess"])
fun <T> showWhenSuccess(view: View, state: State<T>?) {
    view.isVisible = (state is State.Success)
}

@BindingAdapter(value = ["app:items"])
fun <T> setRecyclerItems(view: RecyclerView?, items: List<T>?) {
    (view?.adapter as BaseAdapter<T>?)?.setItems(items ?: emptyList())
}

@BindingAdapter(value = ["app:image"])
fun setImage(view: ShapeableImageView?, imagePath: String?) {
    view?.let {
        Glide.with(view)
            .load(Constant.BASE_IMAGE_URL)
            .placeholder(R.drawable.ic_baseline_downloading_24)
            .centerCrop()
            .error(R.drawable.ic_baseline_error_outline_24)
            .centerCrop()
            .into(view)
    }
}