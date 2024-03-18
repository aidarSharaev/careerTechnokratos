package ru.aidar.auth_feature_impl.presentation.login.wrapper

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import ru.aidar.auth_feature_api.domain.wrappers.LoginState
import ru.aidar.auth_feature_api.domain.wrappers.LoginStateWrapper
import ru.aidar.auth_feature_api.model.ScreenStatus

class LoginStateWrapperImpl(
    private val flow: MutableStateFlow<LoginState>,
) : LoginStateWrapper {
    override fun flow(): StateFlow<LoginState> {
        return flow.asStateFlow()
    }

    override fun updateEmail(email: String) {
        flow.update { it.copy(email = email) }
    }

    override fun updatePassword(password: String) {
        flow.update { it.copy(password = password) }
    }

    override fun updateStatus(status: ScreenStatus) {
        flow.update { it.copy(status = status) }
    }

    override fun showFullError(value: Boolean) {
        flow.update { it.copy(emailError = value, passwordError = value) }
    }

    override fun showEmailError() {
        flow.update { it.copy(emailError = true) }
    }

    override fun showPasswordError() {
        flow.update { it.copy(passwordError = true) }
    }
}
