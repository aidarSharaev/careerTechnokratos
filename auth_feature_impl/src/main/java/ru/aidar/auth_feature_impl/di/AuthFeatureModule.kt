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
import ru.aidar.auth_feature_impl.data.wrapper.CreateAccStateWrapperImpl
import ru.aidar.auth_feature_impl.data.wrapper.LoginStateWrapperImpl
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
    fun provideLoginRepository(repository: LoginRepositoryImpl): LoginRepository {
        return repository
    }

    @Provides
    @AuthFeatureScope
    fun provideCreateRepository(repository: CreateAccRepositoryImpl): CreateAccRepository {
        return repository
    }

    @Provides
    @AuthFeatureScope
    fun provideLoginUseCases(repository: LoginRepository): LoginUseCases {
        return LoginUseCases(repository = repository)
    }

    @Provides
    @AuthFeatureScope
    fun provideCreateUseCases(repository: CreateAccRepository): CreateAccUseCases {
        return CreateAccUseCases(repository = repository)
    }

    @Provides
    fun provideLoginFlow(): MutableStateFlow<LoginState> {
        return MutableStateFlow(LoginState())
    }

    @Provides
    fun provideLoginWrapper(flow: MutableStateFlow<LoginState>): LoginStateWrapper {
        return LoginStateWrapperImpl(flow = flow)
    }

    @Provides
    fun provideCreateFlow(): MutableStateFlow<CreateAccState> {
        return MutableStateFlow(CreateAccState())
    }

    @Provides
    fun provideCreateWrapper(flow: MutableStateFlow<CreateAccState>): CreateAccStateWrapper {
        return CreateAccStateWrapperImpl(flow = flow)
    }
}
