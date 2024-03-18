package ru.aidar.common.base

import androidx.lifecycle.ViewModel

abstract class BaseViewModel : ViewModel() {
    open fun callOnCleared() {
        this.onCleared()
    }
}
