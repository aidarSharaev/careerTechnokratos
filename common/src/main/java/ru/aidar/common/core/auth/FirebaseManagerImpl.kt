package ru.aidar.common.core.auth

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthInvalidUserException
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.userProfileChangeRequest
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.suspendCancellableCoroutine
import ru.aidar.common.core.auth.model.ErrorTypes
import ru.aidar.common.core.auth.model.FbResponse
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class FirebaseManagerImpl(
    private val firebaseAuth: FirebaseAuth,
    private val firestore: FirebaseFirestore,
) : FirebaseManager {

    init {
        Log.d("ViewModelInstance", "Firebase init")
    }

    private var user: FirebaseUser? = null

    override suspend fun createUserWithEmailAndPassword(
        email: String,
        password: String,
        nickname: String,
    ): FbResponse {
        val create = createUser(email = email, password = password)
        user?.let {
            setUserName(nickname)
            setTrainingData()
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

    override fun signOut(): Boolean {
        firebaseAuth.signOut()
        return firebaseAuth.currentUser == null
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

    override suspend fun setUserName(nickname: String): Boolean =
        suspendCoroutine { cont ->
            val profileUpdates =
                userProfileChangeRequest {
                    displayName = nickname
                }
            user!!.updateProfile(profileUpdates)
                .addOnCompleteListener { task ->
                    cont.resume(task.isSuccessful)
                }
        }


    override fun resetUser() {
        user = null
    }

    override fun getFbUser(): FirebaseUser? {
        return firebaseAuth.currentUser
    }


    override suspend fun setTrainingData(): Boolean =
        suspendCoroutine { cont ->
            firestore.collection("users").document(user!!.uid).set(
                mapOf(
                    "count" to 0,
                    "success" to 0,
                    "attempts" to mapOf<Int, Int>(),
                    "average" to 0,
                )
            ).addOnCompleteListener {
                cont.resume(it.isSuccessful)
            }
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
