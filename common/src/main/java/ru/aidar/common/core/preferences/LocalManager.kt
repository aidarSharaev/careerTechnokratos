package ru.aidar.common.core.preferences

import androidx.datastore.preferences.core.stringPreferencesKey
import kotlinx.coroutines.flow.Flow

interface LocalManager {

    fun readMeasSystem(): Flow<String>

    suspend fun saveMeasSystem(measSystem: String)

    companion object {
        val PICKED_SYSTEM = stringPreferencesKey("measurementSystem")
    }
}
