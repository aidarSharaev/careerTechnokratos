package ru.aidar.common.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.aidar.common.utils.Constants.APOD_ENTITY_TABLE

@Entity(tableName = APOD_ENTITY_TABLE)
data class ApodEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "url")
    val url: String,
    @ColumnInfo(name = "copyright")
    val copyright: String,
    @ColumnInfo(name = "date")
    val date: String,
    @ColumnInfo(name = "explanation")
    val explanation: String,
    @ColumnInfo(name = "title")
    val title: String,
    @ColumnInfo(name = "page")
    val page: Int,
)
