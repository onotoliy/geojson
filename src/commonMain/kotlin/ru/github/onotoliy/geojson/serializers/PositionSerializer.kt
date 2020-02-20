package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.*
import ru.github.onotoliy.geojson.Polygon
import ru.github.onotoliy.geojson.Position
import ru.github.onotoliy.geojson.Ring

/**
 * Kotlin сериализация/десериализация [Position].
 *
 * @author Anatoliy Pokhresnyi
 */
object PositionSerializer : GeoJsonCoordinateSerializer<Position>(
    ::decode, ::encode
)

/**
 * Десериализация объекта [Position].
 *
 * @param decoder Содержимое объекта [Position].
 * @return Объект [Position].
 * @author Anatoliy Pokhresnyi
 */
private fun decode(decoder: Decoder) =
    decoder.decode(Double.serializer().list).let { Position(it[0], it[1]) }

/**
 * Сериялизация объекта [Position].
 *
 * @param obj Объект [Position].
 * @param encoder JSON объект.
 * @author Anatoliy Pokhresnyi
 */
private fun encode(obj: Position, encoder: Encoder) =
    encoder.encode(Double.serializer().list, listOf(obj.x, obj.y))