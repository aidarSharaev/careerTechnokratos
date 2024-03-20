package ru.aidar.menu_feature_impl.data.repository

import kotlinx.coroutines.flow.Flow
import ru.aidar.common.core.auth.FirebaseManager
import ru.aidar.common.core.preferences.LocalManager
import ru.aidar.menu_feature_api.domain.interfaces.MainMenuRepository
import javax.inject.Inject

class MainMenuRepositoryImpl
    @Inject
    constructor(
        private val localManager: LocalManager,
        private val firebaseManager: FirebaseManager,
    ) : MainMenuRepository {
        override suspend fun saveInStorage(value: String) {
            localManager.saveMeasSystem(measSystem = value)
        }

        override fun readFromStorage(): Flow<String> {
            return localManager.readMeasSystem()
        }

        override fun signOut(): Boolean {
            return firebaseManager.signOut()
        }

        override fun resetUser() {
            firebaseManager.resetUser()
        }
    }
