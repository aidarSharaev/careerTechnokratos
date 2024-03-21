package ru.aidar.cc_feature_impl.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.flow.MutableStateFlow
import ru.aidar.cc_feature_api.domain.repository.CupidRepository
import ru.aidar.cc_feature_api.domain.repository.CupidUseCases
import ru.aidar.cc_feature_api.domain.wrapper.CupidState
import ru.aidar.cc_feature_api.domain.wrapper.CupidStateWrapper
import ru.aidar.cc_feature_impl.data.repository.CupidRepositoryImpl
import ru.aidar.cc_feature_impl.data.wrapper.CupidStateWrapperImpl
import ru.aidar.common.di.scope.cc.CcFeatureScope

@Module
class CcFeatureModule {
    @Provides
    @CcFeatureScope
    fun provideCupidRepository(
        repository: CupidRepositoryImpl
    ): CupidRepository = repository

    @Provides
    @CcFeatureScope
    fun provideCupidUseCases(
        repository: CupidRepository
    ): CupidUseCases {
        return CupidUseCases(repository = repository)
    }

    @Provides
    fun provideCupidState(

    ): MutableStateFlow<CupidState> =
        MutableStateFlow(CupidState())

    @Provides
    fun provideCupidStateWrapper(
        flow: MutableStateFlow<CupidState>
    ): CupidStateWrapper {
        return CupidStateWrapperImpl(flow = flow)
    }

    /*@Provides
    @CcFeatureScope
    fun provideNasaServiceApi(networkApiCreator: NetworkApiCreator): NasaServiceApi {
        return networkApiCreator.getNasaService(service = NasaServiceApi::class.java)
    }*/
}