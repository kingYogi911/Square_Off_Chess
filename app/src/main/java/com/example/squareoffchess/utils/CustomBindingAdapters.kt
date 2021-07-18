package com.example.squareoffchess.utils

import android.graphics.BitmapFactory
import android.util.Log
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
            Log.d("CustomBindingAdapter","url:$url")
            Picasso.get().cancelRequest(view)//clear last request
            if (url.isNullOrEmpty()) {
                view.setImageResource(R.drawable.ic_image_not_available)
            } else {
                Picasso.get()
                    .load(url)
                    .fit()
                    .placeholder(R.drawable.progress_drawable)
                    .error(R.drawable.ic_something_went_wrong)
                    .into(view)
            }
        }
    }
}