package ru.aidar.careertechnokratos.model

import com.google.gson.annotations.SerializedName

data class EstimatedDiameter(
    @SerializedName("feet")
    val feet: Feet,
    @SerializedName("meters")
    val meters: Meters,
)