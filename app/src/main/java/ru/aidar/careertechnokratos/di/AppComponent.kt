package ru.aidar.careertechnokratos.di

import android.app.Application
import android.content.Context
import dagger.Component
import ru.aidar.careertechnokratos.remote.NasaRemoteDataSource

@Component(
    modules =
    [NetworkModule::class]
)
interface AppComponent {
    fun nasaRemoteDataSource(): NasaRemoteDataSource
}

val Context.appComponent: AppComponent
    get() = when (this){
        is MyApplication -> appComponent
        else -> this.applicationContext.appComponent
    }

class MyApplication : Application() {
    lateinit var appComponent : AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.create()
    }
}

