package ru.aidar.common.core.auth

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.userProfileChangeRequest
import kotlinx.coroutines.suspendCancellableCoroutine
import ru.aidar.common.core.auth.model.ErrorTypes
import ru.aidar.common.core.auth.model.FbResponse
import kotlin.coroutines.resume

class FirebaseManagerImpl(
    private val firebaseAuth: FirebaseAuth,
) : FirebaseManager {
    private var user: FirebaseUser? = null

    override suspend fun createUserWithEmailAndPassword(
        email: String,
        password: String,
        nickname: String,
    ): FbResponse {
        val create = createUser(email = email, password = password)
        user?.let {
            setUserName(nickname)
        }
        return create
    }

    override suspend fun createUser(
        email: String,
        password: String,
    ): FbResponse =
        suspendCancellableCoroutine { continuation ->
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful) {
                        Log.d(FirebaseManager.TAG, "createUserWithEmail:success")
                        user = firebaseAuth.currentUser
                        continuation.resume(FbResponse(user = user))
                    } else {
                        Log.d(FirebaseManager.TAG, "createUserWithEmail:failed")
                        val message = handleLoginError(task.exception)
                        Log.d(FirebaseManager.TAG, "${task.exception}")
                        continuation.resume(FbResponse(message = message))
                    }
                }
            continuation.invokeOnCancellation {
                continuation.resume(FbResponse(message = ErrorTypes.CANCEL_ERROR.number))
            }
        }

    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String,
    ): FbResponse =
        suspendCancellableCoroutine { continuation ->
            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if(task.isSuccessful) {
                        Log.d(FirebaseManager.TAG, "createUserWithEmail:success")
                        user = firebaseAuth.currentUser
                        continuation.resume(FbResponse(user = user))
                    } else {
                        Log.d(FirebaseManager.TAG, "createUserWithEmail:failed")
                        val message = handleLoginError(task.exception)
                        Log.d(FirebaseManager.TAG, "{task.exception}")
                        continuation.resume(FbResponse(message = message))
                    }
                }
            continuation.invokeOnCancellation {
                continuation.resume(FbResponse(message = ErrorTypes.CANCEL_ERROR.number))
            }
        }

    override suspend fun setUserName(nickname: String) {
        val profileUpdates =
            userProfileChangeRequest {
                displayName = nickname
            }

        user!!.updateProfile(profileUpdates)
            .addOnCompleteListener { task ->
                if(task.isSuccessful) {
                    Log.d(FirebaseManager.TAG, "User profile updated.")
                }
            }
    }

    override fun getFbUser(): FirebaseUser? {
        return firebaseAuth.currentUser
    }

    private fun handleLoginError(exception: Exception?): Int {
        return when(exception) {
            is FirebaseAuthInvalidCredentialsException -> {
                ErrorTypes.PASSWORD_ERROR.number
            }

            is FirebaseAuthInvalidUserException -> {
                ErrorTypes.LOGIN_ERROR.number
            }

            else -> {
                ErrorTypes.ANOTHER_ERROR.number
            }
        }
    }
}
