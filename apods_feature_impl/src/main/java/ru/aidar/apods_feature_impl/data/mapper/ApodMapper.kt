package ru.aidar.apods_feature_impl.data.mapper

import ru.aidar.apods_feature_api.domain.model.ApodLocal
import ru.aidar.common.data.db.model.ApodEntity
import javax.inject.Inject

class ApodMappers
    @Inject
    constructor() {
        fun mapEntityLocal(entity: ApodEntity): ApodLocal {
            return with(entity) {
                ApodLocal(
                    url = this.url,
                    copyright = this.copyright,
                    date = this.date,
                    explanation = this.explanation,
                    title = this.title,
                )
            }
        }

        fun mapLocalToEntity(apodDto: ApodLocal): ApodEntity {
            return with(apodDto) {
                ApodEntity(
                    url = this.url,
                    copyright = this.copyright ?: "Nasa",
                    date = this.date,
                    explanation = this.explanation,
                    title = this.title,
                )
            }
        }
    }
