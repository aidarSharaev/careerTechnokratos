package ru.aidar.careertechnokratos.model

import com.google.gson.annotations.SerializedName

data class NeoDto(
    @SerializedName("near_earth_objects")
    val nearEarthObjects: NearEarthObjects
)