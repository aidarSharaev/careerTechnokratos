package ru.aidar.careertechnokratos

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

val GpFontFamily = FontFamily(

    Font(R.font.gp_bold, FontWeight.Bold),
    Font(R.font.gp_extra_bold, FontWeight.ExtraBold),
    Font(R.font.gp_semi_bold, FontWeight.SemiBold),

    Font(R.font.gp_medium, FontWeight.Medium),
    Font(R.font.gp_regular, FontWeight.Normal),

    Font(R.font.gp_light, FontWeight.Light),
    Font(R.font.gp_extra_light, FontWeight.ExtraLight),
    Font(R.font.gp_thin, FontWeight.Thin),
)

// Set of Material typography styles to start with
object GpTypography {
    val titleLarge = TextStyle(
        fontSize = 24.sp,
        fontFamily = GpFontFamily,
        fontWeight = FontWeight.Bold,
    )
}