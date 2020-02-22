package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.PositionJacksonDeserializer
import ru.github.onotoliy.geojson.serializer.PositionJacksonSerializer

/**
 * Координаты одной точки. Используется для геометрии типа [Point].
 *
 * @property x Широта.
 * @property y Долгота.
 * @author Anatoliy Pokhresnyi
 */
@JsonSerialize(using = PositionJacksonSerializer::class)
@JsonDeserialize(using = PositionJacksonDeserializer::class)
actual open class Position actual constructor(actual val x: Double, actual val y: Double) :
    AbstractPosition(x, y), GeometryCoordinate
