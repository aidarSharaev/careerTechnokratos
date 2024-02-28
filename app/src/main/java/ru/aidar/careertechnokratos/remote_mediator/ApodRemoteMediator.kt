package ru.aidar.careertechnokratos.remote_mediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import ru.aidar.careertechnokratos.data.local.NasaDatabase
import ru.aidar.careertechnokratos.model.ApodDto
import ru.aidar.careertechnokratos.remote.NasaServiceApi

@OptIn(ExperimentalPagingApi::class)
class ApodRemoteMediator(
    private val nasaDb: NasaDatabase,
    private val nasaServiceApi: NasaServiceApi,
) : RemoteMediator<Int, ApodDto>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ApodDto>
    ): MediatorResult {
        return try {
//            val loadKey = when(loadType) {
//                LoadType.REFRESH -> 1
//                LoadType.PREPEND -> return MediatorResult.Success(
//                    endOfPaginationReached = true
//                )
//
//                LoadType.APPEND -> {
//                    val lastItem = state.lastItemOrNull()
//                    if(lastItem == null) {
//                        1
//                    } else {
//                        (lastItem.id / state.config.pageSize) + 1
//                    }
//                }
//            }
            // todo date
            // todo equal images
            val apods = nasaServiceApi.getApod(
                count = 30
            )
            nasaDb.withTransaction {
                if(loadType == LoadType.REFRESH) {
                    nasaDb.apodDao.deleteAll()
                }
                val apods = apods.map { it.toEntity() }
                nasaDb.apodDao.upsertAllApods(apods = apods)
            }
            MediatorResult.Success(
                endOfPaginationReached = apods.isEmpty()
            )
        } catch(e: Exception) {
            MediatorResult.Error(throwable = e)
        }
    }

}