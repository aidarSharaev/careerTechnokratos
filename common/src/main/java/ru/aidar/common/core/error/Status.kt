package ru.aidar.common.core.error

interface Status {
    fun apply(): Boolean

    object Success : Status {
        override fun apply(): Boolean {
            return true
        }
    }

    data class Fail(val message: String) : Status {
        override fun apply(): Boolean {
            return false
        }
    }

    data class Cancel(val message: String, val throwable: String) : Status {
        override fun apply(): Boolean {
            return false
        }
    }
}
