package ru.aidar.menu_feature_api.domain.wrappers

import kotlinx.coroutines.flow.StateFlow

interface MainMenuStateWrapper {
    fun flow(): StateFlow<MainMenuState>

    fun updateStatus(status: ScreenStatus)
}
