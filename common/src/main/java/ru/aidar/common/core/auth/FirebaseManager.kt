package ru.aidar.common.core.auth

import com.google.firebase.auth.FirebaseUser

interface FirebaseManager {
    companion object {
        const val TAG = "FirebaseManager"
    }

    suspend fun createUserWithEmailAndPassword(
        email: String,
        password: String,
    ): Boolean

    suspend fun signInWithEmailAndPassword(
        email: String,
        password: String,
    ): Boolean

    fun getFbUser(): FirebaseUser?
}
