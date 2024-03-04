package ru.aidar.careertechnokratos.model

import com.google.gson.annotations.SerializedName
import ru.aidar.careertechnokratos.model.additional.CloseApproachData
import ru.aidar.careertechnokratos.model.additional.EstimatedDiameter

data class NeoObject(
    @SerializedName("absolute_magnitude_h")
    val absoluteMagnitudeH: Double,
    @SerializedName("close_approach_data")
    val closeApproachData: List<CloseApproachData>,
    @SerializedName("estimated_diameter")
    val estimatedDiameter: EstimatedDiameter,
    @SerializedName("id")
    val id: String,
    @SerializedName("is_potentially_hazardous_asteroid")
    val isPotentiallyHazardousAsteroid: Boolean,
    @SerializedName("name")
    val name: String,
)