package ru.aidar.apa_feature_api.domain.wrappers

import ru.aidar.apa_feature_api.domain.model.ScreenStatus
import ru.aidar.apa_feature_api.remote.ApaLocal
import ru.aidar.apa_feature_api.utils.Constants.Earth
import ru.aidar.apa_feature_api.utils.Constants.Mars
import ru.aidar.apa_feature_api.utils.Constants.Venus

data class SearchState(
    val status: ScreenStatus = ScreenStatus.Done,
    val query: String = "",
    val active: Boolean = false,
    val responses: List<ApaLocal> = listOf(Earth, Venus, Mars),
)
