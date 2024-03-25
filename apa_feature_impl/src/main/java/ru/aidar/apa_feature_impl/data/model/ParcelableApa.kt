package ru.aidar.apa_feature_impl.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import ru.aidar.apa_feature_api.remote.ApaLocal

fun ApaLocal.toParce(): ParcelableApa {
    return ParcelableApa(
        id = id,
        name = name,
        isPlanet = isPlanet,
        discoveredBy = discoveredBy,
        discoveryDate = discoveryDate,
        massValue = mass?.massValue?.toString() ?: "Unknown",
        massExponent = mass?.massExponent?.toString() ?: "Unknown",
        volValue = vol?.volValue?.toString() ?: "Unknown",
        volExponent = vol?.volExponent?.toString() ?: "Unknown",
        listMoons = if(moons != null && moons!!.isNotEmpty()) {
            val mutableList = mutableListOf<String>()
            moons!!.forEach { mutableList.add(it.moon) }
            mutableList
        } else null,
        listRels = if(moons != null && moons!!.isNotEmpty()) {
            val mutableList = mutableListOf<String>()
            moons!!.forEach { mutableList.add(it.rel) }
            mutableList
        } else null,
    )
}


@Parcelize
data class ParcelableApa(
    val id: String,
    val name: String,
    val isPlanet: Boolean,
    val discoveredBy: String?,
    val discoveryDate: String?,
    val massValue: String,
    val massExponent: String,
    val volValue: String,
    val volExponent: String,
    val listMoons: MutableList<String>? = null,
    val listRels: MutableList<String>?,
) : Parcelable
