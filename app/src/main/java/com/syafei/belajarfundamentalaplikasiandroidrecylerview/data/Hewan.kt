package com.syafei.belajarfundamentalaplikasiandroidrecylerview.data

import android.widget.ImageView
import androidx.annotation.DrawableRes

data class Hewan(
    @DrawableRes
    val images: Int,
    val names: String,
    val age: Int,
    val food: String

)
