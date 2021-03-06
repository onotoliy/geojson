package com.github.onotoliy.geojson.serializers

import com.github.onotoliy.geojson.MultiLineString
import kotlinx.serialization.CompositeEncoder
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.json.JsonElement

/**
 * Kotlin сериализация/десериализация [MultiLineString].
 *
 * @author Anatoliy Pokhresnyi
 */
object MultiLineStringSerializer : GeoJsonObjectSerializer<MultiLineString>(
    "coordinates", ::decode, ::encode
)

/**
 * Десериализация объекта [MultiLineString].
 *
 * @param element Содержимое объекта [MultiLineString].
 * @return Объект [MultiLineString].
 * @author Anatoliy Pokhresnyi
 */
private fun decode(element: JsonElement) = MultiLineString(decode(element, RingSerializer))

/**
 * Сериялизация объекта [MultiLineString].
 *
 * @param obj Объект [MultiLineString].
 * @param structure JSON объект.
 * @param descriptor Описание JSON объекта.
 * @param idx Индекс элемента в JSON объекте.
 * @author Anatoliy Pokhresnyi
 */
private fun encode(obj: MultiLineString, structure: CompositeEncoder, descriptor: SerialDescriptor, idx: Int) =
    encode(structure, descriptor, idx, RingSerializer, obj.coordinates)
