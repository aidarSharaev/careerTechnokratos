package ru.aidar.apa_feature_impl.presentation.search.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.aidar.apa_feature_api.domain.interfaces.SearchUseCases
import ru.aidar.apa_feature_api.domain.wrappers.SearchStateWrapper
import ru.aidar.apa_feature_impl.ApaRouter
import ru.aidar.apa_feature_impl.presentation.search.ApaSearchViewModel
import ru.aidar.common.di.viewmodel.ViewModelKey
import ru.aidar.common.di.viewmodel.ViewModelModule
import ru.aidar.common.monitor.NetworkMonitor

@Module(includes = [ViewModelModule::class])
class SearchModule {
    @Provides
    fun provideViewModelProvider(
        fragment: Fragment,
        factory: ViewModelProvider.Factory,
    ): ApaSearchViewModel {
        return ViewModelProvider(fragment, factory)[ApaSearchViewModel::class.java]
    }

    @Provides
    @IntoMap
    @ViewModelKey(ApaSearchViewModel::class)
    fun provideViewModel(
        router: ApaRouter,
        useCases: SearchUseCases,
        wrapper: SearchStateWrapper,
        monitor: NetworkMonitor,
    ): ViewModel {
        return ApaSearchViewModel(
            router = router,
            useCases = useCases,
            wrapper = wrapper,
            monitor = monitor,
        )
    }
}
