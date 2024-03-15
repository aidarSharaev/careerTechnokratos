package ru.aidar.common.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import ru.aidar.common.utils.AppColors.AppBlack
import ru.aidar.common.utils.AppColors.AppWhite
import ru.aidar.common.utils.AppFontFamily
import ru.aidar.common.utils.AppTypography.textFieldTypo

@Composable
fun TextFieldWithOnNext(
    focusManager: FocusManager = LocalFocusManager.current,
    modifier: Modifier,
    onValueChange: (String) -> Unit,
    value: String,
    isError: Boolean,
    keyboardType: KeyboardType,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    width: Float = 0.8f,
    singleLine: Boolean = true,
    textStyle: TextStyle = textFieldTypo,
    containerColor: Color = AppBlack,
    additionalColor: Color = AppWhite,
    label: String? = null,
    placeholder: String? = null,
) {
    GpTextField(
        modifier = modifier,
        onValueChange = onValueChange,
        value = value,
        isError = isError,
        width = width,
        singleLine = singleLine,
        textStyle = textStyle,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = ImeAction.Next
        ),
        keyboardActions = KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Down) }
        ),
        visualTransformation = visualTransformation,
        containerColor = containerColor,
        additionalColor = additionalColor,
        label = label,
        placeholder = placeholder,
    )
}

@Composable
fun TextFieldWithOnDone(
    keyboardController: SoftwareKeyboardController? = LocalSoftwareKeyboardController.current,
    focusManager: FocusManager = LocalFocusManager.current,
    modifier: Modifier,
    onValueChange: (String) -> Unit,
    value: String,
    isError: Boolean,
    keyboardType: KeyboardType,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    width: Float = 0.8f,
    singleLine: Boolean = true,
    textStyle: TextStyle = textFieldTypo,
    containerColor: Color = AppBlack,
    additionalColor: Color = AppWhite,
    label: String? = null,
    placeholder: String? = null,
) {
    GpTextField(
        modifier = modifier,
        onValueChange = onValueChange,
        value = value,
        isError = isError,
        width = width,
        singleLine = singleLine,
        textStyle = textStyle,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = ImeAction.Done
        ),
        keyboardActions = KeyboardActions(onDone = {
            keyboardController?.hide()
            focusManager.clearFocus()
        }),
        visualTransformation = visualTransformation,
        containerColor = containerColor,
        additionalColor = additionalColor,
        label = label,
        placeholder = placeholder,
    )
}

@Composable
fun GpTextField(
    modifier: Modifier,
    onValueChange: (String) -> Unit,
    value: String,
    isError: Boolean,
    width: Float = 0.8f,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    singleLine: Boolean = true,
    textStyle: TextStyle = textFieldTypo,
    keyboardActions: KeyboardActions,
    keyboardOptions: KeyboardOptions,
    containerColor: Color = AppBlack,
    additionalColor: Color = AppWhite,
    label: String? = null,
    placeholder: String? = null,
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(width),
        value = value,
        singleLine = singleLine,
        onValueChange = { onValueChange(it) },
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        textStyle = textStyle,
        visualTransformation = visualTransformation,
        placeholder = {
            placeholder?.let {
                Text(
                    text = placeholder,
                    color = additionalColor.copy(0.3f),
                    fontFamily = AppFontFamily
                )
            }
        },
        label = {
            label?.let {
                Text(
                    text = label,
                    //color = additionalColor.copy(0.5f),
                    fontFamily = AppFontFamily
                )
            }
        },
        colors = TextFieldDefaults.colors(
            focusedIndicatorColor = additionalColor.copy(0.8f),
            unfocusedIndicatorColor = additionalColor.copy(0.3f),

            focusedTextColor = additionalColor,
            unfocusedTextColor = additionalColor.copy(0.85f),

            focusedLabelColor = additionalColor.copy(0.8f),
            unfocusedLabelColor = additionalColor.copy(0.3f),

            focusedContainerColor = containerColor,
            unfocusedContainerColor = containerColor,
        ),
        isError = isError,
    )
}