package ru.aidar.auth_feature_api.domain.interfaces

class CreateAccUseCases(
    private val createAccRepository: CreateAccRepository,
) {
    suspend fun createUserWithEmailAndPassword(
        email: String,
        password: String,
    ): Boolean {
        return createAccRepository.createUserWithEmailAndPassword(
            email = email,
            password = password,
        )
    }
}
