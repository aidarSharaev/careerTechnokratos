package ru.aidar.auth_feature_impl

interface AuthRouter {
    fun navigateToCreate()

    fun navigateToLogin()

    fun navigateToMenuGraph(
        graphId: Int,
        uri: String,
    )
}
