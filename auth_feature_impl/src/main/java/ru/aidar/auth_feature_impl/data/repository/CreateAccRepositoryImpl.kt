package ru.aidar.auth_feature_impl.data.repository

import ru.aidar.auth_feature_api.domain.interfaces.CreateAccRepository
import ru.aidar.common.core.auth.FirebaseManager
import javax.inject.Inject

class CreateAccRepositoryImpl
    @Inject
    constructor(
        private val firebaseManager: FirebaseManager,
//    private val mapper: FbUserToFbAuthMapper
    ) : CreateAccRepository {
        override suspend fun createUserWithEmailAndPassword(
            email: String,
            password: String,
        ): Boolean {
            return firebaseManager.createUserWithEmailAndPassword(email = email, password = password)
        }
    }
