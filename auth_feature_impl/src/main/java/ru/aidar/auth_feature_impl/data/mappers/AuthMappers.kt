package ru.aidar.auth_feature_impl.data.mappers

import ru.aidar.auth_feature_api.domain.interfaces.model.AuthResponse
import ru.aidar.common.core.auth.model.FbResponse
import javax.inject.Inject

class AuthMappers
    @Inject
    constructor() {
        fun fbResponseToAuthResponse(response: FbResponse): AuthResponse {
            val instance = response.user?.let { true } ?: false
            val message = if (!instance) response.message else null
            return AuthResponse(instance = instance, number = message)
        }
    }
