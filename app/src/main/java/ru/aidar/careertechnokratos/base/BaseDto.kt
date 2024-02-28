package ru.aidar.careertechnokratos.base

interface BaseDto {


    abstract class BaseEntityDto : BaseDto {
        abstract fun toEntity(): BaseEntity

    }

    abstract class BaseListEntityDto : BaseDto {
        abstract fun toListEntity(): List<BaseEntity>
    }

}