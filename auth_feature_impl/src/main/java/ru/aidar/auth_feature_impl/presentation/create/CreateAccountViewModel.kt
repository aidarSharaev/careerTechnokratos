package ru.aidar.auth_feature_impl.presentation.create

import android.util.Log
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.launch
import ru.aidar.auth_feature_api.domain.interfaces.CreateAccUseCases
import ru.aidar.auth_feature_api.domain.wrappers.CreateAccStateWrapper
import ru.aidar.auth_feature_api.model.ScreenStatus
import ru.aidar.auth_feature_impl.AuthRouter
import ru.aidar.common.base.BaseViewModel
import ru.aidar.common.core.auth.model.ErrorTypes
import ru.aidar.signin_feature_impl.R
import kotlin.coroutines.CoroutineContext

class CreateAccountViewModel(
    private val createAccUseCases: CreateAccUseCases,
    private val router: AuthRouter,
    private val wrapper: CreateAccStateWrapper,
) : BaseViewModel(), CoroutineScope {
    override val coroutineContext: CoroutineContext
        get() = SupervisorJob() + CoroutineName("CreateAccountViewModel")

    init {
        Log.d("ViewModelInstance", "init CreateAccountViewModel")
    }

    val state = wrapper.flow()

    fun navigateToLogin() {
        router.navigateToLogin()
    }

    private fun navigateToMenuGraph() {
        router.navigateToMenuGraph(R.id.auth_graph, "gpapp://menu_destination")
    }

    private fun updateNickname(name: String) {
        wrapper.updateNickname(name = name.split('@').first())
    }

    fun updateEmail(email: String) {
        if (state.value.emailError) wrapper.showFullError(false)
        updateNickname(name = email)
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

    fun create() {
        with(state.value) {
            if (email.isNotBlank() && password.isNotBlank()) {
                updateStatus(status = ScreenStatus.Loading)
                viewModelScope.launch {
                    val result =
                        createAccUseCases.createUserWithEmailAndPassword(
                            email = email,
                            password = password,
                            nickname = nickname,
                        )
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

    private fun showEmptyFields(
        param1: Boolean,
        param2: Boolean,
    ) {
        if (param1) wrapper.showEmailError()
        if (param2) wrapper.showPasswordError()
    }

    override fun onCleared() {
        coroutineContext.cancelChildren()
        Log.d("ViewModelInstance", "clear CreateAccountViewModel")
        super.onCleared()
    }
}
