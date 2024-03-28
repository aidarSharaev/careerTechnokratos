package ru.aidar.cc_feature_impl.di

import dagger.BindsInstance
import dagger.Component
import ru.aidar.cc_feature_api.di.CcFeatureApi
import ru.aidar.cc_feature_impl.CcRouter
import ru.aidar.cc_feature_impl.presentation.chat.di.ChatComponent
import ru.aidar.common.di.CommonApi
import ru.aidar.common.di.scope.cc.CcFeatureScope

@Component(
    dependencies = [CcFeatureDependencies::class],
    modules = [CcFeatureModule::class],
)
@CcFeatureScope
interface CcFeatureComponent : CcFeatureApi {
    fun chatComponentFactory(): ChatComponent.Factory

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun router(ccRouter: CcRouter): Builder

        fun withDependencies(deps: CcFeatureDependencies): Builder

        fun build(): CcFeatureComponent
    }

    @Component(dependencies = [CommonApi::class])
    interface СompatibilityFeatureDependenciesComponent : CcFeatureDependencies
}
