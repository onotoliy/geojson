package com.github.onotoliy.geojson.serializers

import com.github.onotoliy.geojson.MultiRing
import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.decode
import kotlinx.serialization.encode
import kotlinx.serialization.list

/**
 * Kotlin сериализация/десериализация [MultiRing].
 *
 * @author Anatoliy Pokhresnyi
 */
object MultiRingSerializer : GeoJsonCoordinateSerializer<MultiRing>(
    ::decode, ::encode
)

/**
 * Десериализация объекта [MultiRing].
 *
 * @param decoder Содержимое объекта [MultiRing].
 * @return Объект [MultiRing].
 * @author Anatoliy Pokhresnyi
 */
private fun decode(decoder: Decoder) = decoder.decode(RingSerializer.list).let(::MultiRing)

/**
 * Сериялизация объекта [MultiRing].
 *
 * @param obj Объект [MultiRing].
 * @param encoder JSON объект.
 * @author Anatoliy Pokhresnyi
 */
private fun encode(obj: MultiRing, encoder: Encoder) = encoder.encode(RingSerializer.list, obj.coordinates)
