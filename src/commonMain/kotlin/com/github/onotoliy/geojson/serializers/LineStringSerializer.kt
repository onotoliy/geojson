package com.github.onotoliy.geojson.serializers

import com.github.onotoliy.geojson.LineString
import kotlinx.serialization.CompositeEncoder
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.json.JsonElement

/**
 * Kotlin сериализация/десериализация [LineString].
 *
 * @author Anatoliy Pokhresnyi
 */
object LineStringSerializer : GeoJsonObjectSerializer<LineString>(
    "coordinates", ::decode, ::encode
)

/**
 * Десериализация объекта [LineString].
 *
 * @param element Содержимое объекта [LineString].
 * @return Объект [LineString].
 * @author Anatoliy Pokhresnyi
 */
private fun decode(element: JsonElement) = LineString(decode(element, MultiPositionSerializer))

/**
 * Сериялизация объекта [LineString].
 *
 * @param obj Объект [LineString].
 * @param structure JSON объект.
 * @param descriptor Описание JSON объекта.
 * @param idx Индекс элемента в JSON объекте.
 * @author Anatoliy Pokhresnyi
 */
private fun encode(obj: LineString, structure: CompositeEncoder, descriptor: SerialDescriptor, idx: Int) =
    encode(structure, descriptor, idx, MultiPositionSerializer, obj.coordinates)
