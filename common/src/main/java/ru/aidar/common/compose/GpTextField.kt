package ru.aidar.common.compose

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.focus.FocusManager
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.platform.SoftwareKeyboardController
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import ru.aidar.common.utils.AppColors.AppBlack
import ru.aidar.common.utils.AppColors.AppRed
import ru.aidar.common.utils.AppColors.AppWhite
import ru.aidar.common.utils.AppFontFamily
import ru.aidar.common.utils.AppTypography.textFieldTypo

@Composable
fun GpTextFieldWithOnNext(
    focusManager: FocusManager = LocalFocusManager.current,
    modifier: Modifier,
    onValueChange: (String) -> Unit,
    value: String,
    isError: Boolean,
    keyboardType: KeyboardType,
    visualTransformation: VisualTransformation = VisualTransformation.None,
    width: Float = 0.8f,
    trailingIcon: ImageVector? = null,
    trailingIconAction: () -> Unit = {},
    trailingIconActionOnEmpty: () -> Unit = {},
    trailingIconCondition: Boolean = true,
    singleLine: Boolean = true,
    textStyle: TextStyle = textFieldTypo,
    containerColor: Color = AppBlack,
    additionalColor: Color = AppWhite,
    label: String? = null,
    placeholder: String? = null,
    readOnly: Boolean = false,
    enableIndicator: Boolean = true,
) {
    GpTextField(
        modifier = modifier,
        onValueChange = onValueChange,
        value = value,
        isError = isError,
        width = width,
        singleLine = singleLine,
        textStyle = textStyle,
        keyboardOptions =
        KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = ImeAction.Next,
        ),
        keyboardActions =
        KeyboardActions(
            onNext = { focusManager.moveFocus(FocusDirection.Down) },
        ),
        visualTransformation = visualTransformation,
        containerColor = containerColor,
        additionalColor = additionalColor,
        label = label,
        placeholder = placeholder,
        readOnly = readOnly,
        enableIndicator = enableIndicator,
        trailingIcon = trailingIcon,
        trailingIconAction = trailingIconAction,
        trailingIconActionOnEmpty = trailingIconActionOnEmpty,
        trailingIconCondition = trailingIconCondition,
    )
}

@Composable
fun GpTextFieldWithOnDone(
    keyboardController: SoftwareKeyboardController? = LocalSoftwareKeyboardController.current,
    focusManager: FocusManager = LocalFocusManager.current,
    modifier: Modifier,
    onValueChange: (String) -> Unit,
    value: String,
    isError: Boolean,
    keyboardType: KeyboardType,
    additionalKeyboardAction: () -> Unit = {},
    visualTransformation: VisualTransformation = VisualTransformation.None,
    width: Float = 0.8f,
    trailingIcon: ImageVector? = null,
    trailingIconAction: () -> Unit = {},
    trailingIconActionOnEmpty: () -> Unit = {},
    trailingIconCondition: Boolean = true,
    singleLine: Boolean = true,
    textStyle: TextStyle = textFieldTypo,
    containerColor: Color = AppBlack,
    additionalColor: Color = AppWhite,
    label: String? = null,
    placeholder: String? = null,
    readOnly: Boolean = false,
    enableIndicator: Boolean = true,
) {
    GpTextField(
        modifier = modifier,
        onValueChange = onValueChange,
        value = value,
        isError = isError,
        width = width,
        readOnly = readOnly,
        singleLine = singleLine,
        textStyle = textStyle,
        keyboardOptions =
        KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = ImeAction.Done,
        ),
        keyboardActions =
        KeyboardActions(onDone = {
            keyboardController?.hide()
            additionalKeyboardAction()
            focusManager.clearFocus()
        }),
        visualTransformation = visualTransformation,
        containerColor = containerColor,
        additionalColor = additionalColor,
        label = label,
        placeholder = placeholder,
        enableIndicator = enableIndicator,
        trailingIcon = trailingIcon,
        trailingIconAction = trailingIconAction,
        trailingIconActionOnEmpty = trailingIconActionOnEmpty,
        trailingIconCondition = trailingIconCondition,
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
    trailingIcon: ImageVector? = null,
    trailingIconAction: () -> Unit = {},
    trailingIconActionOnEmpty: () -> Unit = {},
    containerColor: Color = AppBlack,
    additionalColor: Color = AppWhite,
    label: String? = null,
    placeholder: String? = null,
    readOnly: Boolean = false,
    enableIndicator: Boolean = true,
    trailingIconCondition: Boolean = true,
) {
    OutlinedTextField(
        modifier = modifier.fillMaxWidth(width),
        value = value,
        singleLine = singleLine,
        onValueChange = { onValueChange(it) },
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        textStyle = textStyle,
        readOnly = readOnly,
        visualTransformation = visualTransformation,
        placeholder = {
            placeholder?.let {
                Text(
                    text = placeholder,
                    color = additionalColor.copy(0.3f),
                    fontFamily = AppFontFamily,
                )
            }
        },
        trailingIcon = {
            trailingIcon?.let {
                if (trailingIconCondition)
                IconButton(onClick = {
                    if(value.isEmpty()) trailingIconActionOnEmpty()
                    else trailingIconAction()

                }) {
                    Icon(
                        imageVector = trailingIcon,
                        contentDescription = "Close Icon",
                        tint = Color.White,
                    )
                }
            }
        },
        label = {
            label?.let {
                Text(
                    text = label,
                    fontFamily = AppFontFamily,
                )
            }
        },
        colors =
        TextFieldDefaults.colors(
            focusedIndicatorColor = if(enableIndicator) additionalColor.copy(0.8f) else Color.Transparent,
            unfocusedIndicatorColor = if(enableIndicator) additionalColor.copy(0.3f) else Color.Transparent,
            focusedTextColor = additionalColor,
            unfocusedTextColor = additionalColor.copy(0.85f),
            focusedLabelColor = additionalColor.copy(0.8f),
            unfocusedLabelColor = additionalColor.copy(0.3f),
            focusedContainerColor = containerColor,
            unfocusedContainerColor = containerColor,
            errorIndicatorColor = if(enableIndicator) AppRed else Color.Transparent,
            errorContainerColor = containerColor,
            errorTextColor = AppRed,
        ),
        isError = isError,
    )
}
