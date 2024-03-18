package ru.aidar.common.core.auth.model

import com.google.firebase.auth.FirebaseUser
import ru.aidar.common.core.error.Status

data class FbUserResponse(
    val user: FirebaseUser?,
    val status: Status,
)
