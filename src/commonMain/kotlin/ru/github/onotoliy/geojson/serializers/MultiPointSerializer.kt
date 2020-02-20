package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.CompositeEncoder
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.json.JsonElement
import ru.github.onotoliy.geojson.MultiPoint

/**
 * Kotlin сериализация/десериализация [MultiPoint].
 *
 * @author Anatoliy Pokhresnyi
 */
object MultiPointSerializer : GeoJsonObjectSerializer<MultiPoint>(
    "coordinates", ::decode, ::encode
)

private fun decode(element: JsonElement) = MultiPoint(decode(element, MultiPositionSerializer))
private fun encode(obj: MultiPoint, structure: CompositeEncoder, descriptor: SerialDescriptor, idx: Int) =
    encode(structure, descriptor, idx, MultiPositionSerializer, obj.coordinates)