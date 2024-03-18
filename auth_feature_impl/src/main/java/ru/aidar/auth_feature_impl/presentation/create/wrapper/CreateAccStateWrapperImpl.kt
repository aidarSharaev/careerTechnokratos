package ru.aidar.auth_feature_impl.presentation.create.wrapper

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import ru.aidar.auth_feature_api.domain.wrappers.CreateAccState
import ru.aidar.auth_feature_api.domain.wrappers.CreateAccStateWrapper
import ru.aidar.auth_feature_api.model.ScreenStatus

class CreateAccStateWrapperImpl(
    private val flow: MutableStateFlow<CreateAccState>,
) : CreateAccStateWrapper {
    override fun flow(): StateFlow<CreateAccState> {
        return flow.asStateFlow()
    }

    override fun updateEmail(email: String) {
        flow.update { it.copy(email = email) }
    }

    override fun updatePassword(password: String) {
        flow.update { it.copy(password = password) }
    }

    override fun updateNickname(name: String) {
        flow.update { it.copy(nickname = name) }
    }

    override fun updateStatus(status: ScreenStatus) {
        flow.update { it.copy(status = status) }
    }

    override fun showEmailError() {
        flow.update { it.copy(emailError = true) }
    }

    override fun showPasswordError() {
        flow.update { it.copy(passwordError = true) }
    }

    override fun showFullError(value: Boolean) {
        flow.update { it.copy(emailError = value, passwordError = value) }
    }
}
