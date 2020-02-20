package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.CompositeEncoder
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.json.JsonElement
import ru.github.onotoliy.geojson.Point

/**
 * Kotlin сериализация/десериализация [Point].
 *
 * @author Anatoliy Pokhresnyi
 */
object PointSerializer : GeoJsonObjectSerializer<Point>(
    "coordinates", ::decode, ::encode
)

private fun decode(element: JsonElement) = Point(decode(element, PositionSerializer))
private fun encode(obj: Point, structure: CompositeEncoder, descriptor: SerialDescriptor, idx: Int) =
    encode(structure, descriptor, idx, PositionSerializer, obj.coordinates)