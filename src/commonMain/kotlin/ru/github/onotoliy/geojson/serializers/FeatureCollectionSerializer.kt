package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.CompositeEncoder
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.json.JsonElement
import ru.github.onotoliy.geojson.FeatureCollection

/**
 * Kotlin сериализация/десериализация [FeatureCollection].
 *
 * @author Anatoliy Pokhresnyi
 */
object FeatureCollectionSerializer : GeoJsonObjectSerializer<FeatureCollection>(
    "features", ::decode, ::encode
)

/**
 * Десериялизация координат объекта [FeatureCollection].
 *
 * @param element Координаты объекта [FeatureCollection].
 * @return Объект [FeatureCollection].
 * @author Anatoliy Pokhresnyi
 */
private fun decode(element: JsonElement) = FeatureCollection(decode(element, MultiFeatureSerializer))

/**
 * Сериялизация координат объекта [FeatureCollection].
 *
 * @param obj Объект [FeatureCollection].
 * @param structure JSON объект.
 * @param descriptor Описание JSON объекта.
 * @param idx Индекс элемента в JSON объекте.
 * @author Anatoliy Pokhresnyi
 */
private fun encode(obj: FeatureCollection, structure: CompositeEncoder, descriptor: SerialDescriptor, idx: Int) =
    encode(structure, descriptor, idx, MultiFeatureSerializer, obj.features)