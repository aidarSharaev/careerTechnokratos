package ru.aidar.common.utils

import ru.aidar.common.data.db.model.ApodEntity
import ru.aidar.common.data.network.dto.ApodDto

fun ApodEntity.toDto(): ApodDto {
    return ApodDto(
        id = id,
        copyright = copyright,
        date = date,
        explanation = explanation,
        title = title,
        url = url,
    )
}

// TODO
fun ApodDto.toDto(): ApodEntity {
    return ApodEntity(
        id = id,
        copyright = copyright ?: "Nasa",
        date = date,
        explanation = explanation,
        title = title,
        url = url,
    )
}