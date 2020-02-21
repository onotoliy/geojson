package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.FeatureJacksonDeserializer
import ru.github.onotoliy.geojson.serializer.FeatureJacksonSerializer

@JsonSerialize(using = FeatureJacksonSerializer::class)
@JsonDeserialize(using = FeatureJacksonDeserializer::class)
actual class Feature actual constructor(geometry: Geometry) : GeoJsonObject<Geometry>(geometry) {
    actual val geometry: Geometry
        get() = value
}