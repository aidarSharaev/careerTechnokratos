package ru.aidar.auth_feature_impl.presentation.login

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import ru.aidar.auth_feature_api.domain.interfaces.LoginUseCases
import ru.aidar.auth_feature_api.domain.wrappers.LoginStateWrapper
import ru.aidar.auth_feature_api.model.ScreenStatus
import ru.aidar.auth_feature_impl.AuthRouter
import ru.aidar.auth_feature_impl.R
import ru.aidar.common.base.BaseViewModel
import ru.aidar.common.core.auth.model.ErrorTypes
import kotlin.coroutines.CoroutineContext

class LoginViewModel(
    private val loginUseCases: LoginUseCases,
    private val router: AuthRouter,
    private val wrapper: LoginStateWrapper,
) : BaseViewModel(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = SupervisorJob() + CoroutineName("LoginViewModel")

    val state = wrapper.flow()

    init {
        Log.d("ViewModelInstance", "init LoginViewModel ${state.value.status}")
    }

    fun navigateToCreate() {
        router.navigateToCreate()
    }

    private fun navigateToMenuGraph() {
        router.navigateToMenuGraph(R.id.auth_graph, "gpapp://menu_destination")
    }

    fun updateEmail(email: String) {
        if (state.value.emailError) wrapper.showFullError(false)
        wrapper.updateEmail(email = email)
    }

    fun updatePassword(password: String) {
        if (state.value.passwordError) wrapper.showFullError(false)
        wrapper.updatePassword(password = password)
    }

    private fun updateStatus(status: ScreenStatus) {
        wrapper.updateStatus(status = status)
    }

    private fun showError(message: Int?) {
        if (message == ErrorTypes.LOGIN_ERROR.number) {
            wrapper.showEmailError()
        } else if (message == ErrorTypes.PASSWORD_ERROR.number) {
            wrapper.showFullError(value = true)
        }
    }

    private fun hideError() {
        wrapper.showFullError(value = false)
    }

    private fun showEmptyFields(
        param1: Boolean,
        param2: Boolean,
    ) {
        if (param1) wrapper.showEmailError()
        if (param2) wrapper.showPasswordError()
    }

    fun login() {
        with(state.value) {
            if (email.isNotBlank() && password.isNotBlank()) {
                updateStatus(status = ScreenStatus.Loading)
                viewModelScope.launch {
                    val result =
                        loginUseCases.signInWithEmailAndPassword(email = email, password = password)
                    if (result.instance) {
                        navigateToMenuGraph()
                    } else {
                        updateStatus(status = ScreenStatus.Visible)
                        showError(message = result.number)
                    }
                }
            } else {
                showEmptyFields(email.isBlank(), password.isBlank())
            }
        }
    }

    override fun onCleared() {
        coroutineContext.cancelChildren()
        Log.d("ViewModelInstance", "clear LoginViewModel")
        super.onCleared()
    }
}
