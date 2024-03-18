package ru.aidar.auth_feature_impl.data.repository

import ru.aidar.auth_feature_api.domain.interfaces.LoginRepository
import ru.aidar.common.core.auth.FirebaseManager
import javax.inject.Inject

class LoginRepositoryImpl
    @Inject
    constructor(
        private val firebaseManager: FirebaseManager,
        // private val mapper: FbUserToFbAuthMapper
    ) : LoginRepository {
        override suspend fun signInWithEmailAndPassword(
            email: String,
            password: String,
        ): Boolean {
            return firebaseManager.signInWithEmailAndPassword(
                email = email,
                password = password,
            )
        }
    }
