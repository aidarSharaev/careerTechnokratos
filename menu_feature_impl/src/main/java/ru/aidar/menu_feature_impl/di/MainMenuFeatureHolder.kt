package ru.aidar.menu_feature_impl.di

import ru.aidar.common.di.FeatureApiHolder
import ru.aidar.common.di.FeatureContainer
import ru.aidar.common.di.scope.app.ApplicationScope
import ru.aidar.menu_feature_impl.MenuRouter
import javax.inject.Inject

@ApplicationScope
class MainMenuFeatureHolder
    @Inject
    constructor(
        featureContainer: FeatureContainer,
        private val menuRouter: MenuRouter,
    ) : FeatureApiHolder(featureContainer) {
        override fun initializeDependencies(): Any {
            val mmFeatureDependencies =
                DaggerMainMenuFeatureComponent_MainMenuFeatureDependenciesComponent.builder()
                    .commonApi(commonApi())
                    .build()
            return DaggerMainMenuFeatureComponent.builder()
                .withDependencies(mmFeatureDependencies)
                .router(menuRouter)
                .build()
        }
    }
