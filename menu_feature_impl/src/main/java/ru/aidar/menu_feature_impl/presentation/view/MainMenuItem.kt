package ru.aidar.menu_feature_impl.presentation.view

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.aidar.common.utils.AppColors
import ru.aidar.common.utils.AppTypography

@Composable
fun GpMainMenuItem(
    color: Color,
    onClick: () -> Unit = {},
    @DrawableRes image: Int,
    @StringRes text: Int,
) {
    ElevatedCard(
        onClick = { onClick() },
        modifier =
            Modifier
                .height(170.dp)
                .padding(horizontal = 28.dp)
                .padding(top = 8.dp)
                .fillMaxWidth(),
        shape = RoundedCornerShape(25.dp),
        colors = CardDefaults.cardColors(containerColor = color),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
    ) {
        Row(
            modifier =
                Modifier
                    .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                painterResource(id = image),
                contentDescription = null,
                modifier = Modifier.padding(vertical = 20.dp, horizontal = 20.dp),
            )
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = stringResource(id = text),
                style =
                    AppTypography.mainMenuCardTypo.copy(
                        shadow =
                            Shadow(
                                color = AppColors.AppBlack,
                                offset = Offset(2f, 2f),
                                blurRadius = 4f,
                            ),
                    ),
                textAlign = TextAlign.Start,
            )
        }
    }
}
