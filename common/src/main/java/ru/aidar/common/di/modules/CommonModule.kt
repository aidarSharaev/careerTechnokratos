package ru.aidar.common.di.modules

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.aidar.common.core.config.AppProperties
import ru.aidar.common.core.resources.ResourceManager
import ru.aidar.common.core.resources.ResourceManagerImpl
import ru.aidar.common.di.scope.ApplicationScope

@Module
class CommonModule {

    @Provides
    @ApplicationScope
    fun provideAppProperties(context: Context): AppProperties {
        return AppProperties(context = context)
    }

    @Provides
    @ApplicationScope
    fun provideResourceManager(context: Context): ResourceManager {
        return ResourceManagerImpl(context)
    }
}