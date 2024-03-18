package ru.aidar.auth_feature_impl.di

import dagger.Module
import dagger.Provides
import ru.aidar.auth_feature_api.domain.interfaces.CreateAccRepository
import ru.aidar.auth_feature_api.domain.interfaces.CreateAccUseCases
import ru.aidar.auth_feature_api.domain.interfaces.LoginRepository
import ru.aidar.auth_feature_api.domain.interfaces.LoginUseCases
import ru.aidar.auth_feature_impl.data.repository.CreateAccRepositoryImpl
import ru.aidar.auth_feature_impl.data.repository.LoginRepositoryImpl
import ru.aidar.common.di.scope.auth.AuthFeatureScope

@Module
class AuthFeatureModule {
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
}
