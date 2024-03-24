package ru.aidar.apa_feature_api.remote

import com.google.gson.annotations.SerializedName

data class ApaLocal(
    @SerializedName("id")
    val id: String,
    @SerializedName("englishName")
    val name: String,
    @SerializedName("isPlanet")
    val isPlanet: Boolean,
    @SerializedName("moons")
    val moons: List<Moon>?,
    @SerializedName("mass")
    val mass: Mass?,
    @SerializedName("vol")
    val vol: Vol?,
    @SerializedName("discoveredBy")
    val discoveredBy: String?,
    @SerializedName("discoveryDate")
    val discoveryDate: String?,
)


data class Moon(
    @SerializedName("moon")
    val moon: String,
    @SerializedName("rel")
    val rel: String,
)

data class Mass(
    @SerializedName("massValue")
    val massValue: Double,
    @SerializedName("massExponent")
    val massExponent: Int,
)
data class Vol(
    @SerializedName("volValue")
    val volValue: Double,
    @SerializedName("volExponent")
    val volExponent: Int,
)
