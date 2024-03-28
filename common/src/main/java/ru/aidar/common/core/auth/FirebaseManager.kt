package ru.aidar.common.core.auth

import com.google.firebase.auth.FirebaseUser
import ru.aidar.common.core.auth.model.FbResponse

interface FirebaseManager {

    companion object {
        const val TAG = "FirebaseManager"
    }

    suspend fun createUserWithEmailAndPassword(
        email: String,
        password: String,
        nickname: String,
    ): FbResponse

    suspend fun signInWithEmailAndPassword(
        email: String,
        password: String,
    ): FbResponse

    suspend fun setUserName(
        nickname: String,
    ): Boolean

    fun resetUser()

    fun getFbUser(): FirebaseUser?

    suspend fun createUser(
        email: String,
        password: String,
    ): FbResponse

    fun signOut(): Boolean

    suspend fun setTrainingData(): Boolean
}
