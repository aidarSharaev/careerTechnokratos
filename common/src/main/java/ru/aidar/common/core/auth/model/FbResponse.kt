package ru.aidar.common.core.auth.model

import com.google.firebase.auth.FirebaseUser

data class FbResponse(

    val user: FirebaseUser? = null,
    val message: Int? = null,
)
