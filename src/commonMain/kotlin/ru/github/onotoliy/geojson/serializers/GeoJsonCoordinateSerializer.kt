package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.internal.StringDescriptor
import kotlinx.serialization.withName
import ru.github.onotoliy.geojson.GeoJsonCoordinate
import ru.github.onotoliy.geojson.getType

/**
 * Kotlin сериализация/десериализация координат GeoJson объекта.
 *
 * @param decode Десериализация координат GeoJson объекта.
 * @param encode Сереализция коодинат GeoJson объекта
 * @author Anatoliy Pokhresnyi
 */
abstract class GeoJsonCoordinateSerializer<G : GeoJsonCoordinate>(
    private val decode: (Decoder) -> G,
    private val encode: (G, Encoder) -> Unit
) : KSerializer<G> {
    override val descriptor: SerialDescriptor
        get() = StringDescriptor.withName(this::class.getType())

    override fun serialize(encoder: Encoder, obj: G) = encode(obj, encoder)

    override fun deserialize(decoder: Decoder): G = decode(decoder)
}
