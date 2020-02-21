package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.CompositeEncoder
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.json.JsonElement
import ru.github.onotoliy.geojson.MultiPolygon

/**
 * Kotlin сериализация/десериализация [MultiPolygon].
 *
 * @author Anatoliy Pokhresnyi
 */
object MultiPolygonSerializer : GeoJsonObjectSerializer<MultiPolygon>(
    "coordinates", ::decode, ::encode
)

/**
 * Десериализация объекта [MultiPolygon].
 *
 * @param element Содержимое объекта [MultiPolygon].
 * @return Объект [MultiPolygon].
 * @author Anatoliy Pokhresnyi
 */
private fun decode(element: JsonElement) = MultiPolygon(decode(element, MultiRingSerializer))

/**
 * Сериялизация объекта [MultiPolygon].
 *
 * @param obj Объект [MultiPolygon].
 * @param structure JSON объект.
 * @param descriptor Описание JSON объекта.
 * @param idx Индекс элемента в JSON объекте.
 * @author Anatoliy Pokhresnyi
 */
private fun encode(obj: MultiPolygon, structure: CompositeEncoder, descriptor: SerialDescriptor, idx: Int) =
    encode(structure, descriptor, idx, MultiRingSerializer, obj.coordinates)
