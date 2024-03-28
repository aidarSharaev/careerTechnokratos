package ru.aidar.apa_feature_impl.di

import ru.aidar.apa_feature_impl.ApaRouter
import ru.aidar.common.di.FeatureApiHolder
import ru.aidar.common.di.FeatureContainer
import ru.aidar.common.di.scope.app.ApplicationScope
import javax.inject.Inject

@ApplicationScope
class ApaFeatureHolder
    @Inject
    constructor(
        featureContainer: FeatureContainer,
        private val router: ApaRouter,
    ) : FeatureApiHolder(featureContainer) {
        override fun initializeDependencies(): Any {
            val deps =
                DaggerApaFeatureComponent_ApaFeatureDependenciesComponent.builder()
                    .commonApi(commonApi())
                    .build()
            return DaggerApaFeatureComponent.builder()
                .router(router)
                .withDependencies(deps)
                .build()
        }
    }
