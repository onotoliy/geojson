package ru.github.onotoliy.geojson.serializers

import ru.github.onotoliy.geojson.MultiPosition
import ru.github.onotoliy.geojson.Position

object MultiPositionSerializer : GeoJsonCoordinateSerializer<MultiPosition, Position>(
    "MultiPosition", MultiPosition::coordinates, PositionSerializer, ::MultiPosition
)