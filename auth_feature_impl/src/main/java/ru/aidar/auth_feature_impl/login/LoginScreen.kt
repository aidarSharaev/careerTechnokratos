package ru.aidar.auth_feature_impl.login

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
import androidx.compose.ui.tooling.preview.Preview
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
fun LoginScreen() {

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
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scrollState)
            .background(AppBlack),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        //Image(painter = , contentDescription = )
        TextFieldWithOnNext(
            modifier = Modifier,
            onValueChange = { emailValue = it },
            value = emailValue,
            isError = isError,
            keyboardType = KeyboardType.Email,
            label = "Email" // todo
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
        /*        OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(0.8f),
                    value = emailValue,
                    singleLine = true,
                    onValueChange = { emailValue = it },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email, imeAction = ImeAction.Next),
                    keyboardActions = KeyboardActions(),
                    textStyle = textFieldTypo,
                    label = { Text(text = "Email", color = AppWhite, fontFamily = AppFontFamily) },
                    colors = TextFieldDefaults.colors(
                        focusedIndicatorColor = AppWhite.copy(0.8f),
                        unfocusedIndicatorColor = AppWhite.copy(0.3f),

                        focusedTextColor = AppWhite,
                        unfocusedTextColor = AppWhite.copy(0.85f),

                        focusedLabelColor = AppWhite.copy(0.7f),
                        unfocusedLabelColor = AppWhite.copy(0.3f),

                        focusedContainerColor = AppBlack,
                        unfocusedContainerColor = AppBlack,
                    ),)*/
        /*OutlinedTextField(
            modifier = Modifier
                .width(IntrinsicSize.Min)
                .padding(top = 20.dp),
            value = "123312",
            onValueChange = {},
            textStyle = textFieldTypo,
            visualTransformation = PasswordVisualTransformation(),
            label = { Text(text = "Password", color = AppWhite, fontFamily = AppFontFamily) },
            colors = TextFieldDefaults.colors(
                focusedIndicatorColor = AppWhite,
                unfocusedIndicatorColor = AppWhite.copy(0.3f),

                focusedLabelColor = AppWhite.copy(0.7f),
                unfocusedLabelColor = AppWhite.copy(0.3f),

                focusedContainerColor = AppBlack,
                unfocusedContainerColor = AppBlack,
            ),
        )*/
        TextButton(
            modifier = Modifier.padding(top = 16.dp),
            onClick = {},
            colors = ButtonDefaults.textButtonColors(containerColor = Color.Transparent)
        ) {
            Text(
                text = stringResource(id = R.string.login),
                style = AppTypography.buttonTypo,
                color = AppWhite,
                modifier = Modifier
                    .drawBehind {
                        drawRoundRect(
                            AppPink,
                            cornerRadius = CornerRadius(6.dp.toPx())
                        )
                    }
                    .padding(horizontal = 18.dp, vertical = 10.dp)
            )
        }
        TextButton(
            modifier = Modifier.padding(top = 10.dp),
            onClick = {},
            colors = ButtonDefaults.textButtonColors(containerColor = Color.Transparent)
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
                        )
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
                        )
                    )
                    append("CREATE")
                    toAnnotatedString()
                },
                style = AppTypography.buttonTypo,
                color = AppWhite,
                modifier = Modifier
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


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}