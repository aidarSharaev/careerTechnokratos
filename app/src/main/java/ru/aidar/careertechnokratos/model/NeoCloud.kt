package ru.aidar.careertechnokratos.model

import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.annotations.SerializedName
import org.json.JSONArray
import org.json.JSONObject
import ru.aidar.careertechnokratos.model.additional.CloseApproachData
import ru.aidar.careertechnokratos.model.additional.EstimatedDiameter
import ru.aidar.careertechnokratos.model.additional.NeoDto
import java.lang.reflect.Type


private val list = arrayListOf(
    "id",
    "name",
    "absolute_magnitude_h",
    "is_potentially_hazardous_asteroid",
    "close_approach_data",
    "estimated_diameter",
)

data class NeoCloud(
    //val links: Links,
    @SerializedName("near_earth_objects")
    val nearEarthObjects: List<NeoDto>
    //val near_earth_objects: Map<String, NearEarthObjects>
    //val near_earth_objects: NearEarthObjects
)

class CustomDeserializer : JsonDeserializer<NeoCloud> {

    private val gson = Gson()

    override fun deserialize(
        json: JsonElement,
        typeOfT: Type?,
        context: JsonDeserializationContext
    ): NeoCloud {
        //val dynamicData: MutableMap<String, NearEarthObjects> = mutableMapOf()
        val dynamicData = mutableListOf<NeoDto>()
        val jsonObject = JSONObject(json.toString())

        val dataObject = jsonObject.getJSONObject("near_earth_objects")

        val keys = dataObject.keys()

        keys.forEach {
            val nestedArray = dataObject.getJSONArray(it) // все объекты за н-ый день
            dynamicData.addAll(parsing(dataArray = nestedArray))
            //dynamicData[it] = NearEarthObjects(neoList)
        }

        return NeoCloud(dynamicData)
    }

    private fun parsing(dataArray: JSONArray): MutableList<NeoDto> {
        val nestedList = mutableListOf<NeoDto>()
        var counter = 0

        while(true) {
            if(dataArray.length() <= counter) break
            val dataObject = dataArray.getJSONObject(counter++)
            nestedList.add(dataObject.toDto(gson = gson))
        }
        return nestedList
    }
}

fun JSONObject.toDto(gson: Gson): NeoDto {
    return NeoDto(
        id = this.getString(list[0]),
        name = this.getString(list[1]),
        absoluteMagnitudeH = this.getDouble(list[2]),
        isPotentiallyHazardousAsteroid = this.getBoolean(list[3]),
        closeApproachData = gson.fromJson(
            this.getString(list[4]),
            Array<CloseApproachData>::class.java
        ).toList(),
        estimatedDiameter = gson.fromJson(
            this.getString(list[5]),
            EstimatedDiameter::class.java
        ),
    )
}
