package ru.aidar.cc_feature_api

interface DialogCondition {

    fun validate(value: String)

    object Begin : DialogCondition {
        // checks that the date is correct
        override fun validate(value: String) {

        }
    }

    object DateReceived : DialogCondition {
        override fun validate(value: String) {
            TODO("Not yet implemented")
        }
    }

    object TimeReceived : DialogCondition {
        override fun validate(value: String) {
            TODO("Not yet implemented")
        }
    }

    object LocationReceived : DialogCondition {
        override fun validate(value: String) {
            TODO("Not yet implemented")
        }
    }

}