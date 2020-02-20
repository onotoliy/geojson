package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.CompositeEncoder
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.json.JsonElement
import ru.github.onotoliy.geojson.GeometryCollection
import ru.github.onotoliy.geojson.MultiGeometry

/**
 * Kotlin сериализация/десериализация [GeometryCollection].
 *
 * @author Anatoliy Pokhresnyi
 */
object GeometryCollectionSerializer : GeoJsonObjectSerializer<GeometryCollection>(
    "geometries", ::decode, ::encode
)

private fun decode(element: JsonElement) = GeometryCollection(decode(element, MultiGeometrySerializer))
private fun encode(obj: GeometryCollection, structure: CompositeEncoder, descriptor: SerialDescriptor, idx: Int) =
    encode(structure, descriptor, idx, MultiGeometrySerializer, obj.geometries)