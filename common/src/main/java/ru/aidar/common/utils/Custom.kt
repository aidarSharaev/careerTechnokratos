package ru.aidar.common.utils

import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.BaselineShift
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import ru.aidar.common.R
import ru.aidar.common.utils.AppColors.AppWhite

object AppColors {
    val AppYellow = Color(0xFFFFEB3B)
    val AppBlue = Color(0xFF3550D6)
    val AppGreen = Color(0xFF19BD20)
    val AppRed = Color(0xFFD23917)
    val AppPink = Color(0xFFEE1DD2)
    val AppTurquoise = Color(0xFFFFFAFA)
    val AppBlack = Color(0xFF16181F)
    val AppDarkGreenBlue = Color(0xFF022027)
    val AppWhite = Color(0xFFFFFFFF)
}

val AppFontFamily =
    FontFamily(
        Font(R.font.gp_bold, FontWeight.Bold),
        Font(R.font.gp_extra_bold, FontWeight.ExtraBold),
        Font(R.font.gp_semi_bold, FontWeight.SemiBold),
        Font(R.font.gp_medium, FontWeight.Medium),
        Font(R.font.gp_regular, FontWeight.Normal),
        Font(R.font.gp_light, FontWeight.Light),
        Font(R.font.gp_extra_light, FontWeight.ExtraLight),
        Font(R.font.gp_thin, FontWeight.Thin),
    )

object AppTypography {
    val titleLargeTypo =
        TextStyle(
            fontSize = 28.sp,
            fontFamily = AppFontFamily,
            fontWeight = FontWeight.Light,
            brush =
            Brush.horizontalGradient(
                colors =
                listOf(
                    AppColors.AppRed,
                    AppColors.AppPink,
                    AppColors.AppGreen,
                    AppColors.AppYellow,
                ),
            ),
        )

    val mainMenuCardTypo =
        TextStyle(
            fontSize = 20.sp,
            fontFamily = AppFontFamily,
            fontWeight = FontWeight.Thin,
        )

    val detailInfoTypo =
        TextStyle(
            fontSize = 18.sp,
            fontFamily = AppFontFamily,
            fontWeight = FontWeight.Thin,
        )

    val spanDetailInfoTypo =
        SpanStyle(
            fontSize = 18.sp,
            color = AppWhite,
            fontFamily = AppFontFamily,
            fontWeight = FontWeight.Thin,
        )
    val spanSuperScriptDetailInfoTypo =
        SpanStyle(
            color = AppWhite,
            fontSize = 14.sp,
            fontFamily = AppFontFamily,
            fontWeight = FontWeight.ExtraLight,
            baselineShift = BaselineShift.Superscript,
        )

    val textFieldTypo =
        TextStyle(
            fontFamily = AppFontFamily,
            fontSize = 18.sp,
        )

    val buttonMediumTypo =
        TextStyle(
            fontSize = 18.sp,
            fontFamily = AppFontFamily,
            fontWeight = FontWeight.Medium,
        )

    val buttonLightTypo =
        TextStyle(
            fontSize = 18.sp,
            fontFamily = AppFontFamily,
            fontWeight = FontWeight.Light,
        )

    val labelTypo =
        TextStyle(
            fontFamily = AppFontFamily,
            fontWeight = FontWeight.Light,
            color = AppWhite,
        )

    val messageTextTypo =
        TextStyle(
            fontFamily = AppFontFamily,
            fontWeight = FontWeight.Medium,
            fontSize = 15.sp,
            textAlign = TextAlign.Start
        )
}
