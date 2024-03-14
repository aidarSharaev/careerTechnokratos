package ru.aidar.common.utils

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import ru.aidar.common.data.db.model.ApodEntity
import ru.aidar.common.data.network.dto.ApodDto

fun ApodEntity.toDto(): ApodDto {
    return ApodDto(
        copyright = copyright,
        date = date,
        explanation = explanation,
        title = title,
        url = url,
        id = id,
    )
}

// TODO check maybe
fun ApodDto.toEntity(): ApodEntity {
    return ApodEntity(
        copyright = copyright ?: "Nasa",
        date = date,
        explanation = explanation,
        title = title,
        url = url,
    )
}

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "appSettings")

