package com.github.onotoliy.geojson.serializers

import com.github.onotoliy.geojson.FeatureCollection
import kotlinx.serialization.CompositeEncoder
import kotlinx.serialization.SerialDescriptor
import kotlinx.serialization.json.JsonElement

/**
 * Kotlin сериализация/десериализация [FeatureCollection].
 *
 * @author Anatoliy Pokhresnyi
 */
object FeatureCollectionSerializer : GeoJsonObjectSerializer<FeatureCollection>(
    "features", ::decode, ::encode
)

/**
 * Десериализация объекта [FeatureCollection].
 *
 * @param element Содержимое объекта [FeatureCollection].
 * @return Объект [FeatureCollection].
 * @author Anatoliy Pokhresnyi
 */
private fun decode(element: JsonElement) = FeatureCollection(decode(element, MultiFeatureSerializer))

/**
 * Сериялизация объекта [FeatureCollection].
 *
 * @param obj Объект [FeatureCollection].
 * @param structure JSON объект.
 * @param descriptor Описание JSON объекта.
 * @param idx Индекс элемента в JSON объекте.
 * @author Anatoliy Pokhresnyi
 */
private fun encode(obj: FeatureCollection, structure: CompositeEncoder, descriptor: SerialDescriptor, idx: Int) =
    encode(structure, descriptor, idx, MultiFeatureSerializer, obj.features)
