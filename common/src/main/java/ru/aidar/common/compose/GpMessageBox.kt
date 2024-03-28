package ru.aidar.common.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.aidar.common.utils.AppColors.AppBlue
import ru.aidar.common.utils.AppColors.AppWhite
import ru.aidar.common.utils.AppTypography.messageTextTypo

private const val APP_IS_AUTHOR = 0

@Composable
fun GpMessageBox(
    text: String,
    author: Int,
    action: Boolean = false,
    actionText: String = "",
    width: Int,
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    boxColor: Color = AppBlue,
    corner: Int = 15,
    topVertPadd: Int = 8,
    bottomVertPadd: Int = 10,
    horPadd: Int = 15,
    style: TextStyle = messageTextTypo,
    textColor: Color = AppWhite,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalArrangement = if(author == APP_IS_AUTHOR) Arrangement.Start else Arrangement.End
    ) {
        if(!action) {
            MessageBoxContent(
                width = width,
                author = author,
                text = text,
                modifier = modifier,
                textModifier = textModifier,
                boxColor = boxColor,
                corner = corner,
                topVertPadd = topVertPadd,
                bottomVertPadd = bottomVertPadd,
                horPadd = horPadd,
                style = style,
                textColor = textColor,
            )
        } else {
            MessageBoxWithAction(actionText = actionText, width = width, text = text)
        }
    }
}

@Composable
fun MessageBoxWithAction(
    text: String,
    actionText: String,
    width: Int,
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    boxColor: Color = AppBlue,
    corner: Int = 15,
    topVertPadd: Int = 8,
    bottomVertPadd: Int = 10,
    horPadd: Int = 15,
    style: TextStyle = messageTextTypo,
    textColor: Color = AppWhite,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 10.dp),
        horizontalArrangement = Arrangement.Start
    ) {
        var surfaceWidth by remember {
            mutableIntStateOf(0)
        }
        Column(
            Modifier.widthIn(max = width.dp)
        ) {
            MessageBoxContent(
                width = width,
                author = APP_IS_AUTHOR,
                onSizeChanged = { surfaceWidth = it },
                text = text,
                modifier = modifier,
                isBottomAction = true,
                textModifier = textModifier,
                boxColor = boxColor,
                corner = corner,
                topVertPadd = topVertPadd,
                bottomVertPadd = bottomVertPadd,
                horPadd = horPadd,
                style = style,
                textColor = textColor,
            )
            MessageBoxAction(
                //modifier = Modifier.weight(1f),
                width = width,
                actionText = actionText,
            )
        }
    }
}

@Composable
fun MessageBoxContent(
    text: String,
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    width: Int,
    author: Int,
    isBottomAction: Boolean? = null,
    onSizeChanged: (Int) -> Unit = {},
    boxColor: Color = AppBlue,
    corner: Int = 15,
    topVertPadd: Int = 8,
    bottomVertPadd: Int = 10,
    horPadd: Int = 15,
    style: TextStyle = messageTextTypo,
    textColor: Color = AppWhite,
) {

    Surface(
        modifier
            .clip(
                shape = RoundedCornerShape(
                    topStart = corner.dp,
                    topEnd = corner.dp,
                    bottomEnd = if(author == 0 && isBottomAction == null) corner.dp else 0.dp,
                    bottomStart = if(author == 1) corner.dp else 0.dp,
                )
            )
            .widthIn(max = width.dp)
            .onSizeChanged {
                onSizeChanged(it.width)
            },
        color = boxColor
    ) {
        Text(
            modifier = textModifier.padding(
                top = topVertPadd.dp,
                bottom = bottomVertPadd.dp,
                start = horPadd.dp,
                end = horPadd.dp,
            ),
            text = text,
            color = textColor,
            style = style,
        )
    }
}

@Composable
fun MessageBoxAction(

    actionText: String,
    modifier: Modifier = Modifier,
    textModifier: Modifier = Modifier,
    width: Int,
    boxColor: Color = AppBlue,
    corner: Int = 15,
    topVertPadd: Int = 8,
    bottomVertPadd: Int = 10,
    horPadd: Int = 15,
    style: TextStyle = messageTextTypo,
    textColor: Color = AppWhite,
) {
    Surface(
        modifier
            .padding(top = 5.dp)
            .clip(
                shape = RoundedCornerShape(
                    topStart = 0.dp,
                    topEnd = 0.dp,
                    bottomEnd = corner.dp,
                    bottomStart = corner.dp,
                )
            )
            .width(width.dp)
            .clickable {},
        color = boxColor.copy(0.7f),
    ) {
        Text(
            modifier = textModifier.padding(
                top = topVertPadd.dp,
                bottom = bottomVertPadd.dp,
                start = horPadd.dp,
                end = horPadd.dp,
            ),
            text = actionText,
            color = textColor,
            style = style,
            textAlign = TextAlign.Center
        )
    }
}



