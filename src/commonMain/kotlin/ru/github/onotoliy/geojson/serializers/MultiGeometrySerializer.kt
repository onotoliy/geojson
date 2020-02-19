package ru.github.onotoliy.geojson.serializers

import ru.github.onotoliy.geojson.Geometry
import ru.github.onotoliy.geojson.MultiGeometry
import ru.github.onotoliy.geojson.MultiLineString

/**
 * Kotlin сериализация/десериализация [MultiGeometry].
 *
 * @author Anatoliy Pokhresnyi
 */
object MultiGeometrySerializer : GeoJsonCoordinateSerializer<MultiGeometry, Geometry>(
    MultiGeometry::coordinates, GeometrySerializer, ::MultiGeometry
)