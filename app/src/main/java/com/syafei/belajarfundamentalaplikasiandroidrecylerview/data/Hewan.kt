package com.syafei.belajarfundamentalaplikasiandroidrecylerview.data

import android.widget.ImageView
import androidx.annotation.DrawableRes

data class Hewan(
    @DrawableRes
    val images: Int = 0,
    val names: String = "",
    val age: Int = 0,
    val food: String = ""

)
