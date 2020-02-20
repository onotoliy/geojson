package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.CompositeEncoder
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.json.JsonElement
import ru.github.onotoliy.geojson.LineString
import ru.github.onotoliy.geojson.MultiPosition

/**
 * Kotlin сериализация/десериализация [LineString].
 *
 * @author Anatoliy Pokhresnyi
 */
object LineStringSerializer : GeoJsonObjectSerializer<LineString>(
    "coordinates", ::decode, ::encode
)

private fun decode(element: JsonElement) = LineString(decode(element, MultiPositionSerializer))
private fun encode(obj: LineString, structure: CompositeEncoder, descriptor: SerialDescriptor, idx: Int) =
    encode(structure, descriptor, idx, MultiPositionSerializer, obj.coordinates)