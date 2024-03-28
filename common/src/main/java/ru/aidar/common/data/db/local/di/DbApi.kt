package ru.aidar.common.data.db.local.di

import ru.aidar.common.data.db.local.GalaxyPulseDatabase

interface DbApi {
    fun provideDatabase(): GalaxyPulseDatabase
}
