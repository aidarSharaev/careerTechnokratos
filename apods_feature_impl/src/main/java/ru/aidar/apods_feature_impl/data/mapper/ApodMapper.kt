package ru.aidar.apods_feature_impl.data.mapper

import ru.aidar.apods_feature_api.domain.model.ApodLocal
import ru.aidar.apods_feature_impl.presentation.list.model.ParcelableLocal
import ru.aidar.common.data.db.model.ApodEntity
import javax.inject.Inject

class ApodMappers
@Inject
constructor() {
    fun mapEntityToLocal(entity: ApodEntity): ApodLocal {
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

    fun mapLocalToEntity(apodLocal: ApodLocal, page: Int): ApodEntity {
        return with(apodLocal) {
            ApodEntity(
                url = this.url!!,
                copyright = this.copyright ?: "Nasa",
                date = this.date,
                explanation = this.explanation,
                title = this.title,
                page = page
            )
        }
    }
}

fun ApodLocal.toParce(): ParcelableLocal {
    return ParcelableLocal(
        copyright = this.copyright ?: "Nasa",
        date = this.date,
        explanation = this.explanation,
        title = this.title,
        url = this.url!!
    )
}

