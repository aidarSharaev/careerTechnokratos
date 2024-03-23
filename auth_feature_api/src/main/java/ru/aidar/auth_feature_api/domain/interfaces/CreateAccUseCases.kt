package ru.aidar.auth_feature_api.domain.interfaces

import ru.aidar.auth_feature_api.domain.interfaces.model.AuthResponse

class CreateAccUseCases(
    private val repository: CreateAccRepository,
) {
    suspend fun createUserWithEmailAndPassword(
        email: String,
        password: String,
        nickname: String,
    ): AuthResponse {
        return repository.createUserWithEmailAndPassword(
            email = email,
            password = password,
            nickname = nickname,
        )
    }
}
