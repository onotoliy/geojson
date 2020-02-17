package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.*
import kotlinx.serialization.internal.SerialClassDescImpl
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonElementSerializer
import ru.github.onotoliy.geojson.*

/**
 * Kotlin сериализация/десериализация [Geometry].
 *
 * @author Anatoliy Pokhresnyi
 */
object GeometrySerializer : KSerializer<Geometry> {
    override val descriptor: SerialDescriptor
        get() = object : SerialClassDescImpl("GeometrySerializer") {
            init {
                addElement("type")
                addElement("coordinates")
            }
        }

    override fun serialize(encoder: Encoder, obj: Geometry) {
        when (obj.type) {
            "Point" -> encoder.encode(PointSerializer, obj as Point)
            "MultiPoint" -> encoder.encode(MultiPointSerializer, obj as MultiPoint)
            "Polygon" -> encoder.encode(PolygonSerializer, obj as Polygon)
            "MultiPolygon" -> encoder.encode(MultiPolygonSerializer, obj as MultiPolygon)
            "LineString" -> encoder.encode(LineStringSerializer, obj as LineString)
            "MultiLineString" -> encoder.encode(MultiLineStringSerializer, obj as MultiLineString)
        }
    }

    override fun deserialize(decoder: Decoder): Geometry {
        val json = Json(JsonConfiguration.Stable)

        var type: String? = null
        var coordinate: JsonElement? = null

        val structure: CompositeDecoder = decoder.beginStructure(descriptor)

        for (number in 1..descriptor.elementsCount) {
            val idx = structure.decodeElementIndex(descriptor)

            when (descriptor.getElementName(idx)) {
                "type" ->
                    type = structure.decodeStringElement(descriptor, idx)
                "coordinates" ->
                    coordinate = structure.decodeSerializableElement(descriptor, idx, JsonElementSerializer)
            }
        }

        structure.endStructure(descriptor)

        if (type == null) {
            throw IllegalArgumentException("Block of type is not found")
        }

        if (coordinate == null) {
            throw IllegalArgumentException("Block of coordinates is not found")
        }

        return when (type) {
            "Point" -> Point(json.fromJson(PositionSerializer, coordinate))
            "MultiPoint" -> MultiPoint(json.fromJson(MultiPositionSerializer, coordinate))
            "LineString" -> LineString(json.fromJson(MultiPositionSerializer, coordinate))
            "MultiLineString" -> MultiLineString(json.fromJson(RingSerializer, coordinate))
            "Polygon" -> Polygon(json.fromJson(RingSerializer, coordinate))
            "MultiPolygon" -> MultiPolygon(json.fromJson(MultiRingSerializer, coordinate))
            else -> throw IllegalArgumentException()
        }
    }
}