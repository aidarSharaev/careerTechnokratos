package ru.aidar.apa_feature_api.domain.wrappers

import kotlinx.coroutines.flow.StateFlow
import ru.aidar.apa_feature_api.domain.model.ScreenStatus
import ru.aidar.apa_feature_api.remote.ApaLocal

interface SearchStateWrapper {

    fun flow(): StateFlow<SearchState>
    fun updateActive(active: Boolean)
    fun updateQuery(query: String)
    fun updateStatus(status: ScreenStatus)
    fun updateResponses(responses: List<ApaLocal>)
}
