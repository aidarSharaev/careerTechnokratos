package ru.aidar.common.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import ru.aidar.common.data.db.dao.ApodDao
import ru.aidar.common.data.db.model.ApodEntity
import ru.aidar.common.utils.Constants.GP_DATABASE

@Database(
    entities = [ApodEntity::class],
    version = 1,
)
abstract class GalaxyPulseDatabase : RoomDatabase() {
    companion object {
        fun get(context: Context): GalaxyPulseDatabase =
            Room
                .databaseBuilder(
                    context.applicationContext,
                    GalaxyPulseDatabase::class.java,
                    GP_DATABASE,
                )
                .fallbackToDestructiveMigration()
                .build()
    }

    abstract fun apodDao(): ApodDao
}
