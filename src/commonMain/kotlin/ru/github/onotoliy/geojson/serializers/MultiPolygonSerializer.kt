package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.CompositeEncoder
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.json.JsonElement
import ru.github.onotoliy.geojson.MultiPolygon
import ru.github.onotoliy.geojson.MultiPosition
import ru.github.onotoliy.geojson.MultiRing

/**
 * Kotlin сериализация/десериализация [MultiPolygon].
 *
 * @author Anatoliy Pokhresnyi
 */
object MultiPolygonSerializer : GeoJsonObjectSerializer<MultiPolygon>(
    "coordinates", ::decode, ::encode
)

private fun decode(element: JsonElement) = MultiPolygon(decode(element, MultiRingSerializer))
private fun encode(obj: MultiPolygon, structure: CompositeEncoder, descriptor: SerialDescriptor, idx: Int) =
    encode(structure, descriptor, idx, MultiRingSerializer, obj.coordinates)