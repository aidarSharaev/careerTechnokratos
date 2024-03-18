package ru.aidar.auth_feature_api.domain.interfaces

import ru.aidar.auth_feature_api.domain.interfaces.model.AuthResponse

class LoginUseCases(
    private val loginRepository: LoginRepository,
) {
    suspend fun signInWithEmailAndPassword(
        email: String,
        password: String,
    ): AuthResponse {
        return loginRepository.signInWithEmailAndPassword(email = email, password = password)
    }
}
