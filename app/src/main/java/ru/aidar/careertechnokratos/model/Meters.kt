package ru.aidar.careertechnokratos.model

import com.google.gson.annotations.SerializedName

data class Meters(
    @SerializedName("estimated_diameter_max")
    val estimatedDiameterMax: Double,
    @SerializedName("estimated_diameter_min")
    val estimatedDiameterMin: Double
)