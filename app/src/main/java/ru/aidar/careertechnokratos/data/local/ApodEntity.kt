package ru.aidar.careertechnokratos.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.aidar.common.base.BaseEntity
import ru.aidar.common.utils.Constants.APOD_ENTITY_TABLE
import ru.aidar.careertechnokratos.model.ApodDto

@Entity(tableName = APOD_ENTITY_TABLE)
data class ApodEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val copyright: String,
    val date: String,
    val explanation: String,
    val title: String,
    val url: String,
) : BaseEntity {
    override fun toDto(): ApodDto {
        return ApodDto(
            // todo id?
            id = id,
            copyright = copyright,
            date = date,
            explanation = explanation,
            title = title,
            url = url,
        )
    }

}