package ru.aidar.common.utils

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

// TODO
fun ApodDto.toEntity(): ApodEntity {
    return ApodEntity(
        copyright = copyright ?: "Nasa",
        date = date,
        explanation = explanation,
        title = title,
        url = url,
    )
}