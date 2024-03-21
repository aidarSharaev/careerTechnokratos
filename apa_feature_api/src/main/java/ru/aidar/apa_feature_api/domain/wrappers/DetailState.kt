package ru.aidar.apa_feature_api.domain.wrappers

import ru.aidar.apa_feature_api.domain.model.ScreenStatus

data class DetailState(
    val status: ScreenStatus = ScreenStatus.Visible,
)
