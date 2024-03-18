package ru.aidar.auth_feature_api.domain.interfaces

interface CreateAccRepository {
    suspend fun createUserWithEmailAndPassword(
        email: String,
        password: String,
    ): Boolean
}
