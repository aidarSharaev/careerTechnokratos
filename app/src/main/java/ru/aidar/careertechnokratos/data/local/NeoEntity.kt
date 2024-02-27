package ru.aidar.careertechnokratos.data.local

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class NeoEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    @Embedded
    val nearEarthObjects: NearEarthObjects
    /*    @PrimaryKey
        val id: String,
        val name: String,
        val absoluteMagnitudeH: Double,
        val isPotentiallyHazardousAsteroid: Boolean,
        val closeApproachData: List<CloseApproachData>,
        val estimatedDiameter: EstimatedDiameter,*/
) /*: BaseEntity {
    override fun toDto(): NeoDto {
        return NeoDto(nearEarthObjects = nearEarthObjects)
    }
}*/