package ru.aidar.apa_feature_api.domain.interfaces

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.aidar.apa_feature_api.remote.ApaLocal
import ru.aidar.apa_feature_api.remote.Response

class SearchUseCases(
    private val repository: SearchRepository,
    private val ioDispatcher: CoroutineDispatcher
) {

    suspend fun getObjects(regex: String): Response =
        withContext(ioDispatcher) {
            repository.getObjects(regex = regex)
        }
}
