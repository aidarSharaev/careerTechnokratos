package ru.aidar.apods_feature_impl.data.repository

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.aidar.apods_feature_api.domain.interfaces.list.ApodListRepository
import ru.aidar.apods_feature_api.domain.model.ApodLocal
import ru.aidar.apods_feature_api.remote.NasaServiceApi
import ru.aidar.apods_feature_impl.data.mapper.ApodMappers
import ru.aidar.apods_feature_impl.remote.mediator.ApodRemoteMediator
import ru.aidar.common.data.db.local.GalaxyPulseDatabase
import ru.aidar.common.utils.Dimens.APOD_INITIAL_SIZE
import ru.aidar.common.utils.Dimens.APOD_PAGE_SIZE
import ru.aidar.common.utils.Dimens.APOD_PREFETCH_DISTANCE
import javax.inject.Inject

class ApodListRepositoryImpl
    @Inject
    constructor(
        private val galaxyPulseDatabase: GalaxyPulseDatabase,
        private val nasaServiceApi: NasaServiceApi,
        private val mapper: ApodMappers,
    ) : ApodListRepository {
        @OptIn(ExperimentalPagingApi::class)
        override fun getPictures(): Flow<PagingData<ApodLocal>> =
            Pager(
                config =
                    PagingConfig(
                        pageSize = APOD_PAGE_SIZE,
                        prefetchDistance = APOD_PREFETCH_DISTANCE,
                        initialLoadSize = APOD_INITIAL_SIZE,
                    ),
                pagingSourceFactory = {
                    galaxyPulseDatabase.apodDao().pagingApodSource()
                },
                remoteMediator =
                    ApodRemoteMediator(
                        galaxyPulseDb = galaxyPulseDatabase,
                        nasaServiceApi = nasaServiceApi,
                        mappers = mapper,
                    ),
            ).flow
                .map { pagingData ->
                    pagingData
                        .map { entity ->
                            mapper.mapEntityToLocal(entity)
                        }
                }
        // TODO cachedIn
    }
