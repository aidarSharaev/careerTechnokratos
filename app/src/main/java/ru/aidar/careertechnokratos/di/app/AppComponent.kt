package ru.aidar.careertechnokratos.di.app

import dagger.BindsInstance
import dagger.Component
import ru.aidar.careertechnokratos.GalaxyPulseApplication
import ru.aidar.careertechnokratos.di.main.MainDependencies

@Component(
    modules = [
        AppModule::class,
        NavigationModule::class,
        //NetworkModule::class,
        //ViewModelModule::class,
    ]
)
interface AppComponent: MainDependencies {
    companion object {
        fun init(application: GalaxyPulseApplication): AppComponent {
            return DaggerAppComponent
                .builder()
                .application(application = application)
                .build()
        }
    }

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: GalaxyPulseApplication): Builder

        fun build(): AppComponent
    }

    fun inject(app: GalaxyPulseApplication)

}
