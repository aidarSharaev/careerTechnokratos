package ru.aidar.common.core.auth.model

enum class ErrorTypes(val number: Int) {
    LOGIN_ERROR(101),
    PASSWORD_ERROR(102),
    ANOTHER_ERROR(103),
    CANCEL_ERROR(104),
}
