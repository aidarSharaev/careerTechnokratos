package ru.aidar.careertechnokratos.remote_mediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import retrofit2.HttpException
import ru.aidar.common.data.db.model.ApodEntity
import ru.aidar.common.data.db.GalaxyPulseDatabase
import ru.aidar.careertechnokratos.remote.NasaServiceApi
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class ApodRemoteMediator(
    private val galaxyPulseDb: GalaxyPulseDatabase,
    private val nasaServiceApi: NasaServiceApi,
) : RemoteMediator<Int, ApodEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ApodEntity>
    ): MediatorResult {
        return try {
            // todo date
            // todo equal images
            val apods = nasaServiceApi.getApod(
                count = 30
            )
            galaxyPulseDb.withTransaction {
                if(loadType == LoadType.REFRESH) {
                    galaxyPulseDb.apodDao.deleteAll()
                }
                val apods = apods.map { it.toEntity() }
                galaxyPulseDb.apodDao.upsertAllApods(apods = apods)
            }
            MediatorResult.Success(
                endOfPaginationReached = apods.isEmpty()
            )
        } catch(e: IOException) {
            MediatorResult.Error(throwable = e)
        } catch(e: HttpException) {
            MediatorResult.Error(throwable = e)
        }
    }
}