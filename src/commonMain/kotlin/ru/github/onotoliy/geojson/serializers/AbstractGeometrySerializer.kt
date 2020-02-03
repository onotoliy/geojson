package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import ru.github.onotoliy.geojson.*

abstract class AbstractGeometrySerializer<G : Geometry, C : GeoJsonCoordinate>(
    type: String,
    private val newInstance: (coordinate: C) -> G,
    private val deserializer: KSerializer<C>) :

    GeoJsonObjectSerializer<G, GeometryCoordinate>(type, "coordinates", Geometry::coordinates, null) {

    override fun deserialize(json: Json, element: JsonElement): G {
        return newInstance(json.fromJson(deserializer, element))
    }

    override fun serialize(encoder: Encoder, obj: G) {
        val structure = encoder.beginStructure(descriptor)

        structure.encodeStringElement(descriptor, 0, obj.type)

        @Suppress("UNCHECKED_CAST")
        structure.encodeSerializableElement(descriptor, 1, deserializer, toObject(obj) as C)

        structure.endStructure(descriptor)
    }
}