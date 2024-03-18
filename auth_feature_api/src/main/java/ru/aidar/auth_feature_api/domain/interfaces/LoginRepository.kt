package ru.aidar.auth_feature_api.domain.interfaces

import ru.aidar.auth_feature_api.domain.interfaces.model.AuthResponse

interface LoginRepository {
    suspend fun signInWithEmailAndPassword(
        email: String,
        password: String,
    ): AuthResponse
}
