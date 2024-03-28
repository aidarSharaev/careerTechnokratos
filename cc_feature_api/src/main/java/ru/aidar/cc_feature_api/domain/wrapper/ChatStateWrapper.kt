package ru.aidar.cc_feature_api.domain.wrapper

import kotlinx.coroutines.flow.StateFlow
import ru.aidar.cc_feature_api.utils.GpMessage

interface ChatStateWrapper {
    fun flow(): StateFlow<ChatState>
    fun addNewMessage(message: GpMessage)
    fun updateTextFieldValue(text: String)
    fun updateUserDateOfBirth(date: String)
    fun updateMessagePosition()
    fun updateAppMessagePosition()
}
