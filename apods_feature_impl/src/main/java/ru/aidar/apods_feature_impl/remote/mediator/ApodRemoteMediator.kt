package ru.aidar.apods_feature_impl.remote.mediator

import android.util.Log
import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingState
import androidx.paging.RemoteMediator
import androidx.room.withTransaction
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import ru.aidar.apods_feature_api.remote.NasaServiceApi
import ru.aidar.apods_feature_impl.data.mapper.ApodMappers
import ru.aidar.common.data.db.local.GalaxyPulseDatabase
import ru.aidar.common.data.db.local.model.ApodEntity
import ru.aidar.common.data.db.local.model.RemoteKeysEntity
import java.io.IOException
import java.util.concurrent.TimeUnit

@OptIn(ExperimentalPagingApi::class)
class ApodRemoteMediator(
    private val galaxyPulseDb: GalaxyPulseDatabase,
    private val nasaServiceApi: NasaServiceApi,
    private val mappers: ApodMappers,
) : RemoteMediator<Int, ApodEntity>() {
    override suspend fun initialize(): InitializeAction {
        val cacheTimeout = TimeUnit.MILLISECONDS.convert(1, TimeUnit.HOURS)

        return if (System.currentTimeMillis() - (
                galaxyPulseDb.remoteKeysDao().getCreationTime()
                    ?: 0
            ) < cacheTimeout
        ) {
            InitializeAction.SKIP_INITIAL_REFRESH
        } else {
            InitializeAction.LAUNCH_INITIAL_REFRESH
        }
    }

    override suspend fun load(
        loadType: LoadType,
        state: PagingState<Int, ApodEntity>,
    ): MediatorResult {
        val page: Int =
            when (loadType) {
                LoadType.REFRESH -> {
                    val remoteKeys = getRemoteKeyClosestToCurrentPosition(state)
                    remoteKeys?.nextKey?.minus(1) ?: 1
                }

                LoadType.PREPEND -> {
                    val remoteKeys = getRemoteKeyForFirstItem(state)
                    val prevKey = remoteKeys?.prevKey
                    prevKey
                        ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
                }

                LoadType.APPEND -> {
                    val remoteKeys = getRemoteKeyForLastItem(state)
                    val nextKey = remoteKeys?.nextKey
                    nextKey
                        ?: return MediatorResult.Success(endOfPaginationReached = remoteKeys != null)
                }
            }
        return try {
            val pictures = withContext(Dispatchers.IO) { nasaServiceApi.getApod(count = 30) }
            val endOfPaginationReached = pictures.isEmpty()

            galaxyPulseDb.withTransaction {
                if (loadType == LoadType.REFRESH) {
                    galaxyPulseDb.apodDao().deleteAll()
                    galaxyPulseDb.remoteKeysDao().deleteAll()
                }
                val prevKey = if (page > 1) page - 1 else null
                val nextKey = if (endOfPaginationReached) null else page + 1

                Log.d("Paging3", "-- page = {$page}, prevKey - $prevKey, next - $nextKey --")

                val list =
                    pictures.filter { local ->
                        local.url?.contains(".jpg") ?: false
                    }.map {
                        mappers.mapLocalToEntity(apodLocal = it, page = page)
                    }
                val remoteKeyEntities =
                    list.map {
                        RemoteKeysEntity(
                            pictureUrl = it.url,
                            prevKey = prevKey,
                            currentPage = page,
                            nextKey = nextKey,
                        )
                    }
                galaxyPulseDb.remoteKeysDao().insertAll(remoteKeyEntities)
                galaxyPulseDb.apodDao().upsertAllApods(list)
            }
            MediatorResult.Success(
                endOfPaginationReached = endOfPaginationReached,
            )
        } catch (e: IOException) {
            MediatorResult.Error(throwable = e)
        } catch (e: HttpException) {
            MediatorResult.Error(throwable = e)
        }
    }

    private suspend fun getRemoteKeyClosestToCurrentPosition(state: PagingState<Int, ApodEntity>): RemoteKeysEntity? {
        return state.anchorPosition?.let { position ->
            state.closestItemToPosition(position)?.url?.let { url ->
                galaxyPulseDb.remoteKeysDao().getKeyByUrl(url)
            }
        }
    }

    private suspend fun getRemoteKeyForFirstItem(state: PagingState<Int, ApodEntity>): RemoteKeysEntity? {
        return state.pages.firstOrNull {
            it.data.isNotEmpty()
        }?.data?.firstOrNull()?.let { local ->
            galaxyPulseDb.remoteKeysDao().getKeyByUrl(local.url)
        }
    }

    private suspend fun getRemoteKeyForLastItem(state: PagingState<Int, ApodEntity>): RemoteKeysEntity? {
        return state.pages.lastOrNull {
            it.data.isNotEmpty()
        }?.data?.lastOrNull()?.let { local ->
            galaxyPulseDb.remoteKeysDao().getKeyByUrl(local.url)
        }
    }
}
