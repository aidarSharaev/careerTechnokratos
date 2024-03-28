package ru.aidar.apods_feature_impl.presentation.picture.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.aidar.apods_feature_api.domain.interfaces.picture.PictureUseCases
import ru.aidar.apods_feature_impl.ApodRouter
import ru.aidar.apods_feature_impl.presentation.picture.PictureViewModel
import ru.aidar.common.di.viewmodel.ViewModelKey
import ru.aidar.common.di.viewmodel.ViewModelModule

@Module(includes = [ViewModelModule::class])
class PictureModule {
    @Provides
    fun provideViewModelProvider(
        fragment: Fragment,
        factory: ViewModelProvider.Factory,
    ): PictureViewModel {
        return ViewModelProvider(fragment, factory)[PictureViewModel::class.java]
    }

    @Provides
    @IntoMap
    @ViewModelKey(PictureViewModel::class)
    fun provideViewModel(
        router: ApodRouter,
        useCases: PictureUseCases,
    ): ViewModel {
        return PictureViewModel(router = router, useCases = useCases)
    }
}
