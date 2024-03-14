package ru.aidar.careertechnokratos

import android.app.Application
import ru.aidar.careertechnokratos.di.app.AppComponent
import ru.aidar.careertechnokratos.di.deps.ComponentDependenciesProvider
import ru.aidar.careertechnokratos.di.deps.FeatureHolderManager
import ru.aidar.common.di.CommonApi
import ru.aidar.common.di.FeatureContainer
import javax.inject.Inject

class GalaxyPulseApplication : Application(), FeatureContainer {
    @Inject
    lateinit var featureHolderManager: FeatureHolderManager

    @Inject
    lateinit var dependencies: ComponentDependenciesProvider

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = AppComponent.init(this)
        appComponent.inject(this)
    }

    override fun <T> getFeature(key: Class<*>): T {
        return featureHolderManager.getFeature<T>(key)!!
    }

    override fun releaseFeature(key: Class<*>) {
        featureHolderManager.releaseFeature(key)
    }

    override fun commonApi(): CommonApi {
        return appComponent
    }
}
