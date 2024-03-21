package ru.aidar.cc_feature_api.domain.wrapper

import ru.aidar.cc_feature_api.domain.model.ScreenStatus

data class CupidState(
    val status: ScreenStatus = ScreenStatus.Visible
)