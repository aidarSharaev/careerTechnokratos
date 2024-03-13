package ru.aidar.careertechnokratos

import android.app.Application
import ru.aidar.careertechnokratos.di.app.AppComponent
import ru.aidar.careertechnokratos.di.ComponentDependenciesProvider
import javax.inject.Inject

class GalaxyPulseApplication : Application() {

    @Inject
    lateinit var dependencies: ComponentDependenciesProvider

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = AppComponent.init(this)
        appComponent.inject(this)
    }
}

