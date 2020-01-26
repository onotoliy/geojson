package ru.github.onotoliy.geojson.serializers

import ru.github.onotoliy.geojson.Geometry
import ru.github.onotoliy.geojson.MultiGeometry

object MultiGeometrySerializer : GeoJsonCoordinateSerializer<MultiGeometry, Geometry>(
    "GeometryCollection", MultiGeometry::coordinates, GeometrySerializer, ::MultiGeometry
)