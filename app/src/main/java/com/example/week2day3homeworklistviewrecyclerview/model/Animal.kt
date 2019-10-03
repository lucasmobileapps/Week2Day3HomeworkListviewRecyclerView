package com.example.week2day3homeworklistviewrecyclerview.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Animal(val category:String, val species:String, val origin:String) : Parcelable
class Categories(val category:String)
