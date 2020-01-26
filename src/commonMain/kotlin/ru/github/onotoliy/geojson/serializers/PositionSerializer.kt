package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.serializer
import ru.github.onotoliy.geojson.Position

object PositionSerializer : GeoJsonCoordinateSerializer<Position, Double>(
    "Position", { listOf(it.x, it.y) }, Double.Companion.serializer(), { Position(it[0], it[1]) })