package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.GeometryCollectionJsonDeserializer
import ru.github.onotoliy.geojson.serializer.GeometryCollectionJsonSerializer

@JsonSerialize(using = GeometryCollectionJsonSerializer::class)
@JsonDeserialize(using = GeometryCollectionJsonDeserializer::class)
actual class GeometryCollection actual constructor(geometries: MultiGeometry) :
    GeoJsonObject<MultiGeometry>(geometries) {
    actual val geometries: MultiGeometry
        get() = value
}