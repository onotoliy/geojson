package com.github.onotoliy.geojson.serializers

import com.github.onotoliy.geojson.GeoJsonObject
import com.github.onotoliy.geojson.getType
import kotlinx.serialization.CompositeDecoder
import kotlinx.serialization.CompositeEncoder
import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.internal.SerialClassDescImpl
import kotlinx.serialization.json.JsonElement
import kotlinx.serialization.json.JsonElementSerializer

/**
 * Kotlin сериализация/десериализация GeoJson объекта.
 *
 * @param coordinates Название блока с координатами.
 * @param decodeCoordinateElement Десериализация координат GeoJson объекта.
 * @param encodeCoordinateElement Сереализция коодинат GeoJson объекта
 * @author Anatoliy Pokhresnyi
 */
abstract class GeoJsonObjectSerializer<G : GeoJsonObject<*>>(
    private val coordinates: String,
    private val decodeCoordinateElement: (JsonElement) -> G,
    private val encodeCoordinateElement: (G, CompositeEncoder, SerialDescriptor, Int) -> Unit
) : KSerializer<G> {

    /**
     * Тип GeoJson объекта.
     */
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
