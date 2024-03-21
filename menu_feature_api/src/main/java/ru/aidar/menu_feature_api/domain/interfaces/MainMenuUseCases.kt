package ru.aidar.menu_feature_api.domain.interfaces

import kotlinx.coroutines.flow.Flow

class MainMenuUseCases(
    private val repository: MainMenuRepository,
) {
    fun readFromStorage(): Flow<String> {
        return repository.readFromStorage()
    }

    suspend fun saveInStorage(value: String) {
        repository.saveInStorage(value = value)
    }

    fun signOut(): Boolean {
        return repository.signOut()
    }

    fun resetUser() {
        repository.resetUser()
    }
}
