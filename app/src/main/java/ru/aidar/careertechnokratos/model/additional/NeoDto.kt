package ru.aidar.careertechnokratos.model.additional

import com.google.gson.annotations.SerializedName
import ru.aidar.common.base.BaseDto
import ru.aidar.careertechnokratos.data.local.NeoEntity

data class NeoDto(
    @SerializedName("absolute_magnitude_h")
    val absoluteMagnitudeH: Double,
    @SerializedName("close_approach_data")
    val closeApproachData: List<CloseApproachData>,
    @SerializedName("estimated_diameter")
    val estimatedDiameter: EstimatedDiameter,
    @SerializedName("id")
    val id: String,
    @SerializedName("is_potentially_hazardous_asteroid")
    val isPotentiallyHazardousAsteroid: Boolean,
    @SerializedName("name")
    val name: String,
) : BaseDto.BaseEntityDto() {
    override fun toEntity(): NeoEntity {
        return NeoEntity (
            id = id,
            absoluteMagnitudeH = absoluteMagnitudeH,
            closeApproachData = closeApproachData,
            estimatedDiameter = estimatedDiameter,
            isPotentiallyHazardousAsteroid = isPotentiallyHazardousAsteroid,
            name = name,
        )
    }
}