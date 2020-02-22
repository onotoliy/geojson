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

    /**
     * Десериализация объекта [JsonElement].
     *
     * @param element Json.
     * @return Объект.
     */
    private fun deserialize(element: JsonElement): Any = when (element) {
        is JsonLiteral -> deserialize(element)
        is JsonObject -> deserialize(element)
        is JsonArray -> deserialize(element)
        else -> throw IllegalArgumentException()
    }

    /**
     * Десериализация объекта [JsonElement].
     *
     * @param element Json.
     * @return Объект.
     */
    private fun deserialize(element: JsonObject): Map<String, Any> = element.content.entries.associate {
        it.key to when (val e = it.value) {
            is JsonLiteral -> deserialize(e)
            is JsonObject -> deserialize(e)
            is JsonArray -> deserialize(e)
            else -> throw IllegalArgumentException()
        }
    }

    /**
     * Десериализация объекта [JsonLiteral].
     *
     * @param element Json.
     * @return Объект.
     */
    private fun deserialize(element: JsonLiteral): Any = element.body

    /**
     * Десериализация объекта [JsonArray].
     *
     * @param element Json.
     * @return Объект.
     */
    private fun deserialize(element: JsonArray): List<Any> = element.content.map(::deserialize)

    /**
     * Сериализация в объекта [Any].
     *
     * @param obj Объект.
     * @return Json.
     */
    @Suppress("UNCHECKED_CAST")
    private fun serialize(obj: Any): JsonElement = when (obj) {
        is Collection<*> -> serialize(obj as Collection<Any>)
        is Map<*, *> -> serialize(obj as Map<String, Any>)
        is Number -> JsonLiteral(obj)
        is Boolean -> JsonLiteral(obj)
        else -> JsonLiteral(obj.toString())
    }

    /**
     * Сериализация в объекта [Collection].
     *
     * @param obj Объект.
     * @return Json.
     */
    private fun serialize(obj: Collection<Any>): JsonElement = JsonArray(obj.map(::serialize))

    /**
     * Сериализация в объекта [Map].
     *
     * @param obj Объект.
     * @return Json.
     */
    private fun serialize(obj: Map<String, Any>): JsonElement = JsonObject(obj.entries.associate {
        it.key to serialize(it.value)
    })
}
