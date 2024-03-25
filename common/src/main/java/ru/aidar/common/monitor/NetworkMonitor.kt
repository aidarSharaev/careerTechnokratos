package ru.aidar.common.monitor

import kotlinx.coroutines.flow.Flow

interface NetworkMonitor {

    val isOnline: Flow<Boolean>
}