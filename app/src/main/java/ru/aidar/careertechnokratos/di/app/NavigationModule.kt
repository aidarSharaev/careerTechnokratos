package ru.aidar.careertechnokratos.di.app

import android.content.Context
import dagger.Module
import dagger.Provides
import ru.aidar.apa_feature_impl.ApaRouter
import ru.aidar.apods_feature_impl.ApodRouter
import ru.aidar.auth_feature_impl.AuthRouter
import ru.aidar.careertechnokratos.navigation.Navigator
import ru.aidar.cc_feature_impl.CcRouter
import ru.aidar.common.di.scope.app.ApplicationScope
import ru.aidar.menu_feature_impl.MenuRouter
import ru.aidar.so_feature_impl.SoRouter

@Module
class NavigationModule {
    @ApplicationScope
    @Provides
    fun provideNavigator(
        context: Context,
    ): Navigator = Navigator()

    @ApplicationScope
    @Provides
    fun provideMenuRouter(
        navigator: Navigator,
    ): MenuRouter = navigator

    @ApplicationScope
    @Provides
    fun provideAuthRouter(
        navigator: Navigator,
    ): AuthRouter = navigator

    @ApplicationScope
    @Provides
    fun provideApodRouter(
        navigator: Navigator,
    ): ApodRouter = navigator

    @ApplicationScope
    @Provides
    fun provideApaRouter(
        navigator: Navigator,
    ): ApaRouter = navigator

    @ApplicationScope
    @Provides
    fun provideCcRouter(
        navigator: Navigator,
    ): CcRouter = navigator

    @ApplicationScope
    @Provides
    fun provideSoRouter(
        navigator: Navigator,
    ): SoRouter = navigator
}
