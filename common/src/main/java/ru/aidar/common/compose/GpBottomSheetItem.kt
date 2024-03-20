package ru.aidar.common.compose

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import ru.aidar.common.utils.AppColors
import ru.aidar.common.utils.AppColors.AppWhite
import ru.aidar.common.utils.AppTypography

@Composable
fun GpBottomSheetItem(
    onClick: () -> Unit,
    text: String,
) {
    // todo make clickable row
    Row(
        modifier = Modifier.fillMaxWidth().padding(vertical = 7.dp).clickable { onClick() },
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        GpText(
            modifier = Modifier,
            text = text,
            style = AppTypography.buttonLightTypo,
            textColor = AppWhite
        )
        Icon(
            imageVector = Icons.AutoMirrored.Filled.KeyboardArrowRight,
            contentDescription = null,
            tint = AppColors.AppWhite,
            modifier = Modifier.padding(end = 5.dp),
        )
    }
}
