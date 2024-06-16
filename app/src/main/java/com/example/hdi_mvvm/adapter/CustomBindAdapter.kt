package com.example.hdi_mvvm.adapter

import android.graphics.drawable.Drawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

class CustomBindAdapter {

    companion object {
        @BindingAdapter("app:imgUrl","app:placeholder", requireAll = false)
        @JvmStatic
        fun onBindImage(
            imageView: ImageView,
            url:String,
            placeholder:Drawable
        ) {
            // 网络图片加载
            Glide.with(imageView)
                .load(url)
                .placeholder(placeholder)
                .into(imageView)
        }
    }
}