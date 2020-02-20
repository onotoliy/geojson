package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.*
import kotlinx.serialization.internal.SerialClassDescImpl
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonElementSerializer
import ru.github.onotoliy.geojson.GeoJsonObject
import ru.github.onotoliy.geojson.getType

abstract class GeoJsonObjectSerializer<G: GeoJsonObject<*>>(
    private val coordinates: String,
    private val decodeCoordinateElement: (JsonElement) -> G,
    private val encodeCoordinateElement: (G, CompositeEncoder, SerialDescriptor, Int) -> Unit
) : KSerializer<G> {

    private val type: String = this::class.getType().removeSuffix("Serializer")

    override val descriptor: SerialDescriptor
        get() = object : SerialClassDescImpl("${type}Serializer") {
            init {
                addElement("type")
                addElement(coordinates)
            }
        }

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
                    decodeCoordinateElement(structure.decodeSerializableElement(descriptor, idx, JsonElementSerializer))
            }
        }

        structure.endStructure(descriptor)

        if (geometry == null) {
            throw IllegalArgumentException("Block of $coordinates is not found")
        }

        return geometry
    }

    override fun serialize(encoder: Encoder, obj: G) {
        val structure = encoder.beginStructure(descriptor)

        structure.encodeStringElement(descriptor, 0, obj.type)
        encodeCoordinateElement(obj, structure, descriptor, 1)

        structure.endStructure(descriptor)
    }
}