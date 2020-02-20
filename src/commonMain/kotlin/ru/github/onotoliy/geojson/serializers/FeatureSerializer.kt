package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.CompositeEncoder
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.json.JsonElement
import ru.github.onotoliy.geojson.Feature

/**
 * Kotlin сериализация/десериализация [Feature].
 *
 * @author Anatoliy Pokhresnyi
 */
object FeatureSerializer : GeoJsonObjectSerializer<Feature>(
    "geometry", ::decode, ::encode
)

/**
 * Десериялизация геометрии объекта [Feature].
 *
 * @param element Геометрия объекта [Feature].
 * @return Объект [Feature].
 * @author Anatoliy Pokhresnyi
 */
private fun decode(element: JsonElement) = Feature(decode(element, GeometrySerializer))

/**
 * Сериялизация геометрии объекта [Feature].
 *
 * @param obj Объект [Feature].
 * @param structure JSON объект.
 * @param descriptor Описание JSON объекта.
 * @param idx Индекс элемента в JSON объекте.
 * @author Anatoliy Pokhresnyi
 */
private fun encode(obj: Feature, structure: CompositeEncoder, descriptor: SerialDescriptor, idx: Int) =
    encode(structure, descriptor, idx, GeometrySerializer, obj.geometry)