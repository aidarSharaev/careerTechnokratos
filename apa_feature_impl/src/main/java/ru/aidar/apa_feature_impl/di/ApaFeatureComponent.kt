package ru.aidar.apa_feature_impl.di

import dagger.BindsInstance
import dagger.Component
import ru.aidar.apa_feature_api.di.ApaFeatureApi
import ru.aidar.apa_feature_impl.ApaRouter
import ru.aidar.apa_feature_impl.presentation.detail.di.DetailComponent
import ru.aidar.apa_feature_impl.presentation.search.di.SearchComponent
import ru.aidar.common.di.CommonApi
import ru.aidar.common.di.scope.apa.ApaFeatureScope

@ApaFeatureScope
@Component(
    dependencies = [ApaFeatureDependencies::class],
    modules = [ApaFeatureModule::class],
)
interface ApaFeatureComponent : ApaFeatureApi {

    fun searchComponentFactory(): SearchComponent.Factory

    fun detailComponentFactory(): DetailComponent.Factory

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun router(apaRouter: ApaRouter): Builder

        fun withDependencies(deps: ApaFeatureDependencies): Builder

        fun build(): ApaFeatureComponent
    }

    @Component(dependencies = [CommonApi::class])
    interface ApaFeatureDependenciesComponent : ApaFeatureDependencies
}
