package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.*
import ru.github.onotoliy.geojson.MultiPosition
import ru.github.onotoliy.geojson.MultiRing
import ru.github.onotoliy.geojson.Position
import ru.github.onotoliy.geojson.Ring

/**
 * Kotlin сериализация/десериализация [MultiPosition].
 *
 * @author Anatoliy Pokhresnyi
 */
object MultiPositionSerializer : GeoJsonCoordinateSerializer<MultiPosition>(
    ::decode, ::encode
)

private fun decode(decoder: Decoder) = decoder.decode(PositionSerializer.list).let(::MultiPosition)
private fun encode(obj: MultiPosition, encoder: Encoder) = encoder.encode(PositionSerializer.list, obj.coordinates)