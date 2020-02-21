package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.CompositeEncoder
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.json.JsonElement
import ru.github.onotoliy.geojson.GeometryCollection

/**
 * Kotlin сериализация/десериализация [GeometryCollection].
 *
 * @author Anatoliy Pokhresnyi
 */
object GeometryCollectionSerializer : GeoJsonObjectSerializer<GeometryCollection>(
    "geometries", ::decode, ::encode
)

/**
 * Десериализация объекта [GeometryCollection].
 *
 * @param element Содержимое объекта [GeometryCollection].
 * @return Объект [GeometryCollection].
 * @author Anatoliy Pokhresnyi
 */
private fun decode(element: JsonElement) = GeometryCollection(decode(element, MultiGeometrySerializer))

/**
 * Сериялизация объекта [GeometryCollection].
 *
 * @param obj Объект [GeometryCollection].
 * @param structure JSON объект.
 * @param descriptor Описание JSON объекта.
 * @param idx Индекс элемента в JSON объекте.
 * @author Anatoliy Pokhresnyi
 */
private fun encode(obj: GeometryCollection, structure: CompositeEncoder, descriptor: SerialDescriptor, idx: Int) =
    encode(structure, descriptor, idx, MultiGeometrySerializer, obj.geometries)
