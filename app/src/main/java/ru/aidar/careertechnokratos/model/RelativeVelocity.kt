package ru.aidar.careertechnokratos.model

import com.google.gson.annotations.SerializedName

data class RelativeVelocity(
    @SerializedName("kilometers_per_hour")
    val kilometersPerHour: String,
    @SerializedName("miles_per_hour")
    val milesPerHour: String
)