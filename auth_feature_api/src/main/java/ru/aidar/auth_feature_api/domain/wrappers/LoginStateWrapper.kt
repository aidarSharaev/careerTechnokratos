package ru.aidar.auth_feature_api.domain.wrappers

import kotlinx.coroutines.flow.StateFlow
import ru.aidar.auth_feature_api.model.ScreenStatus

interface LoginStateWrapper {
    fun flow(): StateFlow<LoginState>

    fun updateEmail(email: String)

    fun updatePassword(password: String)

    fun updateStatus(status: ScreenStatus)

    fun showFullError(value: Boolean)

    fun showEmailError()

    fun showPasswordError()
}
