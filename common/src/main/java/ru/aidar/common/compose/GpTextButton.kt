package ru.aidar.common.compose

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import ru.aidar.common.utils.AppColors.AppWhite
import ru.aidar.common.utils.AppTypography

@Composable
fun GpTextButtonWithAnnotatedString(
    modifier: Modifier,
    onClick: () -> Unit,
    annotatedString: AnnotatedString,
) {
    TextButton(
        modifier = modifier,
        onClick = onClick,
    ) {
        Text(
            text = annotatedString,
        )
    }
}

@Composable
fun GpTextButton(
    modifier: Modifier,
    onClick: () -> Unit,
    text: String,
    textColor: Color = AppWhite,
    style: TextStyle = AppTypography.buttonMediumTypo,
) {
    TextButton(
        modifier = modifier,
        onClick = onClick,
    ) {
        GpText(
            text = text,
            modifier = modifier,
            style = style,
            textColor = textColor,
        )
    }
}

@Composable
fun GpTextButtonWithDrawBehind(
    modifier: Modifier,
    onClick: () -> Unit,
    drawColor: Color,
    cornerRadius: Int,
    horizontalPadding: Int,
    verticalPadding: Int,
    text: String,
    textColor: Color = AppWhite,
    style: TextStyle = AppTypography.buttonMediumTypo,
) {
    TextButton(
        modifier = modifier,
        onClick = onClick,
    ) {
        GpText(
            text = text,
            style = style,
            textColor = textColor,
            modifier =
                Modifier
                    .drawBehind {
                        drawRoundRect(
                            drawColor,
                            cornerRadius = CornerRadius(cornerRadius.dp.toPx()),
                        )
                    }
                    .padding(horizontal = horizontalPadding.dp, vertical = verticalPadding.dp),
        )
    }
}
