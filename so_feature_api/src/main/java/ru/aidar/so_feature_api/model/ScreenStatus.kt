package ru.aidar.so_feature_api.model

interface ScreenStatus {
    object Visible : ScreenStatus

    object Loading : ScreenStatus
}
