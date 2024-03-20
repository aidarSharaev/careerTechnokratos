package ru.aidar.menu_feature_api.domain.wrappers

data class MainMenuState(
    val status: ScreenStatus = ScreenStatus.Visible,
)

interface ScreenStatus {
    object Visible : ScreenStatus

    object Loading : ScreenStatus
}
