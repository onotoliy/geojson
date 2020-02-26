package com.github.onotoliy.geojson.serializers

import com.github.onotoliy.geojson.MultiPoint
import kotlinx.serialization.CompositeEncoder
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.json.JsonElement

/**
 * Kotlin сериализация/десериализация [MultiPoint].
 *
 * @author Anatoliy Pokhresnyi
 */
object MultiPointSerializer : GeoJsonObjectSerializer<MultiPoint>(
    "coordinates", ::decode, ::encode
)

/**
 * Десериализация объекта [MultiPoint].
 *
 * @param element Содержимое объекта [MultiPoint].
 * @return Объект [MultiPoint].
 * @author Anatoliy Pokhresnyi
 */
private fun decode(element: JsonElement) = MultiPoint(decode(element, MultiPositionSerializer))

/**
 * Сериялизация объекта [MultiPoint].
 *
 * @param obj Объект [MultiPoint].
 * @param structure JSON объект.
 * @param descriptor Описание JSON объекта.
 * @param idx Индекс элемента в JSON объекте.
 * @author Anatoliy Pokhresnyi
 */
private fun encode(obj: MultiPoint, structure: CompositeEncoder, descriptor: SerialDescriptor, idx: Int) =
    encode(structure, descriptor, idx, MultiPositionSerializer, obj.coordinates)
