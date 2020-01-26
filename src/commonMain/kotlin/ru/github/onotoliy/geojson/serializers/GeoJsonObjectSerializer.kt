package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.*
import kotlinx.serialization.internal.SerialClassDescImpl
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonElementSerializer
import ru.github.onotoliy.geojson.GeoJsonObject

abstract class GeoJsonObjectSerializer<G : GeoJsonObject<C>, C : Any>(
    internal val type: String,
    private val coordinates: String,
    internal val toObject: (G) -> C,
    private val serializer: KSerializer<C>? = null
) : KSerializer<G> {

    private val json = Json(JsonConfiguration.Stable)

    override val descriptor: SerialDescriptor
        get() = object : SerialClassDescImpl("${type}Serializer") {
            init {
                addElement("type")
                addElement(coordinates)
            }
        }

    abstract fun deserialize(json: Json, element: JsonElement): G

    override fun deserialize(decoder: Decoder): G {
        val structure: CompositeDecoder = decoder.beginStructure(descriptor)

        var geometry: G? = null

        for (number in 1..descriptor.elementsCount) {
            val idx = structure.decodeElementIndex(descriptor)

            when (descriptor.getElementName(idx)) {
                "type" -> {
                    val type = structure.decodeStringElement(descriptor, idx)

                    if (type != this.type) {
                        throw IllegalArgumentException("Wrong type $type but expected ${this.type}")
                    }
                }
                coordinates -> geometry =
                    deserialize(json, structure.decodeSerializableElement(descriptor, idx, JsonElementSerializer))
            }
        }

        structure.endStructure(descriptor)

        if (geometry == null) {
            throw IllegalArgumentException("Block of $coordinates is not found")
        }

        return geometry
    }

    override fun serialize(encoder: Encoder, obj: G) {
        if (serializer == null) {
            throw IllegalArgumentException()
        }

        val structure = encoder.beginStructure(descriptor)

        structure.encodeStringElement(descriptor, 0, obj.type)
        structure.encodeSerializableElement(descriptor, 1, serializer, toObject(obj))

        structure.endStructure(descriptor)
    }
}