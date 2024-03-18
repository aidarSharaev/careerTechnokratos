package ru.aidar.menu_feature_api.domain

import kotlinx.coroutines.flow.Flow

interface MainMenuRepository {
    suspend fun saveInStorage(value: String)

    fun readFromStorage(): Flow<String>
}
