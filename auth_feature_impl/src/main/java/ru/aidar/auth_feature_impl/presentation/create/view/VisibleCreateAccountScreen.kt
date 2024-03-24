package ru.aidar.auth_feature_impl.presentation.create.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.aidar.auth_feature_api.domain.wrappers.CreateAccState
import ru.aidar.auth_feature_impl.presentation.create.CreateAccountViewModel
import ru.aidar.common.compose.GpTextButtonWithAnnotatedString
import ru.aidar.common.compose.GpTextButtonWithDrawBehind
import ru.aidar.common.compose.GpTextFieldWithOnDone
import ru.aidar.common.compose.GpTextFieldWithOnNext
import ru.aidar.common.utils.AppColors
import ru.aidar.common.utils.AppFontFamily

@Composable
fun VisibleCreateAccountScreen(
    viewModel: CreateAccountViewModel,
    state: CreateAccState,
) {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .background(AppColors.AppBlack),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        GpTextFieldWithOnNext(
            modifier = Modifier,
            onValueChange = {},
            value = state.nickname,
            isError = false,
            keyboardType = KeyboardType.Text,
            // label = "stringResource(R.string.nickname)"
            label = "Nickname",
            readOnly = true,
            additionalColor = AppColors.AppYellow,
        )
        GpTextFieldWithOnNext(
            modifier = Modifier.padding(top = 20.dp),
            onValueChange = viewModel::updateEmail,
            value = state.email,
            isError = state.emailError,
            keyboardType = KeyboardType.Email,
            // label = "stringResource(R.string.email)"
            label = "Email",
        )
        GpTextFieldWithOnDone(
            modifier = Modifier.padding(top = 20.dp),
            onValueChange = viewModel::updatePassword,
            value = state.password,
            isError = state.passwordError,
            keyboardType = KeyboardType.Password,
            // label = "stringResource(R.string.password)",
            label = "Password",
            visualTransformation = PasswordVisualTransformation(),
        )

        GpTextButtonWithDrawBehind(
            modifier = Modifier.padding(top = 16.dp),
            onClick = viewModel::create,
            drawColor = AppColors.AppPink,
            cornerRadius = 6,
            horizontalPadding = 18,
            verticalPadding = 10,
            text = "Sign Up",
        )

        GpTextButtonWithAnnotatedString(
            modifier = Modifier.padding(top = 10.dp),
            onClick = viewModel::navigateToLogin,
            annotatedString =
                buildAnnotatedString {
                    pushStyle(
                        SpanStyle(
                            color = AppColors.AppWhite.copy(0.8f),
                            fontFamily = AppFontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 13.sp,
                            letterSpacing = 1.sp,
                        ),
                    )
                    append("I already have an account")
                    toAnnotatedString()
                },
        )
    }
}
