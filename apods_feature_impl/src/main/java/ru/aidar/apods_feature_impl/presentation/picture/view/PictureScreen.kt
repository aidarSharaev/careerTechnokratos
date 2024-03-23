package ru.aidar.apods_feature_impl.presentation.picture.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.InlineTextContent
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.Wrap
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import ru.aidar.apods_feature_impl.presentation.list.model.ParcelableLocal
import ru.aidar.apods_feature_impl.presentation.picture.PictureViewModel
import ru.aidar.common.compose.GpBottomSheetItem
import ru.aidar.common.compose.GpTextButtonWithDrawBehind
import ru.aidar.common.utils.AppColors
import ru.aidar.common.utils.AppTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PictureScreen(
    viewModel: PictureViewModel,
    picture: ParcelableLocal
) {

    val annotatedString = buildAnnotatedString {
        append("я ебу собак всегда готов трахнуть сразу несколько котов, ооооооо")
    }

    val sheetState = rememberModalBottomSheetState()
    val scope = rememberCoroutineScope()
    var showBottomSheet by remember { mutableStateOf(false) }

    Scaffold(
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

        var isImageLoading by remember { mutableStateOf(false) }
        val painter = rememberAsyncImagePainter(
            model = picture.url
                ?: "https://www.google.ru/url?sa=i&url=https%3A%2F%2Fwww.wired.com%2Fstory%2Fhow-space-tries-kill-you-make-you-ugly%2F&psig=AOvVaw1-liUTaDA2O6ZLW4_ZLB6y&ust=1711184836992000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCNiMwrTCh4UDFQAAAAAdAAAAABAE",
        )
        isImageLoading = when(painter.state) {
            is AsyncImagePainter.State.Loading -> true
            else -> false
        }
        Box(
            Modifier
                .padding(it)
                .padding(vertical = 10.dp, horizontal = 16.dp)
                .height(300.dp)
                .fillMaxWidth()
        ) {
            Image(
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 8.dp)
                    .clip(RoundedCornerShape(15.dp)),
                painter = painter,
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            if(isImageLoading) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .padding(horizontal = 6.dp, vertical = 3.dp),
                    color = AppColors.AppYellow,
                )
            }
        }

        /*if (showBottomSheet) {
            ModalBottomSheet(
                containerColor = AppColors.AppBlack,
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

                }
            }
        }*/
    }
}