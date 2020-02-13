package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.MultiPositionJsonDeserializer
import ru.github.onotoliy.geojson.serializer.MultiPositionJsonSerializer

@JsonSerialize(using = MultiPositionJsonSerializer::class)
@JsonDeserialize(using = MultiPositionJsonDeserializer::class)
actual class MultiPosition actual constructor(actual val coordinates: List<Position>) :
    AbstractGeometryCoordinate<Position>(coordinates)