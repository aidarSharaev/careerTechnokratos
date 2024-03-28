package ru.aidar.common.data.db.local.di

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.aidar.common.data.db.local.GalaxyPulseDatabase
import ru.aidar.common.data.db.local.dao.ApodDao
import ru.aidar.common.data.db.local.dao.RemoteKeyDao
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
    fun provideApodDao(appDatabase: GalaxyPulseDatabase): ApodDao {
        return appDatabase.apodDao()
    }

    @Provides
    @ApplicationScope
    fun provideKeysDao(appDatabase: GalaxyPulseDatabase): RemoteKeyDao {
        return appDatabase.remoteKeysDao()
    }
}
