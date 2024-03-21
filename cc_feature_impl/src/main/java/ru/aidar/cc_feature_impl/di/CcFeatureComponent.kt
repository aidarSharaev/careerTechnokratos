package ru.aidar.cc_feature_impl.di

import dagger.BindsInstance
import dagger.Component
import ru.aidar.cc_feature_api.di.CcFeatureApi
import ru.aidar.cc_feature_impl.CcRouter
import ru.aidar.cc_feature_impl.presentation.cupid.di.CupidComponent
import ru.aidar.common.di.scope.cc.CcFeatureScope

@Component(
    //dependencies = [CcFeatureDependencies::class],
    modules = [CcFeatureModule::class]
)
@CcFeatureScope
interface CcFeatureComponent : CcFeatureApi {

    fun cupidComponentFactory(): CupidComponent.Factory

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun router(ccRouter: CcRouter): Builder

        // fun withDependencies(deps: CcFeatureDependencies): Builder

        fun build(): CcFeatureComponent
    }
}