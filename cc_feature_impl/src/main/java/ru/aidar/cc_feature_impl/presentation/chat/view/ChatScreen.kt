package ru.aidar.cc_feature_impl.presentation.chat.view

import android.util.Log
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.automirrored.filled.Send
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SelectableDates
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.animateLottieCompositionAsState
import com.airbnb.lottie.compose.rememberLottieComposition
import kotlinx.coroutines.launch
import ru.aidar.cc_feature_api.domain.wrapper.ChatState
import ru.aidar.cc_feature_api.utils.MessageAuthor
import ru.aidar.cc_feature_impl.R
import ru.aidar.cc_feature_impl.presentation.chat.ChatViewModel
import ru.aidar.common.compose.GpDatePicker
import ru.aidar.common.compose.GpMessageBox
import ru.aidar.common.compose.GpTextFieldWithOnDone
import ru.aidar.common.compose.rememberImeState
import ru.aidar.common.utils.AppColors
import ru.aidar.common.utils.AppColors.AppBlack
import ru.aidar.common.utils.AppTypography
import java.text.SimpleDateFormat
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScreen(viewModel: ChatViewModel, state: ChatState) {

    val imeState = rememberImeState()
    val scrollState = rememberScrollState()

    val width = (LocalConfiguration.current.screenWidthDp * 0.85f).toInt()

    val composition by rememberLottieComposition(
        spec = LottieCompositionSpec.RawRes(R.raw.love_alien)
    )
    val progress by animateLottieCompositionAsState(
        composition = composition,
        isPlaying = true,
        iterations = LottieConstants.IterateForever,
    )

    fun convertMillisToDate(millis: Long): String {
        val formatter = SimpleDateFormat("dd/MM/yyyy")
        return formatter.format(Date(millis))
    }

    val datePickerState = rememberDatePickerState(selectableDates = object : SelectableDates {
        override fun isSelectableDate(utcTimeMillis: Long): Boolean {
            return utcTimeMillis <= System.currentTimeMillis()
        }
    })

    val selectedDate = datePickerState.selectedDateMillis?.let {
        convertMillisToDate(it)
    } ?: ""

    var showDatePicker by remember { mutableStateOf(false) }

    val coroutineScope = rememberCoroutineScope()
    val listState = rememberLazyListState()

    val position = remember { state.lastAppMessagePosition + 1 }

    LaunchedEffect(key1 = imeState.value) {
        if(imeState.value) {
            scrollState.animateScrollTo(scrollState.maxValue, tween(300))
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Compatibility",
                        style = AppTypography.titleLargeTypo,
                    )
                },
                colors =
                TopAppBarDefaults.topAppBarColors(
                    containerColor = AppColors.AppBlack,
                    navigationIconContentColor = AppColors.AppRed,
                    actionIconContentColor = AppColors.AppYellow,
                ),
                navigationIcon = {
                    IconButton(onClick = { showDatePicker = true }) {
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
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(AppBlack)

        ) {
            if(showDatePicker) {
                GpDatePicker(
                    onDismissRequest = { showDatePicker = false },
                    onConfirmRequest = {},
                    state = datePickerState
                )
            }
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
                    .padding(horizontal = 8.dp),
                state = listState,
            ) {
                items(state.gpMessages.subList(0, state.lastAppMessagePosition).size) { mss ->
                    GpMessageBox(
                        author = if(state.gpMessages[mss].author is MessageAuthor.App) 0 else 1,
                        text = state.gpMessages[mss].content,
                        width = width,
                    )
                }
                item {
                    LottieAnimation(
                        modifier = Modifier.size(150.dp),
                        composition = composition,
                        progress = progress
                    )
                }
                item {
                    if(state.lastAppMessagePosition >= state.lastMessagePosition)
                        GpMessageBox(
                            author = if(state.gpMessages[state.lastAppMessagePosition].author is MessageAuthor.App) 0 else 1,
                            text = state.gpMessages[state.lastAppMessagePosition].content,
                            width = width,
                            action = true,
                            actionText = state.gpMessages[state.lastAppMessagePosition].action.text
                        ) else {
                        GpMessageBox(
                            author = if(state.gpMessages[state.lastAppMessagePosition].author is MessageAuthor.App) 0 else 1,
                            text = state.gpMessages[state.lastAppMessagePosition].content,
                            width = width,
                        )
                    }
                }
                items(
                    if(state.lastAppMessagePosition < state.lastMessagePosition) {
                        Log.d("Alien", "ifif")
                        state.gpMessages.subList(
                            position,
                            state.gpMessages.size
                        ).size
                    } else {
                        0
                    }
                ) { mss ->
                    Log.d("Alien", " -- -- $mss")
                    GpMessageBox(
                        author = if(state.gpMessages[position + mss].author is MessageAuthor.App) 0 else 1,
                        text = state.gpMessages[position + mss].content,
                        width = width,
                    )
                }
            }

            GpTextFieldWithOnDone(
                modifier = Modifier.fillMaxWidth(),
                onValueChange = viewModel::updateUserText,
                value = state.textFieldValue,
                isError = false,
                keyboardType = KeyboardType.Text,
                trailingIcon = Icons.AutoMirrored.Filled.Send,
                trailingIconAction = {
                    viewModel.sendMessageAction()
                    coroutineScope.launch {
                        listState.animateScrollToItem(index = listState.layoutInfo.totalItemsCount - 1)
                    }
                },
                trailingIconCondition = state.textFieldValue.isNotBlank()
            )
        }
    }
}

/*@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun KEKE() {

    DatePickerDialog(
        onDismissRequest = { */
/*onDismiss()*//* },
        confirmButton = {
            GpButton(
                buttonColor = AppGreen,
                modifier = Modifier,
                onClick = { },
                text = "Ok",
            )
        },
        dismissButton = {
            GpButton(
                buttonColor = AppRed,
                modifier = Modifier,
                onClick = { },
                text = "Cancel",
            )
        },
        colors = DatePickerDefaults.colors(
//            containerColor = AppBlack,
//            dayContentColor = AppWhite,
//            disabledDayContentColor = AppWhite,
//            titleContentColor = AppWhite,
//            weekdayContentColor = AppBlue,
//            headlineContentColor = AppBlue,
//            subheadContentColor = Color.Green,
//            navigationContentColor = Color.Green,
//            yearContentColor = Color.Green,
//            disabledYearContentColor = Color.Green,
//            disabledSelectedYearContentColor = Color.Green,
//            disabledSelectedDayContentColor =  Color.Green,
        )

    ) {
        DatePicker(
            state = rememberDatePickerState()
        )
    }

}*/
