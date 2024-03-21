package ru.aidar.common.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.aidar.common.utils.Constants.APOD_ENTITY_TABLE

@Entity(tableName = APOD_ENTITY_TABLE)
data class ApodEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val copyright: String,
    val date: String,
    val explanation: String,
    val title: String,
    val url: String? = null,
)
