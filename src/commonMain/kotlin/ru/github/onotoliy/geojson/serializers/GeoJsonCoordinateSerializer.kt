package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.*
import kotlinx.serialization.internal.StringDescriptor
import ru.github.onotoliy.geojson.GeoJsonCoordinate
import ru.github.onotoliy.geojson.getType

abstract class GeoJsonCoordinateSerializer<G : GeoJsonCoordinate>(
    private val decode: (Decoder) -> G,
    private val encode: (G, Encoder) -> Unit
) : KSerializer<G> {
    override val descriptor: SerialDescriptor
        get() = StringDescriptor.withName(this::class.getType())

    override fun serialize(encoder: Encoder, obj: G) = encode(obj, encoder)

    override fun deserialize(decoder: Decoder): G = decode(decoder)
}