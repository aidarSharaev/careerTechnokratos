package ru.aidar.apod_feature_impl.presentation

//import androidx.lifecycle.ViewModel
//import androidx.paging.ExperimentalPagingApi
//import androidx.paging.Pager
//import androidx.paging.PagingConfig
//import androidx.paging.PagingData
//import androidx.paging.map
//import kotlinx.coroutines.flow.Flow
//import kotlinx.coroutines.flow.map
//import ru.aidar.common.utils.Constants.APOD_INITIAL_SIZE
//import ru.aidar.common.utils.Constants.APOD_PAGE_SIZE
//import ru.aidar.common.utils.Constants.APOD_PREFETCH_DISTANCE
//import ru.aidar.common.data.db.GalaxyPulseDatabase
//import ru.aidar.common.data.network.dto.ApodDto
//import ru.aidar.careertechnokratos.remote.NasaServiceApi
//import ru.aidar.careertechnokratos.remote_mediator.ApodRemoteMediator
//import javax.inject.Inject

//class ApodViewModel @Inject constructor(
//    private val nasaServiceApi: NasaServiceApi,
//    private val galaxyPulseDatabase: GalaxyPulseDatabase,
//) : ViewModel() {
//    @OptIn(ExperimentalPagingApi::class)
//    fun getApodImages(): Flow<PagingData<ApodDto>> =
//        Pager(
//            config = PagingConfig(
//                pageSize = APOD_PAGE_SIZE,
//                prefetchDistance = APOD_PREFETCH_DISTANCE,
//                initialLoadSize = APOD_INITIAL_SIZE,
//            ),
//            pagingSourceFactory = {
//                galaxyPulseDatabase.apodDao.pagingApodSource()
//            },
//            remoteMediator = ApodRemoteMediator(
//                galaxyPulseDb = galaxyPulseDatabase,
//                nasaServiceApi = nasaServiceApi
//            )
//        ).flow
//            .map { pagingData ->
//                pagingData.map { entity ->
//                    entity.toDto()
//                }
//            }
//    // TODO cachedIn
//}