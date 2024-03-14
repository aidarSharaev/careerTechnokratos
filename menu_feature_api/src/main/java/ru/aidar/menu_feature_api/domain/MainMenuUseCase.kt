package ru.aidar.menu_feature_api.domain

import kotlinx.coroutines.flow.Flow

class MainMenuUseCases(private val repository: MainMenuRepository) {

    suspend fun readFromStorage(): Flow<String> {
        return repository.readFromStorage()
    }

    suspend fun saveInStorage(value: String) {
        repository.saveInStorage(value = value)
    }
}