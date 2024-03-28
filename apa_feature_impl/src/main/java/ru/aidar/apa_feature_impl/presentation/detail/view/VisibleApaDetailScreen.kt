package ru.aidar.apa_feature_impl.presentation.detail.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.unit.dp
import ru.aidar.apa_feature_impl.data.model.ParcelableApa
import ru.aidar.apa_feature_impl.presentation.detail.ApaDetailViewModel
import ru.aidar.common.compose.GpAnnotatedText
import ru.aidar.common.compose.GpText
import ru.aidar.common.utils.AppColors
import ru.aidar.common.utils.AppColors.AppBlack
import ru.aidar.common.utils.AppColors.AppWhite
import ru.aidar.common.utils.AppTypography
import ru.aidar.common.utils.AppTypography.spanDetailInfoTypo
import ru.aidar.common.utils.AppTypography.spanSuperScriptDetailInfoTypo

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VisibleApaDetailScreen(
    viewModel: ApaDetailViewModel,
    apa: ParcelableApa,
) {
    Scaffold(
        containerColor = AppBlack,
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Information",
                        style = AppTypography.titleLargeTypo,
                    )
                },
                colors =
                    TopAppBarDefaults.topAppBarColors(
                        containerColor = AppBlack,
                        navigationIconContentColor = AppColors.AppRed,
                        actionIconContentColor = AppColors.AppYellow,
                    ),
                navigationIcon = {
                    IconButton(onClick = viewModel::navigateUp) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description",
                        )
                    }
                },
            )
        },
    ) {
        Column(
            modifier =
                Modifier
                    .padding(it)
                    .fillMaxSize()
                    .background(AppBlack)
                    .padding(start = 30.dp),
        ) {
            GpText(
                text = "Name: ${apa.name}",
                modifier = Modifier.padding(top = 50.dp),
                style = AppTypography.detailInfoTypo,
                textColor = AppWhite,
            )
            Spacer(modifier = Modifier.height(20.dp))
            GpText(
                text = "Is it a planet?: ${apa.isPlanet}",
                modifier = Modifier,
                style = AppTypography.detailInfoTypo,
                textColor = AppWhite,
            )
            Spacer(modifier = Modifier.height(20.dp))
            GpText(
                text = "Discovered by: ${apa.discoveredBy ?: "Unknown"}",
                modifier = Modifier,
                style = AppTypography.detailInfoTypo,
                textColor = AppWhite,
            )
            Spacer(modifier = Modifier.height(20.dp))
            GpText(
                text = "Discovered date: ${apa.discoveryDate ?: "Unknown"}",
                style = AppTypography.detailInfoTypo,
                modifier = Modifier,
                textColor = AppWhite,
            )
            Spacer(modifier = Modifier.height(20.dp))
            GpText(
                text = "Characteristic:",
                modifier = Modifier,
                style = AppTypography.detailInfoTypo,
                textColor = AppWhite,
            )
            Column(
                modifier =
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 20.dp),
            ) {
                GpAnnotatedText(
                    text =
                        buildAnnotatedString {
                            pushStyle(spanDetailInfoTypo)
                            append("Mass: ${apa.massValue}")
                            pop()
                            pushStyle(spanSuperScriptDetailInfoTypo)
                            append(apa.massExponent)
                        },
                    modifier = Modifier.padding(top = 15.dp),
                )
                GpAnnotatedText(
                    text =
                        buildAnnotatedString {
                            pushStyle(spanDetailInfoTypo)
                            append("Volume: ${apa.volValue}")
                            pop()
                            pushStyle(spanSuperScriptDetailInfoTypo)
                            append(apa.volExponent)
                        },
                    modifier = Modifier.padding(top = 15.dp),
                )
            }
            GpText(
                text = "Moons:",
                modifier = Modifier.padding(top = 20.dp),
                style = AppTypography.detailInfoTypo,
                textColor = AppWhite,
            )
            /*Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
        ) {

        }*/
        }
    }
}

// @Preview
// @Composable
// fun VisibleApaDetailScreenPreview() {
//    VisibleApaDetailScreen()
// }
