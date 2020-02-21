package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.MultiGeometryJacksonDeserializer
import ru.github.onotoliy.geojson.serializer.MultiGeometryJacksonSerializer

@JsonSerialize(using = MultiGeometryJacksonSerializer::class)
@JsonDeserialize(using = MultiGeometryJacksonDeserializer::class)
actual class MultiGeometry actual constructor(actual val coordinates: List<Geometry>) : AbstractGeoJsonCoordinate<Geometry>(coordinates),
    GeometryCoordinate