package ru.aidar.careertechnokratos.di.main

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.aidar.careertechnokratos.MainViewModel
import ru.aidar.common.core.auth.FirebaseManager
import ru.aidar.common.di.viewmodel.ViewModelKey
import ru.aidar.common.di.viewmodel.ViewModelModule

@Module(includes = [ViewModelModule::class])
class MainModule {
    @Provides
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun provideViewModel(firebaseManager: FirebaseManager): ViewModel {
        return MainViewModel(firebaseManager = firebaseManager)
    }

    @Provides
    fun provideViewModelProvider(
        activity: AppCompatActivity,
        viewModelFactory: ViewModelProvider.Factory,
    ): MainViewModel {
        return ViewModelProvider(activity, viewModelFactory)[MainViewModel::class.java]
    }
}
