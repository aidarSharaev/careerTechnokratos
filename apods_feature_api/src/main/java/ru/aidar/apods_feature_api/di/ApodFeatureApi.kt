package ru.aidar.apods_feature_api.di

import ru.aidar.apods_feature_api.domain.interfaces.list.ApodListRepository
import ru.aidar.apods_feature_api.domain.interfaces.list.ApodListUseCases
import ru.aidar.apods_feature_api.domain.interfaces.picture.PictureRepository
import ru.aidar.apods_feature_api.domain.interfaces.picture.PictureUseCases

interface ApodFeatureApi {
    fun provideApodListRepository(): ApodListRepository

    fun provideApodListUseCases(): ApodListUseCases

    fun providePictureRepository(): PictureRepository

    fun providePictureUseCases(): PictureUseCases
}
