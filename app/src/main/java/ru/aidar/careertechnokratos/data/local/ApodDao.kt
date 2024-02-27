package ru.aidar.careertechnokratos.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert

@Dao
interface ApodDao {

    @Upsert
    suspend fun upsertAll(apods: List<ApodEntity>)

    @Query("DELETE FROM ")
    suspend fun deleteAll()

}