package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.*
import ru.github.onotoliy.geojson.Ring

/**
 * Kotlin сериализация/десериализация [Ring].
 *
 * @author Anatoliy Pokhresnyi
 */
object RingSerializer : GeoJsonCoordinateSerializer<Ring>(
    ::decode, ::encode
)

private fun decode(decoder: Decoder) = decoder.decode(MultiPositionSerializer.list).let(::Ring)
private fun encode(obj: Ring, encoder: Encoder) = encoder.encode(MultiPositionSerializer.list, obj.coordinates)