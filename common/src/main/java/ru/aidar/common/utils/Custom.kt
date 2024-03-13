package ru.aidar.common.utils

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import ru.aidar.common.R

object GpColors {
    val GpYellow = Color(0xFFFFEB3B)
    val GpBlue = Color(0xFF3550D6)
    val GpGreen = Color(0xFF19BD20)
    val GpRed = Color(0xFFD23917)
    val GpPink = Color(0xFFEE1DD2)
    val GpTurquoise = Color(0xFFFFFAFA)
    val GpBlack = Color(0xFF16181F)
}
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

object GpTypography {

    val titleLarge = TextStyle(
        fontSize = 28.sp,
        fontFamily = GpFontFamily,
        fontWeight = FontWeight.ExtraLight,

        )
    val menuText = TextStyle(
        fontSize = 20.sp,
        fontFamily = GpFontFamily,
        fontWeight = FontWeight.Thin,
    )
}