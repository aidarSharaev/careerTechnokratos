package ru.aidar.apa_feature_api.domain.interfaces

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.aidar.apa_feature_api.remote.ApaLocal

class SearchUseCases(
    private val repository: SearchRepository,
    private val ioDispatcher: CoroutineDispatcher
) {

    suspend fun getObjects(regex: String): List<ApaLocal> =
        withContext(ioDispatcher) {
            repository.getObjects(regex = regex)
        }
}
