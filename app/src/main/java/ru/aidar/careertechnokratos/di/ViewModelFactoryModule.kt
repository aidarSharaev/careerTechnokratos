package ru.aidar.careertechnokratos.di

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelFactoryModule {

    @Binds
    abstract fun bindsViewModelFactory(factorY: GpDaggerViewModelFactory): ViewModelProvider.Factory


}

