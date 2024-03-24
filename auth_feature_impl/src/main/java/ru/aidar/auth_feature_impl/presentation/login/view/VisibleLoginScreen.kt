package ru.aidar.auth_feature_impl.presentation.login.view

import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.aidar.auth_feature_api.domain.wrappers.LoginState
import ru.aidar.auth_feature_impl.presentation.login.LoginViewModel
import ru.aidar.common.compose.GpTextButtonWithAnnotatedString
import ru.aidar.common.compose.GpTextButtonWithDrawBehind
import ru.aidar.common.compose.GpTextFieldWithOnDone
import ru.aidar.common.compose.GpTextFieldWithOnNext
import ru.aidar.common.compose.rememberImeState
import ru.aidar.common.utils.AppColors
import ru.aidar.common.utils.AppFontFamily

@Composable
fun VisibleLoginScreen(
    viewModel: LoginViewModel,
    state: LoginState,
) {
    val imeState = rememberImeState()
    val scrollState = rememberScrollState()

    LaunchedEffect(key1 = imeState.value) {
        if (imeState.value) {
            scrollState.animateScrollTo(scrollState.maxValue, tween(300))
        }
    }
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .verticalScroll(scrollState)
                .background(AppColors.AppBlack),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        GpTextFieldWithOnNext(
            modifier = Modifier,
            onValueChange = viewModel::updateEmail,
            value = state.email,
            isError = state.emailError,
            keyboardType = KeyboardType.Email,
            label = "Email", // todo
        )
        GpTextFieldWithOnDone(
            modifier = Modifier.padding(top = 20.dp),
            onValueChange = viewModel::updatePassword,
            value = state.password,
            isError = state.passwordError, // todo
            keyboardType = KeyboardType.Password,
            label = "Password", // todo
            visualTransformation = PasswordVisualTransformation(),
        )
        GpTextButtonWithDrawBehind(
            modifier = Modifier.padding(top = 16.dp),
            onClick = viewModel::login,
            drawColor = AppColors.AppPink,
            cornerRadius = 6,
            horizontalPadding = 18,
            verticalPadding = 10,
            text = "Login",
        )
        GpTextButtonWithAnnotatedString(
            modifier = Modifier.padding(top = 10.dp),
            onClick = viewModel::navigateToCreate,
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
                    append("I don't have account. ")
                    pop()
                    pushStyle(
                        SpanStyle(
                            color = AppColors.AppWhite,
                            fontFamily = AppFontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            letterSpacing = 2.sp,
                        ),
                    )
                    append("CREATE")
                    toAnnotatedString()
                },
        )
    }
}
