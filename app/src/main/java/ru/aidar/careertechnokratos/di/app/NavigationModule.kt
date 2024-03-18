package ru.aidar.careertechnokratos.di.app

import dagger.Module
import dagger.Provides
import ru.aidar.auth_feature_impl.AuthRouter
import ru.aidar.careertechnokratos.navigation.Navigator
import ru.aidar.common.di.scope.app.ApplicationScope
import ru.aidar.menu_feature_impl.MenuRouter

@Module
class NavigationModule {
    @ApplicationScope
    @Provides
    fun provideNavigator(): Navigator = Navigator()

    @ApplicationScope
    @Provides
    fun provideMenuRouter(navigator: Navigator): MenuRouter = navigator

    @ApplicationScope
    @Provides
    fun provideAuthRouter(navigator: Navigator): AuthRouter = navigator
}
