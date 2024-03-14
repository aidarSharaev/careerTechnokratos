package ru.aidar.careertechnokratos.di.deps

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap
import ru.aidar.careertechnokratos.di.app.AppComponent
import ru.aidar.careertechnokratos.di.main.MainDependencies

@Module
interface ComponentDependenciesModule {
    @Binds
    @IntoMap
    @ComponentDependenciesKey(MainDependencies::class)
    fun provideMainDependencies(component: AppComponent): ComponentDependencies
}
