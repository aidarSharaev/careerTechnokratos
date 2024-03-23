package ru.aidar.auth_feature_impl.data.repository

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import ru.aidar.auth_feature_api.domain.interfaces.CreateAccRepository
import ru.aidar.auth_feature_api.domain.interfaces.model.AuthResponse
import ru.aidar.auth_feature_impl.data.mappers.AuthMappers
import ru.aidar.common.core.auth.FirebaseManager
import javax.inject.Inject

class CreateAccRepositoryImpl
    @Inject
    constructor(
        private val firebaseManager: FirebaseManager,
        private val mapper: AuthMappers,
        private val ioDispatcher: CoroutineDispatcher,
    ) : CreateAccRepository {
        override suspend fun createUserWithEmailAndPassword(
            email: String,
            password: String,
            nickname: String,
        ): AuthResponse {
            return withContext(ioDispatcher) {
                val response =
                    firebaseManager.createUserWithEmailAndPassword(
                        email = email,
                        password = password,
                        nickname = nickname,
                    )
                mapper.fbResponseToAuthResponse(response = response)
            }
        }
    }
