package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.*
import ru.github.onotoliy.geojson.MultiRing

/**
 * Kotlin сериализация/десериализация [MultiRing].
 *
 * @author Anatoliy Pokhresnyi
 */
object MultiRingSerializer : GeoJsonCoordinateSerializer<MultiRing>(
    ::decode, ::encode
)

private fun decode(decoder: Decoder) = decoder.decode(RingSerializer.list).let(::MultiRing)
private fun encode(obj: MultiRing, encoder: Encoder) = encoder.encode(RingSerializer.list, obj.coordinates)