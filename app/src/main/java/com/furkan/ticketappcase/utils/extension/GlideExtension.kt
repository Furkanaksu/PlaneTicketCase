package com.furkan.ticketappcase.utils.extension

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.FitCenter
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

fun ImageView.loadImage(url: String){
    Glide.with(this)
        .load(url)
        .transform(FitCenter(), RoundedCorners(25))
        .into(this)
}