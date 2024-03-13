package ru.aidar.common.di.viewmodel

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(
        factory: ViewModelProvider.Factory
    ): ViewModelProvider.Factory
}