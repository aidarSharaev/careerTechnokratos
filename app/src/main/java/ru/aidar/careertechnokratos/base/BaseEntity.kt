package ru.aidar.careertechnokratos.base

interface BaseEntity {
    fun toDto(): BaseDto.BaseEntityDto
}