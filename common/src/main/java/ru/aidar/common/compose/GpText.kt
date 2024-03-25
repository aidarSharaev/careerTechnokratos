package ru.aidar.common.compose

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.aidar.common.utils.AppColors
import ru.aidar.common.utils.AppFontFamily

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

@Composable
fun GpTextBrush(
    text: String,
    modifier: Modifier,
    style: TextStyle,
) {
    Text(
        text = text,
        modifier = modifier,
        style = style,
    )
}

@Composable
fun GpAnnotatedTextWithConstStyle(
    param1: String,
    param2: String,
) {
    Text(text = buildAnnotatedString {
        pushStyle(
            SpanStyle(
                color = AppColors.AppWhite.copy(0.8f),
                fontFamily = AppFontFamily,
                fontWeight = FontWeight.Thin,
                fontSize = 14.sp
            )
        )
        append(param1)
        pop()
        pushStyle(
            SpanStyle(
                color = AppColors.AppWhite,
                fontFamily = AppFontFamily,
                fontWeight = FontWeight.Thin,
                fontSize = 14.sp
            )
        )
        append(param2)
        pop()
    })
}

@Composable
fun GpAnnotatedText(
    text: AnnotatedString,
    modifier: Modifier,
) {
    Text(text = text, modifier = modifier)
}
