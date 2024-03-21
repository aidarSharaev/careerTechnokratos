package ru.aidar.so_feature_impl.di

import ru.aidar.common.di.FeatureApiHolder
import ru.aidar.common.di.FeatureContainer
import ru.aidar.common.di.scope.app.ApplicationScope
import ru.aidar.so_feature_impl.SoRouter
import javax.inject.Inject

@ApplicationScope
class SoFeatureHolder
@Inject
constructor(
    featureContainer: FeatureContainer,
    private val apodRouter: SoRouter,
) : FeatureApiHolder(featureContainer) {
    override fun initializeDependencies(): Any {

        val soFeatureDependencies =
            DaggerSoFeatureComponent_SoFeatureDependenciesComponent.builder()
                .commonApi(commonApi())
                .build()

        return DaggerSoFeatureComponent.builder()
            .router(apodRouter)
            .withDependencies(soFeatureDependencies)
            .build()
    }
}
