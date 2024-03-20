package ru.aidar.auth_feature_impl.presentation.login

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import ru.aidar.auth_feature_api.model.ScreenStatus
import ru.aidar.auth_feature_impl.presentation.login.view.VisibleLoginScreen
import ru.aidar.common.compose.GpLoadingBar

@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    val state by viewModel.state.collectAsState()

    when (state.status) {
        ScreenStatus.Visible -> {
            VisibleLoginScreen(viewModel = viewModel, state = state)
        }

        ScreenStatus.Loading -> {
            GpLoadingBar("LoginScreen")
        }
    }
}
