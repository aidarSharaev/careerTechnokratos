package ru.aidar.cc_feature_api.utils

enum class CcCondition(val code: Int) {

    NEW(code = 101),
    CREATED(code = 102),
    NOTHING_DEFAULT(code = -1),
}

data class GpMessage(
    val content: String,
    val author: MessageAuthor = MessageAuthor.App,
    val action: GpAction = GpAction.WithoutAction,
)

interface MessageAuthor {
    object App : MessageAuthor
    object User : MessageAuthor
}

interface GpAction {

    val text: String

    object TimePicker : GpAction {
        override val text: String
            get() = "Choose a time"
    }

    object DatePicker : GpAction {
        override val text: String
            get() = "Choose a date"
    }
    object Execute : GpAction {
        override val text: String
            get() = "Get result"
    }
    object WithoutAction : GpAction {
        override val text: String
            get() = ""
    }
}

