package ru.aidar.common.compose_component

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import ru.aidar.common.utils.AppTypography.dropDownMenuTypo

@Composable
fun ComponentDropDownMenuText(text: String) {
    Text(text = text, style = dropDownMenuTypo)
}
