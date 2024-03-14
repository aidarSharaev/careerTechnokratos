package ru.aidar.careertechnokratos.di.app

import dagger.BindsInstance
import dagger.Component
import ru.aidar.careertechnokratos.GalaxyPulseApplication
import ru.aidar.careertechnokratos.di.deps.ComponentDependenciesModule
import ru.aidar.careertechnokratos.di.deps.ComponentHolderModule
// import ru.aidar.careertechnokratos.di.deps.ComponentHolderModule
import ru.aidar.careertechnokratos.di.main.MainDependencies
import ru.aidar.common.di.CommonApi
import ru.aidar.common.di.modules.CommonModule
import ru.aidar.common.di.modules.NetworkModule
import ru.aidar.common.di.scope.ApplicationScope

@Component(
    modules = [
        AppModule::class,
        CommonModule::class,
        NetworkModule::class,
        NavigationModule::class,
        FeatureManagerModule::class,
        ComponentDependenciesModule::class,
        ComponentHolderModule::class,
    ],
)
@ApplicationScope
interface AppComponent : MainDependencies, CommonApi {
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
