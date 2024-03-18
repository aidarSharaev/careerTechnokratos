package ru.aidar.auth_feature_impl.presentation.create

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import ru.aidar.auth_feature_api.model.ScreenStatus
import ru.aidar.auth_feature_impl.presentation.create.view.VisibleCreateAccountScreen
import ru.aidar.common.compose.GpLoadingBar

@Composable
fun CreateAccountScreen(viewModel: CreateAccountViewModel) {
    val state by viewModel.state.collectAsState()

    when (state.status) {
        ScreenStatus.Visible -> {
            VisibleCreateAccountScreen(viewModel = viewModel, state = state)
        }

        ScreenStatus.Loading -> {
            GpLoadingBar()
        }
    }
}
