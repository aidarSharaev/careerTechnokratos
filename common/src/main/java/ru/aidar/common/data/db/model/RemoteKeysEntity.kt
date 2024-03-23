package ru.aidar.common.data.db.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import ru.aidar.common.utils.Constants.REMOTE_KEYS_ENTITY_TABLE

@Entity(tableName = REMOTE_KEYS_ENTITY_TABLE)
data class RemoteKeysEntity(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = "url")
    val pictureUrl: String,
    val prevKey: Int?,
    val currentPage: Int,
    val nextKey: Int?,
    @ColumnInfo(name = "created_at")
    val createdAt: Long = System.currentTimeMillis()
)