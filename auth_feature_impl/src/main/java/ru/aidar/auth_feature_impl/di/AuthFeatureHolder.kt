package ru.aidar.auth_feature_impl.di

import ru.aidar.auth_feature_impl.AuthRouter
import ru.aidar.common.di.FeatureApiHolder
import ru.aidar.common.di.FeatureContainer
import ru.aidar.common.di.scope.app.ApplicationScope
import javax.inject.Inject

@ApplicationScope
class AuthFeatureHolder
    @Inject
    constructor(
        featureContainer: FeatureContainer,
        private val authRouter: AuthRouter,
    ) : FeatureApiHolder(featureContainer) {
        override fun initializeDependencies(): Any {
            val authFeatureDependencies =
                DaggerAuthFeatureComponent_AuthFeatureDependenciesComponent.builder()
                    .commonApi(commonApi())
                    .build()
            return DaggerAuthFeatureComponent.builder()
                .withDependencies(authFeatureDependencies)
                .router(authRouter)
                .build()
        }
    }
