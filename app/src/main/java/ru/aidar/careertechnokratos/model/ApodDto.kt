package ru.aidar.careertechnokratos.model

import com.google.gson.annotations.SerializedName
import ru.aidar.common.base.BaseDto
import ru.aidar.careertechnokratos.data.local.ApodEntity

data class ApodDto(
    val id: Long,
    @SerializedName("copyright")
    val copyright: String?,
    @SerializedName("date")
    val date: String,
    @SerializedName("explanation")
    val explanation: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("url")
    val url: String,
) : BaseDto.BaseEntityDto() {
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
