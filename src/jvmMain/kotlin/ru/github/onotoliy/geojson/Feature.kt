package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.FeatureJsonDeserializer
import ru.github.onotoliy.geojson.serializer.FeatureJsonSerializer

@JsonSerialize(using = FeatureJsonSerializer::class)
@JsonDeserialize(using = FeatureJsonDeserializer::class)
actual class Feature actual constructor(geometry: Geometry) : GeoJsonObject<Geometry>(geometry) {
    actual val geometry: Geometry
        get() = value
}