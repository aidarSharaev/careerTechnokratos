package ru.aidar.menu_feature_impl.di

import dagger.BindsInstance
import dagger.Component
import ru.aidar.common.core.preferences.LocalManager
import ru.aidar.common.di.CommonApi
import ru.aidar.common.di.scope.MainMenuFeatureScope
import ru.aidar.menu_feature_api.di.MainMenuFeatureApi
import ru.aidar.menu_feature_impl.MenuRouter
import ru.aidar.menu_feature_impl.presentation.di.MainMenuComponent

@MainMenuFeatureScope
@Component(
    dependencies = [MainMenuFeatureDependencies::class],
    modules = [MainMenuFeatureModule::class],
)
interface MainMenuFeatureComponent : MainMenuFeatureApi {

    fun mmComponentFactory(): MainMenuComponent.Factory

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun router(menuRouter: MenuRouter): Builder

        fun withDependencies(deps: MainMenuFeatureDependencies): Builder

        fun build(): MainMenuFeatureComponent
    }

    @Component(dependencies = [CommonApi::class])
    interface MainMenuFeatureDependenciesComponent : MainMenuFeatureDependencies
}
