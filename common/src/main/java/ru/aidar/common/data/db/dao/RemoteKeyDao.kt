package ru.aidar.common.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ru.aidar.common.data.db.model.RemoteKeysEntity
import ru.aidar.common.utils.Constants.REMOTE_KEYS_ENTITY_TABLE

@Dao
interface RemoteKeyDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(remoteKey: List<RemoteKeysEntity>)

    @Query("SELECT * FROM $REMOTE_KEYS_ENTITY_TABLE WHERE url = :url")
    suspend fun getKeyByUrl(url: String): RemoteKeysEntity?

    @Query("DELETE FROM $REMOTE_KEYS_ENTITY_TABLE")
    suspend fun deleteAll()

    @Query("SELECT created_at FROM $REMOTE_KEYS_ENTITY_TABLE ORDER BY created_at DESC LIMIT 1")
    suspend fun getCreationTime(): Long?
}