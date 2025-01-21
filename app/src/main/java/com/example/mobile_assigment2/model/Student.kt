package com.example.mobile_assigment2.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Student(
    val name: String,
    val id: String,
    val avatarUrl: String,
    var isChecked: Boolean
) : Parcelable