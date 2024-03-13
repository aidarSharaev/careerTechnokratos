package ru.aidar.common.data.db.di

import ru.aidar.common.data.db.GalaxyPulseDatabase

interface DbApi {

    fun provideDatabase(): GalaxyPulseDatabase
}