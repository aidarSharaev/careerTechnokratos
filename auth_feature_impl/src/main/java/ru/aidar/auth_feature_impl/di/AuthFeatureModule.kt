package ru.aidar.auth_feature_impl.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import ru.aidar.auth_feature_api.domain.interfaces.CreateAccRepository
import ru.aidar.auth_feature_api.domain.interfaces.CreateAccUseCases
import ru.aidar.auth_feature_api.domain.interfaces.LoginRepository
import ru.aidar.auth_feature_api.domain.interfaces.LoginUseCases
import ru.aidar.auth_feature_api.domain.wrappers.CreateAccState
import ru.aidar.auth_feature_api.domain.wrappers.CreateAccStateWrapper
import ru.aidar.auth_feature_api.domain.wrappers.LoginState
import ru.aidar.auth_feature_api.domain.wrappers.LoginStateWrapper
import ru.aidar.auth_feature_impl.data.repository.CreateAccRepositoryImpl
import ru.aidar.auth_feature_impl.data.repository.LoginRepositoryImpl
import ru.aidar.auth_feature_impl.presentation.create.wrapper.CreateAccStateWrapperImpl
import ru.aidar.auth_feature_impl.presentation.login.wrapper.LoginStateWrapperImpl
import ru.aidar.common.di.scope.auth.AuthFeatureScope

@Module
class AuthFeatureModule {
    @Provides
    @AuthFeatureScope
    fun providesIODispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    @Provides
    @AuthFeatureScope
    fun provideLoginRepository(loginRepository: LoginRepositoryImpl): LoginRepository {
        return loginRepository
    }

    @Provides
    @AuthFeatureScope
    fun provideCreateRepository(createAccRepository: CreateAccRepositoryImpl): CreateAccRepository {
        return createAccRepository
    }

    @Provides
    @AuthFeatureScope
    fun provideLoginUseCases(loginRepository: LoginRepository): LoginUseCases {
        return LoginUseCases(loginRepository = loginRepository)
    }

    @Provides
    @AuthFeatureScope
    fun provideCreateUseCases(createAccRepository: CreateAccRepository): CreateAccUseCases {
        return CreateAccUseCases(createAccRepository = createAccRepository)
    }

    @Provides
    @AuthFeatureScope
    fun provideLoginFlow(): MutableStateFlow<LoginState> {
        return MutableStateFlow(LoginState())
    }

    @Provides
    @AuthFeatureScope
    fun provideLoginWrapper(flow: MutableStateFlow<LoginState>): LoginStateWrapper {
        return LoginStateWrapperImpl(flow = flow)
    }

    @Provides
    @AuthFeatureScope
    fun provideCreateFlow(): MutableStateFlow<CreateAccState> {
        return MutableStateFlow(CreateAccState())
    }

    @Provides
    @AuthFeatureScope
    fun provideCreateWrapper(flow: MutableStateFlow<CreateAccState>): CreateAccStateWrapper {
        return CreateAccStateWrapperImpl(flow = flow)
    }
}
