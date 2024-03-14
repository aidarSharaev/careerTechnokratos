package ru.aidar.menu_feature_impl.di

import dagger.Component
import ru.aidar.common.di.scope.MainMenuScope

@MainMenuScope
@Component(
    dependencies = [MainMenuFeatureDependencies::class],
    modules = [MainMenuFeatureModule::class]
)
interface MenuFeatureComponent : MainMenuFeatureApi {

}