package ru.aidar.auth_feature_impl.di

import dagger.BindsInstance
import dagger.Component
import ru.aidar.auth_feature_api.di.AuthFeatureApi
import ru.aidar.auth_feature_impl.AuthRouter
import ru.aidar.auth_feature_impl.presentation.create.di.CreateComponent
import ru.aidar.auth_feature_impl.presentation.login.di.LoginComponent
import ru.aidar.common.di.CommonApi
import ru.aidar.common.di.scope.auth.AuthFeatureScope

@AuthFeatureScope
@Component(
    dependencies = [AuthFeatureDependencies::class],
    modules = [AuthFeatureModule::class],
)
interface AuthFeatureComponent : AuthFeatureApi {
    fun loginComponentFactory(): LoginComponent.Factory

    fun createAccComponentFactory(): CreateComponent.Factory

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun router(authRouter: AuthRouter): Builder

        fun withDependencies(deps: AuthFeatureDependencies): Builder

        fun build(): AuthFeatureComponent
    }

    @Component(dependencies = [CommonApi::class])
    interface AuthFeatureDependenciesComponent : AuthFeatureDependencies
}
