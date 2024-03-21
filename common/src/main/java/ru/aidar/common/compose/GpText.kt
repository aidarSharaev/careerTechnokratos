package ru.aidar.common.compose

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle

@Composable
fun GpText(
    text: String,
    modifier: Modifier,
    style: TextStyle,
    textColor: Color,
) {
    Text(
        text = text,
        modifier = modifier,
        style = style,
        color = textColor,
    )
}
