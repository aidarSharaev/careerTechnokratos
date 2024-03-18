package ru.aidar.auth_feature_api.domain.wrappers

import ru.aidar.auth_feature_api.model.ScreenStatus

data class LoginState(
    val email: String = "",
    val password: String = "",
    val emailError: Boolean = false,
    val passwordError: Boolean = false,
    val status: ScreenStatus = ScreenStatus.Visible,
)
