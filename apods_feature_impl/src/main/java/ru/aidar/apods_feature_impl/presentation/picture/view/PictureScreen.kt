package ru.aidar.apods_feature_impl.presentation.picture.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.BottomSheetScaffold
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberBottomSheetScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import ru.aidar.apods_feature_impl.presentation.list.model.ParcelableLocal
import ru.aidar.apods_feature_impl.presentation.picture.PictureViewModel
import ru.aidar.common.compose.GpText
import ru.aidar.common.utils.AppColors
import ru.aidar.common.utils.AppColors.AppBlack
import ru.aidar.common.utils.AppColors.AppDarkGreenBlue
import ru.aidar.common.utils.AppColors.AppWhite
import ru.aidar.common.utils.AppColors.AppYellow
import ru.aidar.common.utils.AppTypography

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PictureScreen(
    viewModel: PictureViewModel,
    picture: ParcelableLocal
) {

    val scaffoldState = rememberBottomSheetScaffoldState()
    BottomSheetScaffold(
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
                    navigationIconContentColor = AppColors.AppTurquoise,
                    titleContentColor = AppColors.AppTurquoise,
                    actionIconContentColor = AppColors.AppTurquoise,
                ),
                navigationIcon = {
                    IconButton(onClick = viewModel::navigateUp) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "Localized description",
                            tint = AppColors.AppGreen
                        )
                    }
                },
            )
        },
        scaffoldState = scaffoldState,
        sheetPeekHeight = 80.dp,
        sheetContainerColor = AppDarkGreenBlue,
        sheetContent = {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                /*.background(AppBlack)*/,
                contentAlignment = Alignment.Center
            ) {
                Text(
                    "Swipe for details", color = AppWhite, style = TextStyle(

                    )
                )
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    /*.background(AppBlack)*/
                    .padding(top = 10.dp)
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                GpText(
                    text = "Title: ${picture.title}",
                    modifier = Modifier,
                    style = AppTypography.buttonLightTypo,
                    textColor = AppYellow
                )
                Spacer(Modifier.height(20.dp))
                GpText(
                    text = "Copyright: ${picture.copyright}",
                    modifier = Modifier,
                    style = AppTypography.buttonLightTypo,
                    textColor = AppYellow
                )
                Spacer(Modifier.height(20.dp))
            }
        }) {

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
                .fillMaxSize()
                .background(AppBlack)
                .padding(vertical = 10.dp, horizontal = 16.dp),
            contentAlignment = Alignment.TopCenter
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

    }
}