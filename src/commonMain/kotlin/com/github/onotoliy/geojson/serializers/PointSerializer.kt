package com.github.onotoliy.geojson.serializers

import com.github.onotoliy.geojson.Point
import kotlinx.serialization.CompositeEncoder
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.json.JsonElement

/**
 * Kotlin сериализация/десериализация [Point].
 *
 * @author Anatoliy Pokhresnyi
 */
object PointSerializer : GeoJsonObjectSerializer<Point>(
    "coordinates", ::decode, ::encode
)

/**
 * Десериализация объекта [Point].
 *
 * @param element Содержимое объекта [Point].
 * @return Объект [Point].
 * @author Anatoliy Pokhresnyi
 */
private fun decode(element: JsonElement) = Point(decode(element, PositionSerializer))

/**
 * Сериялизация объекта [Point].
 *
 * @param obj Объект [Point].
 * @param structure JSON объект.
 * @param descriptor Описание JSON объекта.
 * @param idx Индекс элемента в JSON объекте.
 * @author Anatoliy Pokhresnyi
 */
private fun encode(obj: Point, structure: CompositeEncoder, descriptor: SerialDescriptor, idx: Int) =
    encode(structure, descriptor, idx, PositionSerializer, obj.coordinates)
