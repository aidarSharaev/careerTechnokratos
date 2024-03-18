package ru.aidar.auth_feature_api.domain.interfaces

interface LoginRepository {
    suspend fun signInWithEmailAndPassword(
        email: String,
        password: String,
    ): Boolean
}
