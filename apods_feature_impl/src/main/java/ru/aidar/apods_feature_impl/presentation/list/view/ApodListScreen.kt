package ru.aidar.apods_feature_impl.presentation.list.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.rounded.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import ru.aidar.apods_feature_impl.presentation.list.ApodListViewModel
import ru.aidar.common.compose.GpLoadingBar
import ru.aidar.common.compose.GpProgressIndicator
import ru.aidar.common.compose.GpText
import ru.aidar.common.utils.AppColors
import ru.aidar.common.utils.AppColors.AppBlack
import ru.aidar.common.utils.AppColors.AppGreen
import ru.aidar.common.utils.AppColors.AppPink
import ru.aidar.common.utils.AppColors.AppWhite
import ru.aidar.common.utils.AppColors.AppYellow
import ru.aidar.common.utils.AppTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ApodListScreen(viewModel: ApodListViewModel) {

    val pictures = viewModel.getPictures().collectAsLazyPagingItems()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Pictures",
                        style = AppTypography.titleLargeTypo,
                    )
                },
                colors =
                TopAppBarDefaults.topAppBarColors(
                    containerColor = Color.Transparent.copy(0.5f),
                    navigationIconContentColor = AppColors.AppTurquoise,
                    titleContentColor = AppColors.AppTurquoise,
                    actionIconContentColor = AppColors.AppTurquoise,
                ),
                navigationIcon = {
                    IconButton(onClick = { /* do something */ }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description",
                        )
                    }
                },
            )
        },
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .background(AppBlack),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {


            items(count = pictures.itemCount) { item ->

                var isImageLoading by remember { mutableStateOf(false) }

                val painter = rememberAsyncImagePainter(
                    model = pictures[item]?.url
                        ?: "https://www.google.ru/url?sa=i&url=https%3A%2F%2Fwww.wired.com%2Fstory%2Fhow-space-tries-kill-you-make-you-ugly%2F&psig=AOvVaw1-liUTaDA2O6ZLW4_ZLB6y&ust=1711184836992000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCNiMwrTCh4UDFQAAAAAdAAAAABAE",
                )


                isImageLoading = when(painter.state) {
                    is AsyncImagePainter.State.Loading -> true
                    else -> false
                }
                Box(
                    modifier = Modifier
                        .padding(vertical = 10.dp, horizontal = 16.dp)
                        .height(300.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(15.dp))
                        .background(Color.Gray)
                        .clickable { pictures[item]?.let { it1 -> viewModel.openPicture(it1) } },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        modifier = Modifier
                            .padding(horizontal = 10.dp, vertical = 8.dp)
                            .clip(RoundedCornerShape(15.dp))
                            .fillMaxSize(),
                        painter = painter,
                        contentDescription = null,
                        contentScale = ContentScale.Crop
                    )
                    if(isImageLoading) {
                        CircularProgressIndicator(
                            modifier = Modifier
                                .padding(horizontal = 6.dp, vertical = 3.dp),
                            color = AppYellow,
                        )
                    }
                }
            }
            item {
                val loadState = pictures.loadState.mediator

                if(loadState?.append == LoadState.Loading) {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(25.dp),
                        contentAlignment = Alignment.Center,
                    ) {
                        GpProgressIndicator(color = AppPink)
                    }
                } else if(loadState?.refresh == LoadState.Loading) {
                    GpLoadingBar(
                        text = "Refresh Loading",
                        barColor = AppGreen,
                        modifier = Modifier.fillParentMaxSize()
                    )
                } else if(loadState?.refresh is LoadState.Error || loadState?.append is LoadState.Error) {
                    val isPaginatingError =
                        (loadState.append is LoadState.Error) || pictures.itemCount > 1
                    val error = if(loadState.append is LoadState.Error)
                        (loadState.append as LoadState.Error).error
                    else
                        (loadState.refresh as LoadState.Error).error

                    val modifier = if(isPaginatingError) {
                        Modifier.padding(8.dp)
                    } else {
                        Modifier.fillParentMaxSize()
                    }
                    Column(
                        modifier = modifier,
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        if(!isPaginatingError) {
                            Icon(
                                modifier = Modifier
                                    .size(64.dp),
                                imageVector = Icons.Rounded.Warning,
                                contentDescription = null,
                                tint = AppYellow
                            )
                        }

                        GpText(
                            modifier = Modifier,
                            text = "Ошибка загрузки",
                            style = AppTypography.buttonLightTypo,
                            textColor = AppWhite
                        )

                        Button(
                            onClick = {
                                pictures.retry()
                                Log.d("PAging3", loadState.toString())
                            },
                            content = {
                                Text(text = "Refresh")
                            },
                            colors = ButtonColors(
                                containerColor = AppPink,
                                contentColor = AppWhite,
                                disabledContainerColor = AppPink,
                                disabledContentColor = AppWhite,
                            )
                        )
                    }
                }
            }
        }
    }
}
