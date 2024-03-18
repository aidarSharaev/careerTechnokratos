package ru.aidar.auth_feature_impl.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.aidar.auth_feature_api.domain.interfaces.LoginRepository
import ru.aidar.auth_feature_api.domain.interfaces.model.AuthResponse
import ru.aidar.auth_feature_impl.data.mappers.AuthMappers
import ru.aidar.common.core.auth.FirebaseManager
import javax.inject.Inject

class LoginRepositoryImpl
    @Inject
    constructor(
        private val firebaseManager: FirebaseManager,
        private val defaultDispatcher: CoroutineDispatcher,
        private val mappers: AuthMappers,
    ) : LoginRepository {
        override suspend fun signInWithEmailAndPassword(
            email: String,
            password: String,
        ): AuthResponse {
            return withContext(defaultDispatcher) {
                val response =
                    firebaseManager.signInWithEmailAndPassword(
                        email = email,
                        password = password,
                    )
                mappers.fbResponseToAuthResponse(response = response)
            }
        }
    }
