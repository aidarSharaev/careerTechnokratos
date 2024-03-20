package ru.aidar.menu_feature_impl.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import ru.aidar.common.di.scope.RegisteredFeatureScope
import ru.aidar.menu_feature_api.domain.interfaces.MainMenuRepository
import ru.aidar.menu_feature_api.domain.interfaces.MainMenuUseCases
import ru.aidar.menu_feature_api.domain.wrappers.MainMenuState
import ru.aidar.menu_feature_api.domain.wrappers.MainMenuStateWrapper
import ru.aidar.menu_feature_impl.data.repository.MainMenuRepositoryImpl
import ru.aidar.menu_feature_impl.presentation.menu.wrapper.MainMenuStateWrapperImpl

@Module
class MainMenuFeatureModule {

    @Provides
    @RegisteredFeatureScope
    fun provideMmRepository(mmRepository: MainMenuRepositoryImpl): MainMenuRepository = mmRepository

    @Provides
    @RegisteredFeatureScope
    fun provideMmUseCases(repository: MainMenuRepository): MainMenuUseCases {
        return MainMenuUseCases(repository = repository)
    }

    @Provides
    fun provideMainMenuFlow(): MutableStateFlow<MainMenuState> {
        return MutableStateFlow(MainMenuState())
    }

    @Provides
    fun provideCreateWrapper(flow: MutableStateFlow<MainMenuState>): MainMenuStateWrapper {
        return MainMenuStateWrapperImpl(flow = flow)
    }
}
