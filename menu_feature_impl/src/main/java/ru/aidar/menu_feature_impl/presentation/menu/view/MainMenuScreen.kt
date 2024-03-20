package ru.aidar.menu_feature_impl.presentation.menu.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.aidar.common.compose.GpBottomSheetItem
import ru.aidar.common.compose.GpMainMenuItem
import ru.aidar.common.compose.GpTextButtonWithDrawBehind
import ru.aidar.common.utils.AppColors
import ru.aidar.common.utils.AppColors.AppBlack
import ru.aidar.common.utils.AppColors.AppGreen
import ru.aidar.common.utils.AppColors.AppPink
import ru.aidar.common.utils.AppColors.AppRed
import ru.aidar.common.utils.AppColors.AppWhite
import ru.aidar.common.utils.AppColors.AppYellow
import ru.aidar.common.utils.AppTypography
import ru.aidar.common.utils.AppTypography.buttonLightTypo
import ru.aidar.menu_feature_impl.R
import ru.aidar.menu_feature_impl.presentation.menu.MainMenuViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainMenuScreen(viewModel: MainMenuViewModel) {
    // when(view)

    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
        contentWindowInsets = WindowInsets(0, 0, 0, 0),
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        // todo fix
                        text = stringResource(ru.aidar.common.R.string.nasa),
                        style =
                        AppTypography.titleLargeTypo.copy(
                            shadow =
                            Shadow(
                                color = AppBlack,
                                offset = Offset(2f, 2f),
                                blurRadius = 4f,
                            ),
                        ),
                    )
                },
                colors =
                TopAppBarDefaults.topAppBarColors(
                    containerColor = AppBlack,
                    navigationIconContentColor = AppColors.AppTurquoise,
                    titleContentColor = AppColors.AppTurquoise,
                    actionIconContentColor = AppColors.AppTurquoise,
                ),
                actions = {
                    IconButton(onClick = { showBottomSheet = true }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_more_vert),
                            contentDescription = null,
                        )
                    }
                },
            )
        },
    ) {
        LazyColumn(
            modifier =
            Modifier
                .fillMaxSize()
                .padding(it)
                // todo check
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(WindowInsetsSides.Horizontal),
                )
                .background(AppBlack),
        ) {
            item {
                Spacer(modifier = Modifier.height(10.dp))
            }
            item { // imagesDestination
                GpMainMenuItem(
                    color = AppYellow,
                    onClick = viewModel::navigateToApod,
                    image = R.drawable.ic_galaxy,
                    text = R.string.astronomy_picture_of_the_day,
                )
            }
            item { // astreDestination
                GpMainMenuItem(
                    color = AppGreen,
                    onClick = {},
                    image = R.drawable.ic_planet,
                    text = R.string.astre_per_astre,
                )
            }
            item { // testDestination
                GpMainMenuItem(
                    color = AppRed,
                    onClick = {},
                    image = R.drawable.ic_rocket,
                    text = R.string.space_overflow,
                )
            }
            item { // loveDestination
                GpMainMenuItem(
                    color = AppPink,
                    onClick = {},
                    image = R.drawable.ic_tarot,
                    text = R.string.celestial_compatibility,
                )
            }
        }

        if(showBottomSheet) {
            ModalBottomSheet(
                containerColor = AppBlack,
                onDismissRequest = {
                    showBottomSheet = false
                },
                sheetState = sheetState,
            ) {
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 16.dp),
                ) {
                    GpBottomSheetItem(
                        onClick = {},
                        text = stringResource(id = R.string.moonlight_tracker),
                    )
                    HorizontalDivider(
                        modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp),
                        color = AppWhite.copy(alpha = 0.4f),
                        thickness = 1.dp,
                    )
                    GpBottomSheetItem(
                        onClick = {},
                        text = stringResource(R.string.switch_number_system),
                    )

                    GpTextButtonWithDrawBehind(
                        modifier =
                        Modifier
                            .fillMaxWidth()
                            .padding(5.dp),
                        onClick = { viewModel.signOut() },
                        text = stringResource(id = R.string.logout),
                        style = buttonLightTypo,
                        drawColor = AppRed,
                        cornerRadius = 6,
                        horizontalPadding = 18,
                        verticalPadding = 10,
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                }
            }
        }
    }
}
