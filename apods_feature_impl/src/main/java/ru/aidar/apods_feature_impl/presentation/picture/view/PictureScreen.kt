package ru.aidar.apods_feature_impl.presentation.picture.view

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImagePainter
import coil.compose.rememberAsyncImagePainter
import ru.aidar.apods_feature_impl.presentation.list.model.ParcelableLocal
import ru.aidar.apods_feature_impl.presentation.picture.PictureViewModel
import ru.aidar.common.compose.GpAnnotatedTextWithConstStyle
import ru.aidar.common.compose.GpTextBrush
import ru.aidar.common.utils.AppColors
import ru.aidar.common.utils.AppColors.AppBlack
import ru.aidar.common.utils.AppColors.AppDarkGreenBlue
import ru.aidar.common.utils.AppTypography
import kotlin.math.pow
import kotlin.math.sqrt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PictureScreen(
    viewModel: PictureViewModel,
    picture: ParcelableLocal
) {

    val scaffoldState = rememberBottomSheetScaffoldState()
    val scrollState = rememberScrollState()

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
        scaffoldState = scaffoldState,
        sheetPeekHeight = 90.dp,
        sheetContainerColor = AppDarkGreenBlue,
        sheetContent = {
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                contentAlignment = Alignment.Center
            ) {
                GpTextBrush(
                    text = "Description",
                    style = AppTypography.mainMenuCardTypo.copy(
                        brush = Brush.horizontalGradient(
                            colors = listOf(
                                AppColors.AppRed,
                                AppColors.AppPink,
                                AppColors.AppGreen,
                                AppColors.AppYellow,
                            )
                        )
                    ),
                    modifier = Modifier,
                )
            }
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(top = 10.dp)
                    .verticalScroll(scrollState)
                    .padding(horizontal = 16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                GpAnnotatedTextWithConstStyle(
                    param1 = "Title: ",
                    param2 = picture.title
                )
                Spacer(Modifier.height(15.dp))

                GpAnnotatedTextWithConstStyle(
                    param1 = "Copyright: ",
                    param2 = picture.copyright
                )
                Spacer(Modifier.height(15.dp))

                GpAnnotatedTextWithConstStyle(
                    param1 = "Date: ",
                    param2 = picture.date
                )
                Spacer(Modifier.height(15.dp))

                GpAnnotatedTextWithConstStyle(
                    param1 = "Explanation: ",
                    param2 = picture.explanation
                )
                Spacer(Modifier.height(15.dp))

            }
        }) {

        var isImageLoading by remember { mutableStateOf(false) }

        val painter = rememberAsyncImagePainter(
            model = picture.url
                ?: "https://www.google.ru/url?sa=i&url=https%3A%2F%2Fwww.wired.com%2Fstory%2Fhow-space-tries-kill-you-make-you-ugly%2F&psig=AOvVaw1-liUTaDA2O6ZLW4_ZLB6y&ust=1711184836992000&source=images&cd=vfe&opi=89978449&ved=0CBIQjRxqFwoTCNiMwrTCh4UDFQAAAAAdAAAAABAE",
        )

        var size by remember {
            mutableIntStateOf(200)
        }

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
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .padding(horizontal = 10.dp, vertical = 8.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .size(size.dp)
                    .pointerInput(Unit) {
                        val fingerCount = 2
                        var previousDistance = 0f
                        awaitEachGesture {
                            do {
                                val event = awaitPointerEvent()
                                if(event.changes.size == fingerCount) {
                                    val firstX = event.changes[0].position.x
                                    val firstY = event.changes[0].position.y

                                    val secondX = event.changes[1].position.x
                                    val secondY = event.changes[1].position.y

                                    val currentDistance = sqrt(
                                        (secondX - firstX).pow(2) + (secondY - firstY).pow(2)
                                    )

                                    if(currentDistance - previousDistance > 10) {
                                        Log.d("GESTURE", "ififif -- $size")
                                        if(size < 500)
                                            size += 5
                                        previousDistance = currentDistance
                                    }
                                }
                            } while(event.changes.any { input ->
                                    input.pressed
                                })
                            size = 200
                            previousDistance = 0f
                        }
                    },
                painter = painter,
                contentDescription = null,
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