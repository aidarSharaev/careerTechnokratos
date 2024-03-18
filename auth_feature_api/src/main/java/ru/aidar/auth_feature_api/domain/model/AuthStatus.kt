package ru.aidar.auth_feature_api.domain.model

interface AuthStatus {
    object Ok : AuthStatus

    object Bad : AuthStatus
}
