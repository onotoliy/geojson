package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.*
import kotlinx.serialization.internal.StringDescriptor
import ru.github.onotoliy.geojson.GeoJsonCoordinate

abstract class GeoJsonCoordinateSerializer<G : GeoJsonCoordinate, C : Any>(
    private val type: String,
    private val get: (G) -> List<C>,
    private val serializer: KSerializer<C>,
    private val newInstance: (List<C>) -> G
) : KSerializer<G> {
    override val descriptor: SerialDescriptor
        get() = StringDescriptor.withName("${type}Serializer")

    override fun serialize(encoder: Encoder, obj: G) =
        encoder.encode(serializer.list, get(obj))

    override fun deserialize(decoder: Decoder): G =
        newInstance(decoder.decode(serializer.list))
}