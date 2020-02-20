package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.*
import ru.github.onotoliy.geojson.Position

/**
 * Kotlin сериализация/десериализация [Position].
 *
 * @author Anatoliy Pokhresnyi
 */
object PositionSerializer : GeoJsonCoordinateSerializer<Position>(
    ::decode, ::encode
)

private fun decode(decoder: Decoder) = decoder.decode(Double.serializer().list).let { Position(it[0], it[1]) }
private fun encode(obj: Position, encoder: Encoder) =
    encoder.encode(Double.serializer().list, listOf(obj.x, obj.y))