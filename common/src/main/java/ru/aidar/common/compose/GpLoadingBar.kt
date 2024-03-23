package ru.aidar.common.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.aidar.common.utils.AppColors.AppWhite
import ru.aidar.common.utils.AppColors.AppYellow
import ru.aidar.common.utils.AppTypography

@Composable
fun GpLoadingBar(
    text: String,
    barColor: Color = AppYellow,
    modifier: Modifier = Modifier.fillMaxSize()
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        GpProgressIndicator(modifier = Modifier.size(50.dp), color = barColor)
        Spacer(modifier = Modifier.height(30.dp))
        GpText(
            text = text,
            modifier = Modifier.padding(top = 20.dp),
            style = AppTypography.textFieldTypo,
            textColor = AppWhite
        )
    }
}

@Composable
fun GpProgressIndicator(modifier: Modifier = Modifier, color: Color = AppYellow) {
    CircularProgressIndicator(modifier = modifier, color = color)
}
