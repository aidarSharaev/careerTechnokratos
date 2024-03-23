package ru.aidar.apa_feature_impl.presentation.search.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import ru.aidar.apa_feature_impl.presentation.search.ApaSearchViewModel
import ru.aidar.common.utils.AppColors
import ru.aidar.common.utils.AppColors.AppBlack
import ru.aidar.common.utils.AppColors.AppWhite
import ru.aidar.common.utils.AppTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VisibleApaSearchScreen(viewModel: ApaSearchViewModel) {

    val state by viewModel.state.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    SearchBar(
                        placeholder = {
                            Text(
                                text = "Enter space object",
                                style = AppTypography.labelTypo
                            )
                        },
                        modifier = Modifier.fillMaxWidth(),
                        colors = SearchBarDefaults.colors(
                            containerColor = AppBlack,
                            inputFieldColors = TextFieldDefaults.colors(
                                focusedTextColor = AppWhite,
                                unfocusedTextColor = AppWhite.copy(alpha = 0.3f)
                            )
                        ),
                        query = state.query,
                        onQueryChange = viewModel::updateQuery,
                        onSearch = { viewModel.updateActive(active = false) },
                        active = state.active,
                        onActiveChange = viewModel::updateActive,
                        leadingIcon = {
                            IconButton(
                                onClick = {
                                    if(state.active)
                                        viewModel.updateActive(active = false)
                                    else
                                        viewModel.updateActive(active = true) // todo
                                }
                            ) {
                                Icon(
                                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                                    contentDescription = "Localized description",
                                )
                            }
                        },
                        trailingIcon = {
                            if(state.active) {
                                IconButton(onClick = { viewModel.updateQuery("") }) {
                                    Icon(
                                        imageVector = Icons.Default.Clear,
                                        contentDescription = "Localized description",
                                    )
                                }
                            }
                        }
                    ) {
                        LazyColumn {
                            items(state.responses) {

                            }
                        }
                    }
                },

                colors =
                TopAppBarDefaults.topAppBarColors(
                    containerColor = AppBlack,
                    navigationIconContentColor = AppColors.AppTurquoise,
                    titleContentColor = AppColors.AppTurquoise,
                    actionIconContentColor = AppColors.AppTurquoise,
                ),
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description",
                            tint = AppColors.AppGreen
                        )
                    }
                },
            )
        }) {
        Box(Modifier.padding(it)) {
            Button(onClick = {}) {

            }
        }
    }
}



/*
@Preview
@Composable
fun rere() {
    VisibleApaSearchScreen(ApaSearchViewModel())
}*/
