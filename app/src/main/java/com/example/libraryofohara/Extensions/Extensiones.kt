package com.example.libraryofohara.Extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.cargarImagen(url: String) {
    if (url.isNotEmpty()) {
        Glide.with(this.context).load(url).into(this)
    }

}
