package ru.aidar.careertechnokratos.di.main

import androidx.appcompat.app.AppCompatActivity
import dagger.BindsInstance
import dagger.Component
import ru.aidar.careertechnokratos.MainActivity
import ru.aidar.common.di.scope.MainMenuFeatureScope

@Component(
    dependencies = [MainDependencies::class],
    modules = [MainModule::class],
)
@MainMenuFeatureScope
interface MainComponent {
    companion object {
        fun init(
            activity: AppCompatActivity,
            deps: MainDependencies,
        ): MainComponent {
            return DaggerMainComponent.factory().create(activity, deps)
        }
    }

    @Component.Factory
    interface Factory {
        fun create(
            @BindsInstance activity: AppCompatActivity,
            deps: MainDependencies,
        ): MainComponent
    }

    fun inject(mainActivity: MainActivity)
}
