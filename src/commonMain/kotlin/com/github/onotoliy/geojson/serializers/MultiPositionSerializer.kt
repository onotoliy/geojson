package com.github.onotoliy.geojson.serializers

import com.github.onotoliy.geojson.MultiPosition
import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.decode
import kotlinx.serialization.encode
import kotlinx.serialization.list

/**
 * Kotlin сериализация/десериализация [MultiPosition].
 *
 * @author Anatoliy Pokhresnyi
 */
object MultiPositionSerializer : GeoJsonCoordinateSerializer<MultiPosition>(
    ::decode, ::encode
)

/**
 * Десериализация объекта [MultiPosition].
 *
 * @param decoder Содержимое объекта [MultiPosition].
 * @return Объект [MultiPosition].
 * @author Anatoliy Pokhresnyi
 */
private fun decode(decoder: Decoder) = decoder.decode(PositionSerializer.list).let(::MultiPosition)

/**
 * Сериялизация объекта [MultiPosition].
 *
 * @param obj Объект [MultiPosition].
 * @param encoder JSON объект.
 * @author Anatoliy Pokhresnyi
 */
private fun encode(obj: MultiPosition, encoder: Encoder) = encoder.encode(PositionSerializer.list, obj.coordinates)
