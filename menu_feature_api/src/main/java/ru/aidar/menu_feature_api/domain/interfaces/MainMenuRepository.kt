package ru.aidar.menu_feature_api.domain.interfaces

import kotlinx.coroutines.flow.Flow

interface MainMenuRepository {
    suspend fun saveInStorage(value: String)

    fun readFromStorage(): Flow<String>

    fun signOut(): Boolean

    fun resetUser()
}
