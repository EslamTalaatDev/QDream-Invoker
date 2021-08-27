package com.dev.utils

import android.graphics.Bitmap
import android.graphics.drawable.Drawable
import android.util.TypedValue
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions


@BindingAdapter(value = ["android:src", "placeholder"], requireAll = false)
fun loadImage(view: ImageView, url: String, placeHolder: Drawable) {
    Glide.with(view.context).load(url)
        .apply(RequestOptions.placeholderOf(placeHolder).error(placeHolder)).into(view)
}


fun loadImage(iv: ImageView, bitmap: Bitmap) {
    Glide.with(iv.context).load(bitmap).into(iv)
}

@BindingAdapter("layout_height")
fun setLayoutHeight(view: View, height: Float) {
    val layoutParams: ViewGroup.LayoutParams = view.layoutParams
    layoutParams.height = height.toInt()
    view.layoutParams = layoutParams
}

@BindingAdapter("textSize")
fun setTextSize(text: TextView, size: Float) {
    text.setTextSize(TypedValue.COMPLEX_UNIT_SP, size);
}
