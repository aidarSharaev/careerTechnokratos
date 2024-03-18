package ru.aidar.auth_feature_api.domain.interfaces

import ru.aidar.auth_feature_api.domain.interfaces.model.AuthResponse

interface CreateAccRepository {
    suspend fun createUserWithEmailAndPassword(
        email: String,
        password: String,
        nickname: String,
    ): AuthResponse
}
