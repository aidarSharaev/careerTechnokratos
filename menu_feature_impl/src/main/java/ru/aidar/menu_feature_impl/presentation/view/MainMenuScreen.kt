package ru.aidar.menu_feature_impl.presentation.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import ru.aidar.common.compose_component.ComponentDropDownMenu
import ru.aidar.common.compose_component.model.DropDownModel
import ru.aidar.common.utils.GpColors
import ru.aidar.common.utils.GpColors.GpGreen
import ru.aidar.common.utils.GpColors.GpPink
import ru.aidar.common.utils.GpColors.GpRed
import ru.aidar.common.utils.GpColors.GpYellow
import ru.aidar.common.utils.GpTypography
import ru.aidar.menu_feature_impl.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainMenuScreen(
//    viewModel: MainMenuViewModel,
) {

    var dropDownExpanded by remember { mutableStateOf(false) }

    fun switchDropDownExpanded() {
        dropDownExpanded = !dropDownExpanded
    }

    Scaffold(
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        // todo fix
                        text = stringResource(ru.aidar.common.R.string.nasa),
                        style = GpTypography.titleLargeTypo.copy(
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
                    IconButton(onClick = { switchDropDownExpanded() }) {
                        Icon(
                            // todo вынести
                            painter = painterResource(id = R.drawable.ic_more_vert),
                            contentDescription = null,
                        )
                    }
                },
            )
        },
    ) {
        ComponentDropDownMenu(
            onDismissRequest = ::switchDropDownExpanded,
            expanded = dropDownExpanded,
            items = arrayOf(
                DropDownModel(
                    text = R.string.moonrise,
                    trailingImage = R.drawable.ic_sun,
                    action = {}),
                DropDownModel(
                    text = R.string.logout,
                    trailingImage = R.drawable.ic_logout,
                    action = {}),
            )
        )
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
                    image = R.drawable.ic_galaxy,
                    text = R.string.astronomy_picture_of_the_day,
                )
            }
            item {// astreDestination
                GpMainMenuItem(
                    color = GpGreen,
                    onClick = {},
                    // todo глянуть
                    image = R.drawable.ic_planet,
                    text = R.string.astre_per_astre,
                )
            }
            item {// testDestination
                GpMainMenuItem(
                    color = GpRed,
                    onClick = {},
                    image = R.drawable.ic_rocket,
                    text = R.string.space_overflow,
                )
            }
            item {// loveDestination
                GpMainMenuItem(
                    color = GpPink,
                    onClick = {},
                    image = R.drawable.ic_tarot,
                    text = R.string.celestial_compatibility,
                )
            }
        }
    }
}

