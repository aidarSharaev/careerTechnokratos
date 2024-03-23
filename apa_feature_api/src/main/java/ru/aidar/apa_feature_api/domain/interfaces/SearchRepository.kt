package ru.aidar.apa_feature_api.domain.interfaces

import ru.aidar.apa_feature_api.remote.ApaLocal

interface SearchRepository {

    suspend fun getObjects(regex: String): List<ApaLocal>
}
