package com.github.onotoliy.geojson.serializers

import com.github.onotoliy.geojson.Position
import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.decode
import kotlinx.serialization.encode
import kotlinx.serialization.list
import kotlinx.serialization.serializer

/**
 * Kotlin сериализация/десериализация [Position].
 *
 * @author Anatoliy Pokhresnyi
 */
object PositionSerializer : GeoJsonCoordinateSerializer<Position>(
    ::decode, ::encode
)

/**
 * Десериализация объекта [Position].
 *
 * @param decoder Содержимое объекта [Position].
 * @return Объект [Position].
 * @author Anatoliy Pokhresnyi
 */
private fun decode(decoder: Decoder) = decoder.decode(Double.serializer().list).let {
    Position(it[0], it[1], if (it.size > 2) it[2] else null)
}

/**
 * Сериялизация объекта [Position].
 *
 * @param obj Объект [Position].
 * @param encoder JSON объект.
 * @author Anatoliy Pokhresnyi
 */
private fun encode(obj: Position, encoder: Encoder) {
    val coordinates: MutableList<Double> = mutableListOf(obj.longitude, obj.latitude)

    obj.altitude?.let(coordinates::add)

    encoder.encode(Double.serializer().list, coordinates)
}
