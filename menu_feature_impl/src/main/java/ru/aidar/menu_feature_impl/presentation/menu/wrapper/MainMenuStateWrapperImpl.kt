package ru.aidar.menu_feature_impl.presentation.menu.wrapper

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import ru.aidar.menu_feature_api.domain.wrappers.MainMenuState
import ru.aidar.menu_feature_api.domain.wrappers.MainMenuStateWrapper
import ru.aidar.menu_feature_api.domain.wrappers.ScreenStatus

class MainMenuStateWrapperImpl(
    private val flow: MutableStateFlow<MainMenuState>,
) : MainMenuStateWrapper {
    override fun flow(): StateFlow<MainMenuState> {
        return flow
    }

    override fun updateStatus(status: ScreenStatus) {
        flow.update { it.copy(status = status) }
    }
}
