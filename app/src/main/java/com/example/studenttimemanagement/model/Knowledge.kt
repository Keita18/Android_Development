package com.example.studenttimemanagement.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Knowledge(
    var id: Int? = null,
    var name: String? = null,
    var description: String?  = null
) : Parcelable