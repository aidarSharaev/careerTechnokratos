package ru.aidar.cc_feature_api.domain.wrapper

import ru.aidar.cc_feature_api.DialogCondition
import ru.aidar.cc_feature_api.domain.model.ScreenStatus
import ru.aidar.cc_feature_api.utils.CcCondition
import ru.aidar.cc_feature_api.utils.GpAction
import ru.aidar.cc_feature_api.utils.GpMessage
import ru.aidar.cc_feature_api.utils.MessageAuthor

data class ChatState(
    val status: ScreenStatus = ScreenStatus.Visible,
    val condition: CcCondition = CcCondition.NOTHING_DEFAULT,
    val gpMessages: MutableList<GpMessage> = mutableListOf(
        GpMessage(
            content = "Let's check out your better half!",
            author = MessageAuthor.App,
            action = GpAction.DatePicker
        )
    ),
    val dialogCondition: DialogCondition = DialogCondition.Begin,
    val textFieldValue: String = "",
    val userDateOfBirth: String = "",

    val lastMessagePosition: Int = 0,
    val lastAppMessagePosition: Int = 0,
)
