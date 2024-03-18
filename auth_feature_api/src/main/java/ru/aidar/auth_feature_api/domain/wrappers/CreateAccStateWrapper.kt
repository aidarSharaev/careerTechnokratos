package ru.aidar.auth_feature_api.domain.wrappers

import kotlinx.coroutines.flow.StateFlow
import ru.aidar.auth_feature_api.model.ScreenStatus

interface CreateAccStateWrapper {
    fun flow(): StateFlow<CreateAccState>

    fun updateEmail(email: String)

    fun updatePassword(password: String)

    fun updateNickname(name: String)

    fun updateStatus(status: ScreenStatus)

    fun showEmailError()

    fun showPasswordError()

    fun showFullError(value: Boolean)
}
