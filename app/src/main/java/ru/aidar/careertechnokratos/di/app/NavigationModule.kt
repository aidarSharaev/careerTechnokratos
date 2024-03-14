package ru.aidar.careertechnokratos.di.app

import dagger.Module
import dagger.Provides
import ru.aidar.careertechnokratos.navigation.AppRouter
import ru.aidar.careertechnokratos.navigation.Navigator
import ru.aidar.common.di.scope.ApplicationScope

@Module
class NavigationModule {
    @ApplicationScope
    @Provides
    fun provideNavigator(): Navigator = Navigator()

    @ApplicationScope
    @Provides
    fun provideGpRouter(navigator: Navigator): AppRouter = navigator
}
