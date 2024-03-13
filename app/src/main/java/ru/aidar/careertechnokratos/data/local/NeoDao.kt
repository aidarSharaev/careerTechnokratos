package ru.aidar.careertechnokratos.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import ru.aidar.common.utils.Constants.NEO_ENTITY_TABLE

@Dao
interface NeoDao {

    @Upsert
    suspend fun upsertAllNeos(neos: List<NeoEntity>)

    @Query("SELECT * FROM $NEO_ENTITY_TABLE")
    fun pagingNeoSource(): PagingSource<Int, NeoEntity>

    @Query("DELETE FROM $NEO_ENTITY_TABLE")
    suspend fun deleteAll()
}