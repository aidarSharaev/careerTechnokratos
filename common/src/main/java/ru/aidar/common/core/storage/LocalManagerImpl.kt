package ru.aidar.common.core.storage

import android.content.Context
import androidx.datastore.preferences.core.edit
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import ru.aidar.common.core.preferences.LocalManager
import ru.aidar.common.core.preferences.LocalManager.Companion.PICKED_SYSTEM
import ru.aidar.common.utils.dataStore

class LocalManagerImpl(private val context: Context) : LocalManager {
    override fun readMeasSystem(): Flow<String> {
        return context.dataStore.data.map { preferences ->
            preferences[PICKED_SYSTEM] ?: "kph"
        }
    }

    override suspend fun saveMeasSystem(measSystem: String) {
        context.dataStore.edit { preferences ->
            preferences[PICKED_SYSTEM] = measSystem
        }
    }
}
