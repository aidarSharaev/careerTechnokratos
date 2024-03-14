package ru.aidar.careertechnokratos.di.app

import dagger.Module
import dagger.Provides
import ru.aidar.careertechnokratos.navigation.Navigator
import ru.aidar.common.di.scope.ApplicationScope
import ru.aidar.menu_feature_impl.MenuRouter

@Module
class NavigationModule {
    @ApplicationScope
    @Provides
    fun provideNavigator(): Navigator = Navigator()

    @ApplicationScope
    @Provides
    fun provideGpRouter(navigator: Navigator): MenuRouter = navigator
}
