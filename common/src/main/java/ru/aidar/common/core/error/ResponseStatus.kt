package ru.aidar.common.core.error

interface ResponseStatus {
    fun apply(): Boolean

    object Success : ResponseStatus {
        override fun apply(): Boolean {
            return true
        }
    }

    data class Fail(val message: String) : ResponseStatus {
        override fun apply(): Boolean {
            return false
        }
    }

    data class Cancel(val message: String, val throwable: String) : ResponseStatus {
        override fun apply(): Boolean {
            return false
        }
    }
}
