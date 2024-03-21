package ru.aidar.apa_feature_api.domain.model

interface ScreenStatus {
    object Loading : ScreenStatus

    object Visible : ScreenStatus
}
