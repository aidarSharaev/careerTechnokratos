package ru.aidar.cc_feature_impl.di

import ru.aidar.cc_feature_impl.CcRouter
import ru.aidar.common.data.db.di.DbApi
import ru.aidar.common.di.FeatureApiHolder
import ru.aidar.common.di.FeatureContainer
import ru.aidar.common.di.scope.app.ApplicationScope
import javax.inject.Inject

@ApplicationScope
class CcFeatureHolder
@Inject
constructor(
    featureContainer: FeatureContainer,
    private val ccRouter: CcRouter,
) : FeatureApiHolder(featureContainer) {
    override fun initializeDependencies(): Any {

        /*val apodFeatureDependencies =
            DaggerApodFeatureComponent_ApodFeatureDependenciesComponent.builder()
                .commonApi(commonApi())
                .dbApi(getFeature(DbApi::class.java))
                .build()

        return DaggerCcFeatureComponent.builder()
            .router(ccRouter)
            .build()*/
        return "aa"
    }
}
