package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.CompositeDecoder
import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.internal.SerialClassDescImpl
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonElementSerializer
import kotlinx.serialization.json.JsonLiteral
import kotlinx.serialization.json.JsonObject
import kotlinx.serialization.list
import kotlinx.serialization.serializer
import ru.github.onotoliy.geojson.Feature
import ru.github.onotoliy.geojson.Geometry

/**
 * Kotlin сериализация/десериализация [Feature].
 *
 * @author Anatoliy Pokhresnyi
 */
object FeatureSerializer : KSerializer<Feature> {

    override val descriptor: SerialDescriptor
        get() = object : SerialClassDescImpl("FeatureSerializerNew") {
            init {
                addElement("type")
                addElement("geometry")
                addElement("bbox")
                addElement("properties")
            }
        }

    override fun deserialize(decoder: Decoder): Feature {
        val structure: CompositeDecoder = decoder.beginStructure(descriptor)

        var geometry: Geometry? = null
        var bbox: List<Double>? = null
        var properties: JsonElement? = null

        for (number in 1..descriptor.elementsCount) {
            val idx = structure.decodeElementIndex(descriptor)

            if (idx == -1) {
                continue
            }

            when (descriptor.getElementName(idx)) {
                "type" -> {
                    val type = structure.decodeStringElement(descriptor, idx)

                    if (type != "Feature") {
                        throw IllegalArgumentException("Wrong type $type but expected Feature")
                    }
                }
                "geometry" -> geometry =
                    structure.decodeSerializableElement(descriptor, idx, GeometrySerializer)
                "bbox" -> bbox =
                    structure.decodeSerializableElement(descriptor, idx, Double.serializer().list)
                "properties" -> properties =
                    structure.decodeSerializableElement(descriptor, idx, JsonElementSerializer)
            }
        }

        structure.endStructure(descriptor)

        if (geometry == null) {
            throw IllegalArgumentException("Block of geometry is not found")
        }

        return Feature(
            geometry,
            bbox ?: listOf(),
            properties?.let { deserialize(properties as JsonObject) } ?: mapOf())
    }

    override fun serialize(encoder: Encoder, obj: Feature) {
        val structure = encoder.beginStructure(descriptor)

        structure.encodeStringElement(descriptor, 0, obj.type)
        structure.encodeSerializableElement(descriptor, 1, GeometrySerializer, obj.geometry)

        if (obj.bbox.isNotEmpty()) {
            structure.encodeSerializableElement(descriptor, 2, Double.serializer().list, obj.bbox)
        }

        if (obj.properties.isNotEmpty()) {
            structure.encodeSerializableElement(descriptor, 3, JsonElementSerializer, serialize(obj.properties))
        }

        structure.endStructure(descriptor)
    }

    private fun deserialize(e: JsonElement): Any = when (e) {
        is JsonLiteral -> deserialize(e)
        is JsonObject -> deserialize(e)
        is JsonArray -> deserialize(e)
        else -> throw IllegalArgumentException()
    }

    private fun deserialize(e: JsonObject): Map<String, Any> = e.content.entries.associate {
        it.key to when (val element = it.value) {
            is JsonLiteral -> deserialize(element)
            is JsonObject -> deserialize(element)
            is JsonArray -> deserialize(element)
            else -> throw IllegalArgumentException()
        }
    }

    private fun deserialize(e: JsonLiteral): Any = e.body

    private fun deserialize(e: JsonArray): List<Any> = e.content.map(::deserialize)

    @Suppress("UNCHECKED_CAST")
    private fun serialize(e: Any): JsonElement = when (e) {
        is Collection<*> -> serialize(e as Collection<Any>)
        is Map<*, *> -> serialize(e as Map<String, Any>)
        is Number -> JsonLiteral(e)
        is Boolean -> JsonLiteral(e)
        else -> JsonLiteral(e.toString())
    }

    private fun serialize(e: Collection<Any>): JsonElement = JsonArray(e.map(::serialize))

    private fun serialize(e: Map<String, Any>): JsonElement = JsonObject(e.entries.associate {
        it.key to serialize(it.value)
    })
}
