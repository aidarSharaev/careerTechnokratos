package ru.aidar.menu_feature_impl.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.aidar.common.utils.GpColors
import ru.aidar.common.utils.GpColors.GpGreen
import ru.aidar.common.utils.GpColors.GpPink
import ru.aidar.common.utils.GpColors.GpRed
import ru.aidar.common.utils.GpColors.GpYellow
import ru.aidar.common.utils.GpTypography
import ru.aidar.menu_feature_impl.R
import ru.aidar.menu_feature_impl.presentation.MainMenuViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainMenuScreen(
    viewModel: MainMenuViewModel
) {
    Scaffold(
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                        style = GpTypography.titleLarge.copy(
                            shadow = Shadow(
                                color = GpColors.GpBlack,
                                offset = Offset(2f, 2f),
                                blurRadius = 4f
                            )
                        )
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = GpColors.GpBlack,
                    navigationIconContentColor = GpColors.GpTurquoise,
                    titleContentColor = GpColors.GpTurquoise,
                    actionIconContentColor = GpColors.GpTurquoise,
                ),
                actions = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = viewModel.resourceManager.getDrawable(ru.aidar.common.R.drawable.ic_sun) ,
                            contentDescription = "Localized description",
                            modifier = Modifier.size(35.dp),
                            //modifier = Modifier.padding(end = 5.dp)
                        )
                    }
                },
            )
        },
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
                // todo check
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal),
                )
                .background(GpColors.GpBlack)
        ) {
            item {// imagesDestination
                GpMainMenuItem(
                    color = GpYellow,
                    onClick = { },
                    image = viewModel.resourceManager.getDrawable(ru.aidar.common.R.drawable.ic_galaxy)!!,
                    text = viewModel.resourceManager.getString(ru.aidar.common.R.string.astronomyPictureOfTheDay),
                )
            }
            item {// astreDestination
                GpMainMenuItem(
                    color = GpGreen,
                    // todo глянуть
                    image = viewModel.resourceManager.getDrawable(ru.aidar.common.R.drawable.ic_planet)!!,
                    text = viewModel.resourceManager.getString(ru.aidar.common.R.string.astrePerAstre),
                )
            }
            item {// testDestination
                GpMainMenuItem(
                    color = GpRed,
                    image = viewModel.resourceManager.getDrawable(ru.aidar.common.R.drawable.ic_rocket)!!,
                    text = viewModel.resourceManager.getString(ru.aidar.common.R.string.spaceOverflow),
                )
            }
            item {// loveDestination
                GpMainMenuItem(
                    color = GpPink,
                    image = viewModel.resourceManager.getDrawable(ru.aidar.common.R.drawable.ic_tarot)!!,
                    text = viewModel.resourceManager.getString(ru.aidar.common.R.string.celestialCompatibility),
                )
            }
        }
    }
}