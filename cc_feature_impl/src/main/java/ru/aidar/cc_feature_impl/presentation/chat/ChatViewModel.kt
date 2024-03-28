package ru.aidar.cc_feature_impl.presentation.chat

import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import ru.aidar.cc_feature_api.domain.repository.ChatUseCases
import ru.aidar.cc_feature_api.domain.wrapper.ChatState
import ru.aidar.cc_feature_api.domain.wrapper.ChatStateWrapper
import ru.aidar.cc_feature_api.utils.GpMessage
import ru.aidar.cc_feature_api.utils.MessageAuthor
import ru.aidar.cc_feature_impl.CcRouter
import ru.aidar.common.base.BaseViewModel
import kotlin.coroutines.CoroutineContext

class ChatViewModel(
    private val router: CcRouter,
    private val useCases: ChatUseCases,
    private val wrapper: ChatStateWrapper,
) : BaseViewModel(), CoroutineScope {

    override val coroutineContext: CoroutineContext
        get() = SupervisorJob() + CoroutineName("ChatViewModel")

    val state = wrapper.flow().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5_000),
        initialValue = ChatState()
    )

    fun updateUserText(text: String) {
        wrapper.updateTextFieldValue(text = text)
    }

    fun updateUserDateOfBirth(date: String) {
        wrapper.updateUserDateOfBirth(date = date)
    }

    fun sendMessageAction() {
        wrapper.updateMessagePosition()
        wrapper.addNewMessage(
            GpMessage(
                content = state.value.textFieldValue,
                author = MessageAuthor.User,
            )
        )
        updateUserText(text = "")
            // validate
    }

    private fun wrongDateMssg() {
        wrapper.addNewMessage(message = GpMessage("The entered date is incorrect, please try again"))
    }


    private fun wrongTimeMssg() {
        wrapper.addNewMessage(message = GpMessage("The timing, unfortunately, is wrong"))
    }

    private fun wrongLocationMssg() {
        wrapper.addNewMessage(message = GpMessage("Recheck the format or value of the coordinates"))
    }
}
