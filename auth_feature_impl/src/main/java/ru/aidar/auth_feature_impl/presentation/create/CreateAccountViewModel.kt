package ru.aidar.auth_feature_impl.presentation.create

import android.util.Log
import ru.aidar.auth_feature_api.domain.interfaces.CreateAccUseCases
import ru.aidar.auth_feature_impl.AuthRouter
import ru.aidar.common.base.BaseViewModel

class CreateAccountViewModel(
    private val createAccUseCases: CreateAccUseCases,
    private val router: AuthRouter,
) : BaseViewModel() {
    init {
        Log.d("ViewModelInstance", "CreateAccountViewModel")
    }
}
