package ru.aidar.menu_feature_impl.presentation.view

import android.graphics.drawable.Drawable
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
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import ru.aidar.common.utils.GpColors
import ru.aidar.common.utils.GpTypography

@Composable
fun GpMainMenuItem(
    color: Color,
    onClick: () -> Unit = {},
    image: Drawable,
    text: String,
) {
    ElevatedCard(
        onClick = { onClick() },
        modifier = Modifier
            .height(170.dp)
            .padding(horizontal = 28.dp)
            .padding(top = 8.dp)
            .fillMaxWidth(),
        shape = RoundedCornerShape(25.dp),
        colors = CardDefaults.cardColors(containerColor = color),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Image(
                bitmap = image as ImageBitmap,
                contentDescription = null,
                modifier = Modifier.padding(vertical = 20.dp, horizontal = 20.dp),
            )
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = text,
                style = GpTypography.menuText.copy(
                    shadow = Shadow(
                        color = GpColors.GpBlack,
                        offset = Offset(2f, 2f),
                        blurRadius = 4f
                    )
                ),
                textAlign = TextAlign.Start
            )
        }
    }
}