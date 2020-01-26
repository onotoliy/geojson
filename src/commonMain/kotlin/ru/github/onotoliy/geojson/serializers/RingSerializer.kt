package ru.github.onotoliy.geojson.serializers

import ru.github.onotoliy.geojson.MultiPosition
import ru.github.onotoliy.geojson.Ring


object RingSerializer : GeoJsonCoordinateSerializer<Ring, MultiPosition>(
    "Ring", Ring::coordinates, MultiPositionSerializer, ::Ring
)