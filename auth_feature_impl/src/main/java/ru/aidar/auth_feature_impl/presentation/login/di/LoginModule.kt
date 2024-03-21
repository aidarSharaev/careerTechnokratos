package ru.aidar.auth_feature_impl.presentation.login.di

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ru.aidar.auth_feature_api.domain.interfaces.LoginUseCases
import ru.aidar.auth_feature_api.domain.wrappers.LoginStateWrapper
import ru.aidar.auth_feature_impl.AuthRouter
import ru.aidar.auth_feature_impl.presentation.login.LoginViewModel
import ru.aidar.common.di.viewmodel.ViewModelKey
import ru.aidar.common.di.viewmodel.ViewModelModule

@Module(includes = [ViewModelModule::class])
class LoginModule {
    @Provides
    fun provideViewModelProvider(
        fragment: Fragment,
        factory: ViewModelProvider.Factory,
    ): LoginViewModel {
        return ViewModelProvider(fragment, factory)[LoginViewModel::class.java]
    }

    @Provides
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    fun provideViewModel(
        router: AuthRouter,
        useCases: LoginUseCases,
        wrapper: LoginStateWrapper,
    ): ViewModel {
        return LoginViewModel(router = router, useCases = useCases, wrapper = wrapper)
    }
}
