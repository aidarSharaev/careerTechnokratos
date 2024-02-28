package ru.aidar.careertechnokratos.model.additional

import com.google.gson.annotations.SerializedName

data class MissDistance(
    @SerializedName("kilometers")
    val kilometers: String,
    @SerializedName("miles")
    val miles: String
)