package ru.aidar.menu_feature_impl.data

import kotlinx.coroutines.flow.Flow
import ru.aidar.common.core.preferences.LocalManager
import ru.aidar.menu_feature_api.domain.MainMenuRepository
import javax.inject.Inject

class MainMenuRepositoryImpl
    @Inject
    constructor(
        private val localManager: LocalManager,
    ) : MainMenuRepository {
        override suspend fun saveInStorage(value: String) {
            localManager.saveMeasSystem(measSystem = value)
        }

        override fun readFromStorage(): Flow<String> {
            return localManager.readMeasSystem()
        }
    }
