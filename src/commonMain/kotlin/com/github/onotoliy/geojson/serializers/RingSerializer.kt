package com.github.onotoliy.geojson.serializers

import com.github.onotoliy.geojson.Ring
import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.decode
import kotlinx.serialization.encode
import kotlinx.serialization.list

/**
 * Kotlin сериализация/десериализация [Ring].
 *
 * @author Anatoliy Pokhresnyi
 */
object RingSerializer : GeoJsonCoordinateSerializer<Ring>(
    ::decode, ::encode
)

/**
 * Десериализация объекта [Ring].
 *
 * @param decoder Содержимое объекта [Ring].
 * @return Объект [Ring].
 * @author Anatoliy Pokhresnyi
 */
private fun decode(decoder: Decoder) = decoder.decode(MultiPositionSerializer.list).let(::Ring)

/**
 * Сериялизация объекта [Ring].
 *
 * @param obj Объект [Ring].
 * @param encoder JSON объект.
 * @author Anatoliy Pokhresnyi
 */
private fun encode(obj: Ring, encoder: Encoder) = encoder.encode(MultiPositionSerializer.list, obj.coordinates)
