package com.devmobile.mobilenewproject.utils.extensions.bindingAdapters

import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.devmobile.mobilenewproject.R

@BindingAdapter("url")
fun loadImageFromUrl(
    imagineView: ImageView,
    url: String?) = url?.let {
        Glide.with(imagineView.context)
            .load(url)
            .placeholder(R.drawable.android_ok)
            .into(imagineView)

}