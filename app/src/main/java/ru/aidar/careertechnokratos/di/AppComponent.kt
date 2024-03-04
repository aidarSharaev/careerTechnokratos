package ru.aidar.careertechnokratos.di

import android.app.Application
import dagger.Component
import ru.aidar.careertechnokratos.remote.NasaRemoteDataSource

@Component(
    modules =
    [NetworkModule::class, ViewModelModule::class]
)
interface AppComponent {
    fun nasaRemoteDataSource(): NasaRemoteDataSource
}

class GalaxyPulseApplication : Application() {
    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}

