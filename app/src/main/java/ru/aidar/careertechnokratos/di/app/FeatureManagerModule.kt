package ru.aidar.careertechnokratos.di.app

import dagger.Module
import dagger.Provides
import ru.aidar.careertechnokratos.di.deps.FeatureHolderManager
import ru.aidar.common.di.FeatureApiHolder
import ru.aidar.common.di.scope.ApplicationScope

@Module
class FeatureManagerModule {
    @ApplicationScope
    @Provides
    fun provideFeatureHolderManager(
        featureApiHolderMap: @JvmSuppressWildcards Map<Class<*>, FeatureApiHolder>
    ): FeatureHolderManager {
        return FeatureHolderManager(featureApiHolderMap)
    }
}
