package ru.aidar.careertechnokratos.model.additional

import com.google.gson.annotations.SerializedName

data class Feet(
    @SerializedName("estimated_diameter_max")
    val estimatedDiameterMax: Double,
    @SerializedName("estimated_diameter_min")
    val estimatedDiameterMin: Double
)