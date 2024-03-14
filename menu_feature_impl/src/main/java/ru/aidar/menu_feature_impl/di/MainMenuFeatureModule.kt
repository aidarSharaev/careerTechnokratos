package ru.aidar.menu_feature_impl.di

import dagger.Module
import dagger.Provides
import ru.aidar.common.di.scope.MainMenuFeatureScope
import ru.aidar.menu_feature_api.domain.MainMenuRepository
import ru.aidar.menu_feature_api.domain.MainMenuUseCases
import ru.aidar.menu_feature_impl.data.MainMenuRepositoryImpl

@Module
class MainMenuFeatureModule {

    @Provides
    @MainMenuFeatureScope
    fun provideMmRepository(mmRepository: MainMenuRepositoryImpl): MainMenuRepository = mmRepository

    @Provides
    @MainMenuFeatureScope
    fun provideMmUseCases(repository: MainMenuRepository): MainMenuUseCases {
        return MainMenuUseCases(repository)
    }
}
