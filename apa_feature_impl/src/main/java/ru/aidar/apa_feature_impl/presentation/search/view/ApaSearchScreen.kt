@file:JvmName("ApaSearchScreenKt")

package ru.aidar.apa_feature_impl.presentation.search.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import ru.aidar.apa_feature_impl.R
import ru.aidar.apa_feature_impl.presentation.search.ApaSearchViewModel
import ru.aidar.common.compose.GpText
import ru.aidar.common.compose.GpTextFieldWithOnDone
import ru.aidar.common.utils.AppColors.AppBlack
import ru.aidar.common.utils.AppColors.AppBlue
import ru.aidar.common.utils.AppColors.AppDarkGreenBlue
import ru.aidar.common.utils.AppColors.AppRed
import ru.aidar.common.utils.AppColors.AppYellow
import ru.aidar.common.utils.AppTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApaSearchScreen(
    viewModel: ApaSearchViewModel,
    monitor: Boolean,
) {
    val context = LocalContext.current
    val state by viewModel.state.collectAsStateWithLifecycle()
    val scrollState = rememberScrollState()
    val snackbarHostState = remember { SnackbarHostState() }

    val notConnectedMessage by remember {
        mutableIntStateOf(R.string.not_connected)
    }

    LaunchedEffect(monitor) {
        if(monitor) {
            snackbarHostState.showSnackbar(
                message = context.getString(notConnectedMessage),
                duration = SnackbarDuration.Indefinite,
            )
        }
    }

    Scaffold(
        topBar = {
            ApaTopBar(
                navigateUp = viewModel::navigateUp,
                searchBarActive = state.active,
                searchQuery = state.query,
                onQueryChange = viewModel::updateQuery,
                onSearchClicked = { viewModel.updateActive(true) },
                onDoneClicked = { viewModel.updateActive(false) },
            )
        },
        snackbarHost = { SnackbarHost(hostState = snackbarHostState) },
    ) {
        Column(
            modifier =
            Modifier
                .padding(it)
                .fillMaxSize()
                .verticalScroll(scrollState)
                .background(AppBlack),
        ) {
            Spacer(modifier = Modifier.padding(top = 10.dp))
            state.responses.forEach {
                Row(
                    modifier =
                    Modifier
                        .fillMaxWidth()
                        .clickable { viewModel.navigateToDetail(it) },
                    horizontalArrangement = Arrangement.Start,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    GpText(
                        text = it.name,
                        modifier =
                        Modifier
                            .padding(start = 20.dp)
                            .padding(vertical = 5.dp),
                        style = AppTypography.detailInfoTypo,
                        textColor = AppBlue,
                    )
                }
                HorizontalDivider(
                    modifier =
                    Modifier
                        .padding(16.dp)
                        .background(AppBlack),
                    thickness = 2.dp,
                    color = AppDarkGreenBlue,
                )
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApaTopBar(
    navigateUp: () -> Unit,
    searchBarActive: Boolean,
    searchQuery: String,
    onQueryChange: (String) -> Unit,
    onSearchClicked: () -> Unit,
    onDoneClicked: () -> Unit,
) {
    when(searchBarActive) {
        false -> {
            TopAppBar(
                title = {
                    Text(
                        text = "Astre",
                        style = AppTypography.titleLargeTypo,
                    )
                },
                colors =
                TopAppBarDefaults.topAppBarColors(
                    containerColor = AppBlack,
                    navigationIconContentColor = AppRed,
                    actionIconContentColor = AppYellow,
                ),
                navigationIcon = {
                    IconButton(onClick = navigateUp) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description",
                        )
                    }
                },
                actions = {
                    IconButton(onClick = onSearchClicked) {
                        Icon(
                            imageVector = Icons.Default.Search,
                            contentDescription = null,
                        )
                    }
                },
            )
        }

        true -> {
            SearchAppBar(
                query = searchQuery,
                onQueryChange = onQueryChange,
                onDoneClicked = onDoneClicked,
            )
        }
    }
}

@Composable
fun SearchAppBar(
    query: String,
    onQueryChange: (String) -> Unit,
    onDoneClicked: () -> Unit,
) {
    Surface(
        modifier =
        Modifier
            .fillMaxWidth()
            .height(64.dp),
        color = AppBlack,
    ) {
        Column {
            GpTextFieldWithOnDone(
                modifier =
                Modifier
                    .weight(1f)
                    .fillMaxWidth(),
                onValueChange = onQueryChange,
                value = query,
                isError = false,
                label = "Search",
                additionalKeyboardAction = onDoneClicked,
                trailingIcon = Icons.Default.Close,
                trailingIconAction = { onQueryChange("") },
                trailingIconActionOnEmpty = onDoneClicked,
                keyboardType = KeyboardType.Text,
                enableIndicator = false,
            )
            HorizontalDivider(
                modifier = Modifier.fillMaxWidth(),
                color = AppDarkGreenBlue,
                thickness = 1.dp,
            )
        }
    }
}
