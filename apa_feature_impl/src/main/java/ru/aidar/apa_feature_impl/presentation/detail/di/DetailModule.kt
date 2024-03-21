package ru.aidar.apa_feature_impl.presentation.detail.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.aidar.apa_feature_api.domain.interfaces.DetailUseCases
import ru.aidar.apa_feature_api.domain.wrappers.DetailStateWrapper
import ru.aidar.apa_feature_impl.ApaRouter
import ru.aidar.apa_feature_impl.presentation.detail.ApaDetailViewModel
import ru.aidar.common.di.viewmodel.ViewModelKey
import ru.aidar.common.di.viewmodel.ViewModelModule

@Module(includes = [ViewModelModule::class])
class DetailModule {
    @Provides
    fun provideViewModelProvider(
        fragment: Fragment,
        factory: ViewModelProvider.Factory,
    ): ApaDetailViewModel {
        return ViewModelProvider(fragment, factory)[ApaDetailViewModel::class.java]
    }

    @Provides
    @IntoMap
    @ViewModelKey(ApaDetailViewModel::class)
    fun provideViewModel(
        router: ApaRouter,
        useCases: DetailUseCases,
        wrapper: DetailStateWrapper,
    ): ViewModel {
        return ApaDetailViewModel(
            router = router,
            useCases = useCases,
            wrapper = wrapper,
        )
    }
}
