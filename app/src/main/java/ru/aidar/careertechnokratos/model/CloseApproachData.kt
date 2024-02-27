package ru.aidar.careertechnokratos.model

import com.google.gson.annotations.SerializedName

data class CloseApproachData(
    @SerializedName("close_approach_date_full")
    val closeApproachDateFull: String,
    @SerializedName("miss_distance")
    val missDistance: MissDistance,
    @SerializedName("relative_velocity")
    val relativeVelocity: RelativeVelocity
)