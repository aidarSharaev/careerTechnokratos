package ru.aidar.apods_feature_impl.remote.mediator

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import retrofit2.HttpException
import ru.aidar.common.data.db.GalaxyPulseDatabase
import ru.aidar.common.data.db.model.ApodEntity
import ru.aidar.common.remote.NasaServiceApi
import ru.aidar.common.utils.toEntity
import java.io.IOException

@OptIn(ExperimentalPagingApi::class)
class ApodRemoteMediator(
    private val galaxyPulseDb: GalaxyPulseDatabase,
    private val nasaServiceApi: NasaServiceApi,
) : RemoteMediator<Int, ApodEntity>() {
    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ApodEntity>,
    ): MediatorResult {
        return try {
            // todo date
            val apods = nasaServiceApi.getApod(count = 30)
            galaxyPulseDb.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    galaxyPulseDb.apodDao().deleteAll()
                }
                val list = apods.map { it.toEntity() }
                galaxyPulseDb.apodDao().upsertAllApods(apods = list)
            }
            MediatorResult.Success(
                endOfPaginationReached = apods.isEmpty(),
            )
        } catch (e: IOException) {
            MediatorResult.Error(throwable = e)
        } catch (e: HttpException) {
            MediatorResult.Error(throwable = e)
        }
    }
}
