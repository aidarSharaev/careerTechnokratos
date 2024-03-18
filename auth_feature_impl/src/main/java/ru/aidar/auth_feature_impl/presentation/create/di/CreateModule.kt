package ru.aidar.auth_feature_impl.presentation.create.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.aidar.auth_feature_api.domain.interfaces.CreateAccUseCases
import ru.aidar.auth_feature_api.domain.wrappers.CreateAccStateWrapper
import ru.aidar.auth_feature_impl.AuthRouter
import ru.aidar.auth_feature_impl.presentation.create.CreateAccountViewModel
import ru.aidar.common.di.viewmodel.ViewModelKey
import ru.aidar.common.di.viewmodel.ViewModelModule

@Module(includes = [ViewModelModule::class])
class CreateModule {
    @Provides
    fun provideViewModelProvider(
        fragment: Fragment,
        factory: ViewModelProvider.Factory,
    ): CreateAccountViewModel {
        return ViewModelProvider(fragment, factory)[CreateAccountViewModel::class.java]
    }

    @Provides
    @IntoMap
    @ViewModelKey(CreateAccountViewModel::class)
    fun provideViewModel(
        router: AuthRouter,
        createAccUseCases: CreateAccUseCases,
        wrapper: CreateAccStateWrapper,
    ): ViewModel {
        return CreateAccountViewModel(
            router = router,
            createAccUseCases = createAccUseCases,
            wrapper = wrapper,
        )
    }
}
