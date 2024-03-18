package ru.aidar.auth_feature_impl.presentation.login

import android.util.Log
import ru.aidar.auth_feature_api.domain.interfaces.LoginUseCases
import ru.aidar.auth_feature_impl.AuthRouter
import ru.aidar.common.base.BaseViewModel

class LoginViewModel(
    private val loginUseCases: LoginUseCases,
    private val router: AuthRouter,
) : BaseViewModel() {
    fun navigateToCreate() {
        router.navigateToCreate()
    }

    init {
        Log.d("ViewModelInstance", "LoginViewModel")
    }
}
