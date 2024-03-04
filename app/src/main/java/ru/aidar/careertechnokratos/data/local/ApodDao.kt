package ru.aidar.careertechnokratos.data.local

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import ru.aidar.careertechnokratos.constants.Constants.APOD_ENTITY_TABLE
import ru.aidar.careertechnokratos.constants.Constants.NEO_ENTITY_TABLE


@Dao
interface ApodDao {

    @Upsert
    suspend fun upsertAllApods(apods: List<ApodEntity>)

    @Query("SELECT * FROM $APOD_ENTITY_TABLE")
    fun pagingApodSource(): PagingSource<Int, ApodEntity>

    @Query("DELETE FROM $APOD_ENTITY_TABLE")
    suspend fun deleteAll()

}