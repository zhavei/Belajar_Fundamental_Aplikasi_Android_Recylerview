package com.syafei.belajarfundamentalaplikasiandroidrecylerview.myrecylerview.data

import android.accounts.AuthenticatorDescription
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@kotlinx.parcelize.Parcelize
data class Hero(
    var name: String,
    var description: String,
    var photo: Int
) : Parcelable
