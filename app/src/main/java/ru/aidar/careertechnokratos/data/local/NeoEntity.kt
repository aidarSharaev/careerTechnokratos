package ru.aidar.careertechnokratos.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.Gson
import ru.aidar.careertechnokratos.base.BaseEntity
import ru.aidar.careertechnokratos.constants.Constants.NEO_ENTITY_TABLE
import ru.aidar.careertechnokratos.model.additional.CloseApproachData
import ru.aidar.careertechnokratos.model.additional.EstimatedDiameter
import ru.aidar.careertechnokratos.model.additional.NeoDto

@Entity(tableName = NEO_ENTITY_TABLE)
data class NeoEntity(
    @PrimaryKey
    val id: String,
    val absoluteMagnitudeH: Double,
    val closeApproachData: List<CloseApproachData>,
    val estimatedDiameter: EstimatedDiameter,
    val isPotentiallyHazardousAsteroid: Boolean,
    val name: String,
) : BaseEntity {
    override fun toDto(): NeoDto {
        return NeoDto(
            id = id,
            absoluteMagnitudeH = absoluteMagnitudeH,
            closeApproachData = closeApproachData,
            estimatedDiameter = estimatedDiameter,
            isPotentiallyHazardousAsteroid = isPotentiallyHazardousAsteroid,
            name = name,
        )
    }
}

class Converters {
    @TypeConverter
    fun listCloseApproachDataToJson(value: List<CloseApproachData>) = Gson().toJson(value)

    @TypeConverter
    fun listCloseApproachDataToList(value: String) =
        Gson().fromJson(value, Array<CloseApproachData>::class.java).toList()

    @TypeConverter
    fun estimatedDiameterToJson(value: EstimatedDiameter) = Gson().toJson(value)

    @TypeConverter
    fun jsonToEstimatedDiameter(value: String) =
        Gson().fromJson(value, EstimatedDiameter::class.java)
}