package ru.aidar.apods_feature_impl.presentation.list.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.aidar.apods_feature_api.domain.interfaces.ApodListUseCases
import ru.aidar.apods_feature_impl.ApodRouter
import ru.aidar.apods_feature_impl.presentation.list.ApodListViewModel
import ru.aidar.common.di.viewmodel.ViewModelKey
import ru.aidar.common.di.viewmodel.ViewModelModule

@Module(includes = [ViewModelModule::class])
class ApodListModule {
    @Provides
    fun provideViewModelProvider(
        fragment: Fragment,
        factory: ViewModelProvider.Factory,
    ): ApodListViewModel {
        return ViewModelProvider(fragment, factory)[ApodListViewModel::class.java]
    }

    @Provides
    @IntoMap
    @ViewModelKey(ApodListViewModel::class)
    fun provideViewModel(
        router: ApodRouter,
        useCases: ApodListUseCases,
    ): ViewModel {
        return ApodListViewModel(router = router, useCases = useCases)
    }
}
