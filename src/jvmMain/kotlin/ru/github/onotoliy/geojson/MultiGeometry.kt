package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.MultiGeometryJsonDeserializer
import ru.github.onotoliy.geojson.serializer.MultiGeometryJsonSerializer

@JsonSerialize(using = MultiGeometryJsonSerializer::class)
@JsonDeserialize(using = MultiGeometryJsonDeserializer::class)
actual class MultiGeometry actual constructor(actual val coordinates: List<Geometry>) : AbstractGeoJsonCoordinate<Geometry>(coordinates),
    GeometryCoordinate