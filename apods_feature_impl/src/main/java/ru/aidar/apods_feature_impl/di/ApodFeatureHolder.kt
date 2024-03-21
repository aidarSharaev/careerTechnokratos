package ru.aidar.apods_feature_impl.di

import ru.aidar.apods_feature_impl.ApodRouter
import ru.aidar.common.data.db.di.DbApi
import ru.aidar.common.di.FeatureApiHolder
import ru.aidar.common.di.FeatureContainer
import ru.aidar.common.di.scope.app.ApplicationScope
import javax.inject.Inject

@ApplicationScope
class ApodFeatureHolder
    @Inject
    constructor(
        featureContainer: FeatureContainer,
        private val apodRouter: ApodRouter,
    ) : FeatureApiHolder(featureContainer) {
        override fun initializeDependencies(): Any {
            val apodFeatureDependencies =
                DaggerApodFeatureComponent_ApodFeatureDependenciesComponent.builder()
                    .commonApi(commonApi())
                    .dbApi(getFeature(DbApi::class.java))
                    .build()
            return DaggerApodFeatureComponent.builder()
                .withDependencies(apodFeatureDependencies)
                .router(apodRouter)
                .build()
        }
    }
