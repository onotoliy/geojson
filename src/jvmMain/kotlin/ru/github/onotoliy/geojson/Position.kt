package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.PositionJacksonDeserializer
import ru.github.onotoliy.geojson.serializer.PositionJacksonSerializer

@JsonSerialize(using = PositionJacksonSerializer::class)
@JsonDeserialize(using = PositionJacksonDeserializer::class)
actual open class Position actual constructor(actual val x: Double, actual val y: Double) :
    AbstractPosition(x, y), GeometryCoordinate