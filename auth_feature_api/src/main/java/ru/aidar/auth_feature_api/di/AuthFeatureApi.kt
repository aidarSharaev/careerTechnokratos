package ru.aidar.auth_feature_api.di

import ru.aidar.auth_feature_api.domain.interfaces.CreateAccRepository
import ru.aidar.auth_feature_api.domain.interfaces.CreateAccUseCases
import ru.aidar.auth_feature_api.domain.interfaces.LoginRepository
import ru.aidar.auth_feature_api.domain.interfaces.LoginUseCases

interface AuthFeatureApi {
    fun provideLoginRepository(): LoginRepository

    fun provideCreateAccRepository(): CreateAccRepository

    fun provideLoginUseCases(): LoginUseCases

    fun provideCreateAccUseCases(): CreateAccUseCases

    // fun provideLoginWrapper(): LoginStateWrapper
}
