package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.CompositeEncoder
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.json.JsonElement
import ru.github.onotoliy.geojson.MultiLineString
import ru.github.onotoliy.geojson.MultiPoint
import ru.github.onotoliy.geojson.Ring

/**
 * Kotlin сериализация/десериализация [MultiLineString].
 *
 * @author Anatoliy Pokhresnyi
 */
object MultiLineStringSerializer : GeoJsonObjectSerializer<MultiLineString>(
    "coordinates", ::decode, ::encode
)

private fun decode(element: JsonElement) = MultiLineString(decode(element, RingSerializer))
private fun encode(obj: MultiLineString, structure: CompositeEncoder, descriptor: SerialDescriptor, idx: Int) =
    encode(structure, descriptor, idx, RingSerializer, obj.coordinates)