package ru.aidar.common.base

interface BaseEntity {
    fun toDto(): BaseDto.BaseEntityDto
}