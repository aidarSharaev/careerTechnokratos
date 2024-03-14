package ru.aidar.apods_feature_impl.presentation

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.map
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.aidar.apods_feature_impl.remote.mediator.ApodRemoteMediator
import ru.aidar.common.base.BaseViewModel
import ru.aidar.common.data.db.GalaxyPulseDatabase
import ru.aidar.common.data.network.dto.ApodDto
import ru.aidar.common.remote.NasaServiceApi
import ru.aidar.common.utils.Dimens.APOD_INITIAL_SIZE
import ru.aidar.common.utils.Dimens.APOD_PAGE_SIZE
import ru.aidar.common.utils.Dimens.APOD_PREFETCH_DISTANCE
import ru.aidar.common.utils.toDto
import javax.inject.Inject

class ApodViewModel
    @Inject
    constructor(
        private val nasaServiceApi: NasaServiceApi,
        private val galaxyPulseDatabase: GalaxyPulseDatabase,
    ) : BaseViewModel() {
        @OptIn(ExperimentalPagingApi::class)
        fun getApodImages(): Flow<PagingData<ApodDto>> =
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
                    ),
            ).flow
                .map { pagingData ->
                    pagingData.map { entity ->
                        entity.toDto()
                    }
                }
        // TODO cachedIn
    }
