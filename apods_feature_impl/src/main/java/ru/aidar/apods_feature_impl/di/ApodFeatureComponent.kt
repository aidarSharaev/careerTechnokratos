package ru.aidar.apods_feature_impl.di

import dagger.BindsInstance
import dagger.Component
import ru.aidar.apods_feature_impl.ApodRouter
import ru.aidar.common.di.CommonApi
import ru.aidar.common.di.scope.auth.AuthFeatureScope

@AuthFeatureScope
@Component(
    dependencies = [ApodFeatureDependencies::class],
    modules = [ApodFeatureModule::class],
)
interface ApodFeatureComponent : ApodFeatureApi {
    fun apodListComponentFactory(): ApodListComponent.Factory

    fun apodDetailAccComponentFactory(): ApodDetailComponent.Factory

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun router(authRouter: ApodRouter): Builder

        fun withDependencies(deps: ApodFeatureDependencies): Builder

        fun build(): ApodFeatureComponent
    }

    @Component(dependencies = [CommonApi::class])
    interface ApodFeatureDependenciesComponent : ApodFeatureDependencies
}
