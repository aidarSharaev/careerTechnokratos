package ru.aidar.careertechnokratos.model

import ru.aidar.careertechnokratos.base.BaseDto
import ru.aidar.careertechnokratos.data.local.ApodEntity

data class ApodDto(
    val id: Long?,
    val copyright: String?,
    val date: String,
    val explanation: String,
    val title: String,
    val url: String,
    val hdurl: String? = null,
    val media_type: String? = null,
    val service_version: String? = null,
) : BaseDto {
    override fun toEntity(): ApodEntity {
        return ApodEntity(
            copyright = copyright ?: "NASA",
            date = date,
            explanation = explanation,
            title = title,
            url = url,
        )
    }
}
