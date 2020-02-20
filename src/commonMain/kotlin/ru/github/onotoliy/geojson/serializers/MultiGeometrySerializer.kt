package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.*
import ru.github.onotoliy.geojson.Geometry
import ru.github.onotoliy.geojson.MultiGeometry
import ru.github.onotoliy.geojson.MultiLineString
import ru.github.onotoliy.geojson.Ring

/**
 * Kotlin сериализация/десериализация [MultiGeometry].
 *
 * @author Anatoliy Pokhresnyi
 */
object MultiGeometrySerializer : GeoJsonCoordinateSerializer<MultiGeometry>(
    ::decode, ::encode
)

private fun decode(decoder: Decoder) = decoder.decode(GeometrySerializer.list).let(::MultiGeometry)
private fun encode(obj: MultiGeometry, encoder: Encoder) = encoder.encode(GeometrySerializer.list, obj.coordinates)