package ru.aidar.careertechnokratos.di.app

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.aidar.careertechnokratos.GalaxyPulseApplication
import ru.aidar.common.di.scope.ApplicationScope

@Module
class AppModule {

    @ApplicationScope
    @Provides
    fun providesContext(application: GalaxyPulseApplication): Context {
        return application
    }
}