package ru.aidar.cc_feature_impl.presentation.cupid.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.aidar.cc_feature_api.domain.repository.CupidUseCases
import ru.aidar.cc_feature_impl.CcRouter
import ru.aidar.cc_feature_impl.presentation.cupid.CupidViewModel
import ru.aidar.common.di.viewmodel.ViewModelKey
import ru.aidar.common.di.viewmodel.ViewModelModule

@Module(includes = [ViewModelModule::class])
class CupidModule {
    @Provides
    fun provideViewModelProvider(
        fragment: Fragment,
        factory: ViewModelProvider.Factory,
    ): CupidViewModel {
        return ViewModelProvider(fragment, factory)[CupidViewModel::class.java]
    }

    @Provides
    @IntoMap
    @ViewModelKey(CupidViewModel::class)
    fun provideViewModel(
        router: CcRouter,
        useCases: CupidUseCases,
    ): ViewModel {
        return CupidViewModel(router = router, useCases = useCases)
    }
}
