package ru.aidar.auth_feature_api.domain.interfaces.model

data class AuthResponse(
    val instance: Boolean = false,
    val number: Int? = null,
)
