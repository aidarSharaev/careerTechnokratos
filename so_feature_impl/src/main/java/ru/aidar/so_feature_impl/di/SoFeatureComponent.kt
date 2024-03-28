package ru.aidar.so_feature_impl.di

import dagger.BindsInstance
import dagger.Component
import ru.aidar.common.di.CommonApi
import ru.aidar.common.di.scope.so.SoFeatureScope
import ru.aidar.so_feature_api.di.SoFeatureApi
import ru.aidar.so_feature_impl.SoRouter
import ru.aidar.so_feature_impl.presentation.blog.di.BlogComponent

@Component(
    dependencies = [SoFeatureDependencies::class],
    modules = [SoFeatureModule::class],
)
@SoFeatureScope
interface SoFeatureComponent : SoFeatureApi {
    fun blogComponentFactory(): BlogComponent.Factory
    // fun postComponentFactory(): PostComponent.Factory

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun router(authRouter: SoRouter): Builder

        fun withDependencies(deps: SoFeatureDependencies): Builder

        fun build(): SoFeatureComponent
    }

    @Component(dependencies = [CommonApi::class])
    interface SoFeatureDependenciesComponent : SoFeatureDependencies
}
