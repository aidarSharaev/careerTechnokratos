package ru.aidar.cc_feature_api.domain.model

interface ScreenStatus {
    object Visible : ScreenStatus

    object Loading : ScreenStatus
}
