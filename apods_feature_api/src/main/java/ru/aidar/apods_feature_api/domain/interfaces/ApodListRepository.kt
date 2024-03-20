package ru.aidar.apods_feature_api.domain.interfaces

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.aidar.apods_feature_api.domain.model.ApodLocal

interface ApodListRepository {
    fun getPictures(): Flow<PagingData<ApodLocal>>
}
