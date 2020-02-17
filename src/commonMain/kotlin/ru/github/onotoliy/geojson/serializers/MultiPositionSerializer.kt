package ru.github.onotoliy.geojson.serializers

import ru.github.onotoliy.geojson.MultiPosition
import ru.github.onotoliy.geojson.MultiRing
import ru.github.onotoliy.geojson.Position

/**
 * Kotlin сериализация/десериализация [MultiPosition].
 *
 * @author Anatoliy Pokhresnyi
 */
object MultiPositionSerializer : GeoJsonCoordinateSerializer<MultiPosition, Position>(
    "MultiPosition", MultiPosition::coordinates, PositionSerializer, ::MultiPosition
)