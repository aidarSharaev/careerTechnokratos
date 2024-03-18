package ru.aidar.common.core.auth

import android.util.Log
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlin.coroutines.resume

class FirebaseManagerImpl(
    private val firebaseAuth: FirebaseAuth,
) : FirebaseManager {
    var user: FirebaseUser? = null

    override suspend fun createUserWithEmailAndPassword(
        email: String,
        password: String,
    ): Boolean =
        suspendCancellableCoroutine { continuation ->
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d(FirebaseManager.TAG, "createUserWithEmail:success")
                        user = firebaseAuth.currentUser
                        continuation.resume(
                            true,
                            /*FbUserResponse(
                                user = user,
                                status = Status.Success
                            )*/
                        )
                    } else {
                        Log.w(FirebaseManager.TAG, "createUserWithEmail:failure", task.exception)
                        continuation.resume(
                            false,
//                            FbUserResponse(
//                                user = null,
//                                status = Status.Fail("todo")
//                            )
                        )
                    }
                }
            continuation.invokeOnCancellation {
                continuation.resume(
                    false,
                    /*FbUserResponse(
                        user = null,
                        status = Status.Fail("todo")
                    )*/
                )
            }
        }

    override suspend fun signInWithEmailAndPassword(
        email: String,
        password: String,
    ): Boolean =
        suspendCancellableCoroutine { continuation ->
            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        Log.d(FirebaseManager.TAG, "createUserWithEmail:success")
                        user = firebaseAuth.currentUser
                        continuation.resume(
                            true,
                        )
                    } else {
                        Log.w(FirebaseManager.TAG, "createUserWithEmail:failure", task.exception)
                        continuation.resume(
                            false,
                        )
                    }
                }
            continuation.invokeOnCancellation {
                continuation.resume(false)
            }
        }

    override fun getFbUser(): FirebaseUser? {
        return firebaseAuth.currentUser
    }
}
