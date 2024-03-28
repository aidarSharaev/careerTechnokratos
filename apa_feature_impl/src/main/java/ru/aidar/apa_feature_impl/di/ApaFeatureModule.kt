package ru.aidar.apa_feature_impl.di

import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import ru.aidar.apa_feature_api.domain.interfaces.DetailRepository
import ru.aidar.apa_feature_api.domain.interfaces.DetailUseCases
import ru.aidar.apa_feature_api.domain.interfaces.SearchRepository
import ru.aidar.apa_feature_api.domain.interfaces.SearchUseCases
import ru.aidar.apa_feature_api.domain.wrappers.DetailState
import ru.aidar.apa_feature_api.domain.wrappers.DetailStateWrapper
import ru.aidar.apa_feature_api.domain.wrappers.SearchState
import ru.aidar.apa_feature_api.domain.wrappers.SearchStateWrapper
import ru.aidar.apa_feature_api.remote.SolarieServiceApi
import ru.aidar.apa_feature_impl.data.repository.DetailRepositoryImpl
import ru.aidar.apa_feature_impl.data.repository.SearchRepositoryImpl
import ru.aidar.apa_feature_impl.data.wrapper.DetailStateWrapperImpl
import ru.aidar.apa_feature_impl.data.wrapper.SearchStateWrapperImpl
import ru.aidar.common.data.network.NetworkApiCreator
import ru.aidar.common.di.scope.apa.ApaFeatureScope

@Module
class ApaFeatureModule {
    @Provides
    fun provideSearchState(): MutableStateFlow<SearchState> = MutableStateFlow(SearchState())

    @Provides
    fun provideDetailState(): MutableStateFlow<DetailState> = MutableStateFlow(DetailState())

    @Provides
    fun provideDetailStateWrapper(flow: MutableStateFlow<DetailState>): DetailStateWrapper = DetailStateWrapperImpl(flow = flow)

    @Provides
    fun provideSearchStateWrapper(flow: MutableStateFlow<SearchState>): SearchStateWrapper = SearchStateWrapperImpl(flow = flow)

    @Provides
    @ApaFeatureScope
    fun provideSearchRepository(repository: SearchRepositoryImpl): SearchRepository = repository

    @Provides
    @ApaFeatureScope
    fun provideDetailRepository(repository: DetailRepositoryImpl): DetailRepository = repository

    @Provides
    fun provideIODispatcher(): CoroutineDispatcher {
        return Dispatchers.IO
    }

    @Provides
    @ApaFeatureScope
    fun provideSearchUseCases(
        repository: SearchRepository,
        ioDispatcher: CoroutineDispatcher,
    ): SearchUseCases = SearchUseCases(repository = repository, ioDispatcher = ioDispatcher)

    @Provides
    @ApaFeatureScope
    fun provideDetailUseCases(repository: DetailRepository): DetailUseCases = DetailUseCases(repository = repository)

    @Provides
    @ApaFeatureScope
    fun provideSolarieServiceApi(networkApiCreator: NetworkApiCreator): SolarieServiceApi {
        return networkApiCreator.getSolarieService(
            service = SolarieServiceApi::class.java,
        )
    }
}
