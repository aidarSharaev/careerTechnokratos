package ru.aidar.menu_feature_impl.di

import dagger.Module
import dagger.Provides
import ru.aidar.common.di.scope.RegisteredFeatureScope
import ru.aidar.menu_feature_api.domain.MainMenuRepository
import ru.aidar.menu_feature_api.domain.MainMenuUseCases
import ru.aidar.menu_feature_impl.data.MainMenuRepositoryImpl

@Module
class MainMenuFeatureModule {
    @Provides
    @RegisteredFeatureScope
    fun provideMmRepository(mmRepository: MainMenuRepositoryImpl): MainMenuRepository = mmRepository

    @Provides
    @RegisteredFeatureScope
    fun provideMmUseCases(repository: MainMenuRepository): MainMenuUseCases {
        return MainMenuUseCases(repository)
    }
}
