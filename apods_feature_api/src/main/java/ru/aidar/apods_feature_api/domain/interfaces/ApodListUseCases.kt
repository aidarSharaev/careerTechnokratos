package ru.aidar.apods_feature_api.domain.interfaces

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow
import ru.aidar.apods_feature_api.domain.model.ApodLocal

class ApodListUseCases(
    private val apodListRepository: ApodListRepository,
) {
    fun getPictures(): Flow<PagingData<ApodLocal>> {
        return apodListRepository.getPictures()
    }
}
