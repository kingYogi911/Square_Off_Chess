package com.example.squareoffchess.utils

import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.databinding.BindingAdapter
import com.example.squareoffchess.R
import com.squareup.picasso.Picasso

class CustomBindingAdapters {
    companion object {
        @JvmStatic
        @BindingAdapter(value = ["url"],requireAll = true)
        fun setImage(view: ImageView, url: String?) {
            if (url.isNullOrEmpty()) {
                view.setImageDrawable(
                    ContextCompat.getDrawable(view.context, R.drawable.ic_image_not_available)
                )
            } else {
                Picasso.get()
                    .load(url)
                    .placeholder(R.drawable.progress_drawable)
                    .error(R.drawable.ic_image_not_available)
                    .into(view)
            }
        }
    }
}