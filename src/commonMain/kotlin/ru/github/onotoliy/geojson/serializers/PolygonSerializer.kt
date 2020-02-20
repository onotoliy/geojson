package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.CompositeEncoder
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.json.JsonElement
import ru.github.onotoliy.geojson.Polygon

/**
 * Kotlin сериализация/десериализация [Polygon].
 *
 * @author Anatoliy Pokhresnyi
 */
object PolygonSerializer : GeoJsonObjectSerializer<Polygon>(
    "coordinates", ::decode, ::encode
)

private fun decode(element: JsonElement) = Polygon(decode(element, RingSerializer))
private fun encode(obj: Polygon, structure: CompositeEncoder, descriptor: SerialDescriptor, idx: Int) =
    encode(structure, descriptor, idx, RingSerializer, obj.coordinates)