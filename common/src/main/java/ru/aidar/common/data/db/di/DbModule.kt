package ru.aidar.common.data.db.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.aidar.common.data.db.GalaxyPulseDatabase
import ru.aidar.common.data.db.dao.ApodDao
import ru.aidar.common.di.scope.app.ApplicationScope

@Module
class DbModule {
    @Provides
    @ApplicationScope
    fun provideAppDatabase(context: Context): GalaxyPulseDatabase {
        return GalaxyPulseDatabase.get(context)
    }

    @Provides
    @ApplicationScope
    fun provideUserDao(appDatabase: GalaxyPulseDatabase): ApodDao {
        return appDatabase.apodDao()
    }
}
