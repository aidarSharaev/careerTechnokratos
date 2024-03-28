package ru.aidar.common.compose

import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import ru.aidar.common.utils.AppColors.AppGreen
import ru.aidar.common.utils.AppColors.AppRed

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GpDatePicker(
    onDismissRequest: () -> Unit,
    onConfirmRequest: () -> Unit,
    dismissText: String = "Cancel",
    confirmText: String = "Ok",
    dismissColor: Color = AppRed,
    confirmColor: Color = AppGreen,
    state: DatePickerState,
) {

    DatePickerDialog(
        onDismissRequest = onDismissRequest,
        confirmButton = {
            GpButton(
                buttonColor = confirmColor,
                modifier = Modifier,
                onClick = {
                    onConfirmRequest()
                    onDismissRequest()
                },
                text = confirmText,
            )
        },
        dismissButton = {
            GpButton(
                buttonColor = dismissColor,
                modifier = Modifier,
                onClick = onDismissRequest,
                text = dismissText,
            )
        },
    ) {
        DatePicker(state = state)
    }
}