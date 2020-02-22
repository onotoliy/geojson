package ru.github.onotoliy.geojson

import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import ru.github.onotoliy.geojson.serializer.PositionJacksonDeserializer
import ru.github.onotoliy.geojson.serializer.PositionJacksonSerializer

/**
 * Координаты одной точки. Используется для геометрии типа [Point].
 *
 * @property x Долгота (Ось X).
 * @property y Широта (Ось Y).
 * @property z Высота (Ось Z).
 * @author Anatoliy Pokhresnyi
 */
@JsonSerialize(using = PositionJacksonSerializer::class)
@JsonDeserialize(using = PositionJacksonDeserializer::class)
actual class Position actual constructor(x: Double, y: Double, z: Double?) : AbstractPosition(x, y, z),
    GeometryCoordinate {
    /**
     * Широта (Ось Y).
     */
    actual val latitude: Double
        get() = y
    /**
     * Долгота (Ось X).
     */
    actual val longitude: Double
        get() = x
    /**
     * Высота (Ось Z).
     */
    actual val altitude: Double?
        get() = z
}
