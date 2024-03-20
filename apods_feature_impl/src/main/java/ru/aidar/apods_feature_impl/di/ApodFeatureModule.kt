package ru.aidar.apods_feature_impl.di

import dagger.Module
import dagger.Provides
import ru.aidar.apods_feature_api.domain.interfaces.ApodListRepository
import ru.aidar.apods_feature_api.domain.interfaces.ApodListUseCases
import ru.aidar.apods_feature_impl.data.repository.ApodListRepositoryImpl
import ru.aidar.apods_feature_impl.remote.api.NasaServiceApi
import ru.aidar.common.data.network.NetworkApiCreator
import ru.aidar.common.di.scope.apod.ApodFeatureScope

@Module
class ApodFeatureModule {
    @Provides
    @ApodFeatureScope
    fun provideApodListRepository(apodListRepository: ApodListRepositoryImpl): ApodListRepository = apodListRepository

    @Provides
    @ApodFeatureScope
    fun provideApodListUseCases(repository: ApodListRepository): ApodListUseCases {
        return ApodListUseCases(apodListRepository = repository)
    }

    @Provides
    @ApodFeatureScope
    fun provideNasaServiceApi(networkApiCreator: NetworkApiCreator): NasaServiceApi {
        return networkApiCreator.getNasaService(service = NasaServiceApi::class.java)
    }
}
