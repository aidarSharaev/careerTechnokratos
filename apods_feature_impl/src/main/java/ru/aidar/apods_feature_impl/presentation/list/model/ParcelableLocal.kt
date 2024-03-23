package ru.aidar.apods_feature_impl.presentation.list.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ParcelableLocal(
    val copyright: String,
    val date: String,
    val explanation: String,
    val title: String,
    val url: String?,
) : Parcelable

