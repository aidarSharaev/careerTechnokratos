package ru.aidar.auth_feature_impl.presentation.create

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
import ru.aidar.common.compose.GpTextButtonWithAnnotatedString
import ru.aidar.common.compose.GpTextButtonWithDrawBehind
import ru.aidar.common.compose.TextFieldWithOnDone
import ru.aidar.common.compose.TextFieldWithOnNext
import ru.aidar.common.utils.AppColors
import ru.aidar.common.utils.AppColors.AppPink
import ru.aidar.common.utils.AppFontFamily

@Composable
fun CreateAccountScreen(viewModel: CreateAccountViewModel) {
    Column(
        modifier =
            Modifier
                .fillMaxSize()
                .background(AppColors.AppBlack),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TextFieldWithOnNext(
            modifier = Modifier,
            onValueChange = { },
            value = "nickname",
            isError = false,
            keyboardType = KeyboardType.Text,
            // label = "stringResource(R.string.nickname)"
            label = "Nickname",
        )
        TextFieldWithOnNext(
            modifier = Modifier.padding(top = 20.dp),
            onValueChange = { },
            value = "emailValue",
            isError = false,
            keyboardType = KeyboardType.Email,
            // label = "stringResource(R.string.email)"
            label = "Email",
        )
        TextFieldWithOnDone(
            modifier = Modifier.padding(top = 20.dp),
            onValueChange = { },
            value = "emailValue",
            isError = false,
            keyboardType = KeyboardType.Password,
            // label = "stringResource(R.string.password)",
            label = "Password",
            visualTransformation = PasswordVisualTransformation(),
        )

        GpTextButtonWithDrawBehind(
            modifier = Modifier.padding(top = 16.dp),
            onClick = { /*TODO*/ },
            drawColor = AppPink,
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

/*
@Preview(showBackground = true)
@Composable
fun CreateAccountScreenPreview() {
    CreateAccountScreen()
}
*/
