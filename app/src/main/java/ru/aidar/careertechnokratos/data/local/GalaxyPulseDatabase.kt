package ru.aidar.careertechnokratos.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [ApodEntity::class, NeoEntity::class],
    version = 1,
)
@TypeConverters(Converters::class)
abstract class GalaxyPulseDatabase: RoomDatabase() {

    abstract val neoDao: NeoDao
    abstract val apodDao: ApodDao

}