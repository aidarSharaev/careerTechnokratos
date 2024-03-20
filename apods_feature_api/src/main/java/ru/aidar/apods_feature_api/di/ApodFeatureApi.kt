package ru.aidar.apods_feature_api.di

import ru.aidar.apods_feature_api.domain.interfaces.ApodListRepository
import ru.aidar.apods_feature_api.domain.interfaces.ApodListUseCases

interface ApodFeatureApi {
    fun provideApodListRepository(): ApodListRepository

    fun provideApodListUseCases(): ApodListUseCases
}
