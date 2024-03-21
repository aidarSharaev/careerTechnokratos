package ru.aidar.apa_feature_api.domain.wrappers

import ru.aidar.apa_feature_api.domain.model.ScreenStatus

data class SearchState(
    val status: ScreenStatus = ScreenStatus.Visible,
)
