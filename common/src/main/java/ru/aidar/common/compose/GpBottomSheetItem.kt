package ru.aidar.common.compose

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.aidar.common.utils.AppColors
import ru.aidar.common.utils.AppTypography

@Composable
fun GpBottomSheetItem(
    onClick: () -> Unit,
    text: String,
) {
    // todo make clickable row
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        GpTextButton(
            modifier = Modifier,
            onClick = onClick,
            text = text,
            style = AppTypography.buttonLightTypo,
        )
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            tint = AppColors.AppWhite,
            modifier = Modifier.padding(end = 5.dp),
        )
    }
}
