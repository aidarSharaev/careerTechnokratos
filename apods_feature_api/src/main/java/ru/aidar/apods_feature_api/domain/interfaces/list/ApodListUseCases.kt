package ru.aidar.apods_feature_api.domain.interfaces.list

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.aidar.apods_feature_api.domain.model.ApodLocal

class ApodListUseCases(
    private val repository: ApodListRepository,
) {
    fun getPictures(): Flow<PagingData<ApodLocal>> {
        return repository.getPictures()
    }
}
