package com.github.onotoliy.geojson.serializers

import com.github.onotoliy.geojson.Polygon
import kotlinx.serialization.CompositeEncoder
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.json.JsonElement

/**
 * Kotlin сериализация/десериализация [Polygon].
 *
 * @author Anatoliy Pokhresnyi
 */
object PolygonSerializer : GeoJsonObjectSerializer<Polygon>(
    "coordinates", ::decode, ::encode
)

/**
 * Десериализация объекта [Polygon].
 *
 * @param element Содержимое объекта [Polygon].
 * @return Объект [Polygon].
 * @author Anatoliy Pokhresnyi
 */
private fun decode(element: JsonElement) = Polygon(decode(element, RingSerializer))

/**
 * Сериялизация объекта [Polygon].
 *
 * @param obj Объект [Polygon].
 * @param structure JSON объект.
 * @param descriptor Описание JSON объекта.
 * @param idx Индекс элемента в JSON объекте.
 * @author Anatoliy Pokhresnyi
 */
private fun encode(obj: Polygon, structure: CompositeEncoder, descriptor: SerialDescriptor, idx: Int) =
    encode(structure, descriptor, idx, RingSerializer, obj.coordinates)
