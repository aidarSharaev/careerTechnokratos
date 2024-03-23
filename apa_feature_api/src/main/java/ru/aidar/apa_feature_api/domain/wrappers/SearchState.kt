package ru.aidar.apa_feature_api.domain.wrappers

import ru.aidar.apa_feature_api.domain.model.ScreenStatus
import ru.aidar.apa_feature_api.remote.ApaLocal

data class SearchState(
    val status: ScreenStatus = ScreenStatus.Done,
    val query: String = "",
    val active: Boolean = false,
    val responses: List<ApaLocal> = listOf(),
)
