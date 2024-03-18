package ru.aidar.auth_feature_impl.presentation.login

import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ru.aidar.common.compose.TextFieldWithOnDone
import ru.aidar.common.compose.TextFieldWithOnNext
import ru.aidar.common.compose.rememberImeState
import ru.aidar.common.utils.AppColors.AppBlack
import ru.aidar.common.utils.AppColors.AppPink
import ru.aidar.common.utils.AppColors.AppWhite
import ru.aidar.common.utils.AppFontFamily
import ru.aidar.common.utils.AppTypography
import ru.aidar.signin_feature_impl.R

@Composable
fun LoginScreen(viewModel: LoginViewModel) {
    var emailValue by remember {
        mutableStateOf("aidar")
    }
    var isError by remember {
        mutableStateOf(false)
    }

    val imeState = rememberImeState()
    val scrollState = rememberScrollState()

    LaunchedEffect(key1 = imeState.value) {
        if(imeState.value) {
            scrollState.animateScrollTo(scrollState.maxValue, tween(300))
        }
    }

    Column(
        modifier =
        Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(AppBlack),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        // Image(painter = , contentDescription = )
        TextFieldWithOnNext(
            modifier = Modifier,
            onValueChange = { emailValue = it },
            value = emailValue,
            isError = isError,
            keyboardType = KeyboardType.Email,
            label = "Email", // todo
        )
        TextFieldWithOnDone(
            modifier = Modifier.padding(top = 20.dp),
            onValueChange = { emailValue = it },
            value = emailValue,
            isError = isError,
            keyboardType = KeyboardType.Password,
            label = "Password", // todo
            visualTransformation = PasswordVisualTransformation(),
        )
        TextButton(
            modifier = Modifier.padding(top = 16.dp),
            onClick = viewModel::navigateToMenuGraph,
            colors = ButtonDefaults.textButtonColors(containerColor = Color.Transparent),
        ) {
            Text(
                text = stringResource(id = R.string.login),
                style = AppTypography.buttonTypo,
                color = AppWhite,
                modifier =
                Modifier
                    .drawBehind {
                        drawRoundRect(
                            AppPink,
                            cornerRadius = CornerRadius(6.dp.toPx()),
                        )
                    }
                    .padding(horizontal = 18.dp, vertical = 10.dp),
            )
        }
        TextButton(
            modifier = Modifier.padding(top = 10.dp),
            onClick = viewModel::navigateToCreate,
            colors = ButtonDefaults.textButtonColors(containerColor = Color.Transparent),
        ) {
            Text(
                buildAnnotatedString {
                    pushStyle(
                        SpanStyle(
                            color = AppWhite.copy(0.8f),
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
                            color = AppWhite,
                            fontFamily = AppFontFamily,
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            letterSpacing = 2.sp,
                        ),
                    )
                    append("CREATE")
                    toAnnotatedString()
                },
                style = AppTypography.buttonTypo,
                color = AppWhite,
                modifier = Modifier,
                /*.drawBehind {
                    drawRoundRect(
                        AppPink,
                        cornerRadius = CornerRadius(6.dp.toPx())
                    )
                }
                .padding(horizontal = 18.dp, vertical = 10.dp)*/
            )
        }
    }
}

/*@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}*/
