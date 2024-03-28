package ru.aidar.cc_feature_impl.data.wrapper

import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import ru.aidar.cc_feature_api.domain.wrapper.ChatState
import ru.aidar.cc_feature_api.domain.wrapper.ChatStateWrapper
import ru.aidar.cc_feature_api.utils.GpMessage

class ChatStateWrapperImpl(
    private val flow: MutableStateFlow<ChatState>,
) : ChatStateWrapper {

    override fun flow(): StateFlow<ChatState> {
        return flow
    }

    override fun updateTextFieldValue(text: String) {
        flow.update { it.copy(textFieldValue = text) }
    }

    override fun addNewMessage(message: GpMessage) {
        flow.value.gpMessages.add(message)
    }

    override fun updateUserDateOfBirth(date: String) {
        flow.update { it.copy(userDateOfBirth = date) }
    }

    override fun updateMessagePosition() {
        val pos = flow.value.lastMessagePosition + 1
        flow.update { it.copy(lastMessagePosition = pos) }
    }

    override fun updateAppMessagePosition() {
        val pos = flow.value.lastMessagePosition + 1
        flow.update { it.copy(lastAppMessagePosition = pos) }
        updateMessagePosition()
    }
}
