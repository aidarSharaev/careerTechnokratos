package ru.aidar.auth_feature_api.domain.interfaces

class LoginUseCases(
    private val loginRepository: LoginRepository,
) {
    suspend fun signInWithEmailAndPassword(
        email: String,
        password: String,
    ): Boolean {
        return loginRepository.signInWithEmailAndPassword(email = email, password = password)
    }
}
