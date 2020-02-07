package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.PositionJsonDeserializer
import ru.github.onotoliy.geojson.serializer.PositionJsonSerializer

@JsonSerialize(using = PositionJsonSerializer::class)
@JsonDeserialize(using = PositionJsonDeserializer::class)
actual open class Position actual constructor(actual val x: Double, actual val y: Double) : PositionTyped(x, y),
    GeometryCoordinate