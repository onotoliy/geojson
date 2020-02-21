package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.GeometryCollectionJacksonDeserializer
import ru.github.onotoliy.geojson.serializer.GeometryCollectionJacksonSerializer

@JsonSerialize(using = GeometryCollectionJacksonSerializer::class)
@JsonDeserialize(using = GeometryCollectionJacksonDeserializer::class)
actual class GeometryCollection actual constructor(geometries: MultiGeometry) :
    GeoJsonObject<MultiGeometry>(geometries) {

    actual val geometries: MultiGeometry
        get() = value
}