package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.*
import ru.github.onotoliy.geojson.*

/**
 * Kotlin сериализация/десериализация [MultiGeometry].
 *
 * @author Anatoliy Pokhresnyi
 */
object MultiGeometrySerializer : GeoJsonCoordinateSerializer<MultiGeometry>(
    ::decode, ::encode
)

/**
 * Десериализация объекта [MultiGeometry].
 *
 * @param decoder Содержимое объекта [MultiGeometry].
 * @return Объект [MultiGeometry].
 * @author Anatoliy Pokhresnyi
 */
private fun decode(decoder: Decoder) = decoder.decode(GeometrySerializer.list).let(::MultiGeometry)

/**
 * Сериялизация объекта [LineString].
 *
 * @param obj Объект [LineString].
 * @param encoder JSON объект.
 * @author Anatoliy Pokhresnyi
 */
private fun encode(obj: MultiGeometry, encoder: Encoder) = encoder.encode(GeometrySerializer.list, obj.coordinates)