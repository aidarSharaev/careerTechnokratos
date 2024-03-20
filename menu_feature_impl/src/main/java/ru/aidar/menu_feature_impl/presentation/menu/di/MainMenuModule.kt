package ru.aidar.menu_feature_impl.presentation.menu.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.aidar.common.di.viewmodel.ViewModelKey
import ru.aidar.common.di.viewmodel.ViewModelModule
import ru.aidar.menu_feature_api.domain.interfaces.MainMenuUseCases
import ru.aidar.menu_feature_api.domain.wrappers.MainMenuStateWrapper
import ru.aidar.menu_feature_impl.MenuRouter
import ru.aidar.menu_feature_impl.presentation.menu.MainMenuViewModel

@Module(includes = [ViewModelModule::class])
class MainMenuModule {
    @Provides
    fun provideViewModelProvider(
        fragment: Fragment,
        factory: ViewModelProvider.Factory,
    ): MainMenuViewModel {
        return ViewModelProvider(fragment, factory)[MainMenuViewModel::class.java]
    }

    @Provides
    @IntoMap
    @ViewModelKey(MainMenuViewModel::class)
    fun provideViewModel(
        router: MenuRouter,
        mmUseCases: MainMenuUseCases,
        wrapper: MainMenuStateWrapper,
    ): ViewModel {
        return MainMenuViewModel(
            router = router,
            mmUseCases = mmUseCases,
            wrapper = wrapper,
        )
    }
}
