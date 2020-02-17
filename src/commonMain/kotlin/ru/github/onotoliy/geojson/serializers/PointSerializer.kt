package ru.github.onotoliy.geojson.serializers

import ru.github.onotoliy.geojson.Point
import ru.github.onotoliy.geojson.Polygon
import ru.github.onotoliy.geojson.Position

/**
 * Kotlin сериализация/десериализация [Point].
 *
 * @author Anatoliy Pokhresnyi
 */
object PointSerializer :
    AbstractGeometrySerializer<Point, Position>("Point", ::Point, PositionSerializer)