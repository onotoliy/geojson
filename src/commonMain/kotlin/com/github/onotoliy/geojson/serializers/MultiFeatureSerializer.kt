package com.github.onotoliy.geojson.serializers

import com.github.onotoliy.geojson.LineString
import com.github.onotoliy.geojson.MultiFeature
import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.decode
import kotlinx.serialization.encode
import kotlinx.serialization.list

/**
 * Kotlin сериализация/десериализация [MultiFeature].
 *
 * @author Anatoliy Pokhresnyi
 */
object MultiFeatureSerializer : GeoJsonCoordinateSerializer<MultiFeature>(
    ::decode, ::encode
)

/**
 * Десериализация объекта [MultiFeature].
 *
 * @param decoder Содержимое объекта [MultiFeature].
 * @return Объект [MultiFeature].
 * @author Anatoliy Pokhresnyi
 */
private fun decode(decoder: Decoder) = decoder.decode(FeatureSerializer.list).let(::MultiFeature)

/**
 * Сериялизация объекта [LineString].
 *
 * @param obj Объект [LineString].
 * @param encoder JSON объект.
 * @author Anatoliy Pokhresnyi
 */
private fun encode(obj: MultiFeature, encoder: Encoder) = encoder.encode(FeatureSerializer.list, obj.coordinates)
