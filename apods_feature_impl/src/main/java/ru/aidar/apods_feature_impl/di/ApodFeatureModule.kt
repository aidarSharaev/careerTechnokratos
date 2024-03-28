package ru.aidar.apods_feature_impl.di

import dagger.Module
import dagger.Provides
import ru.aidar.apods_feature_api.domain.interfaces.list.ApodListRepository
import ru.aidar.apods_feature_api.domain.interfaces.list.ApodListUseCases
import ru.aidar.apods_feature_api.domain.interfaces.picture.PictureRepository
import ru.aidar.apods_feature_api.domain.interfaces.picture.PictureUseCases
import ru.aidar.apods_feature_api.remote.NasaServiceApi
import ru.aidar.apods_feature_impl.data.repository.ApodListRepositoryImpl
import ru.aidar.apods_feature_impl.data.repository.PictureRepositoryImpl
import ru.aidar.common.data.network.NetworkApiCreator
import ru.aidar.common.di.scope.apod.ApodFeatureScope

@Module
class ApodFeatureModule {
    @Provides
    @ApodFeatureScope
    fun provideApodListRepository(repository: ApodListRepositoryImpl): ApodListRepository = repository

    @Provides
    @ApodFeatureScope
    fun provideApodListUseCases(repository: ApodListRepository): ApodListUseCases {
        return ApodListUseCases(
            repository = repository,
        )
    }

    @Provides
    @ApodFeatureScope
    fun providePictureRepository(repository: PictureRepositoryImpl): PictureRepository = repository

    @Provides
    @ApodFeatureScope
    fun providePictureUseCases(repository: PictureRepository): PictureUseCases {
        return PictureUseCases(
            repository = repository,
        )
    }

    @Provides
    @ApodFeatureScope
    fun provideNasaServiceApi(networkApiCreator: NetworkApiCreator): NasaServiceApi {
        return networkApiCreator.getNasaService(
            service = NasaServiceApi::class.java,
        )
    }
}
