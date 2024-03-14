package ru.aidar.careertechnokratos.di.app

import dagger.BindsInstance
import dagger.Component
import ru.aidar.careertechnokratos.GalaxyPulseApplication
import ru.aidar.careertechnokratos.di.deps.ComponentDependenciesModule
import ru.aidar.careertechnokratos.di.deps.ComponentHolderModule
import ru.aidar.careertechnokratos.di.main.MainDependencies
import ru.aidar.common.di.CommonApi
import ru.aidar.common.di.modules.CommonModule
import ru.aidar.common.di.modules.NetworkModule

@Component(
    modules = [
        AppModule::class,
        CommonModule::class,
        NetworkModule::class,
        NavigationModule::class,
        FeatureManagerModule::class,
        ComponentHolderModule::class,
        ComponentDependenciesModule::class
        //ViewModelModule::class,
    ]
)
interface AppComponent : MainDependencies, CommonApi {

    companion object {

//        fun init(application: GalaxyPulseApplication): AppComponent {
//            return DaggerA
//                .builder()
//                .application(application = application)
//                .build()
//        }
    }

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: GalaxyPulseApplication): Builder

        fun build(): AppComponent
    }

    fun inject(app: GalaxyPulseApplication)
}
