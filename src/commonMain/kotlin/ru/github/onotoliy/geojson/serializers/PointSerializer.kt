package ru.github.onotoliy.geojson.serializers

import ru.github.onotoliy.geojson.Point
import ru.github.onotoliy.geojson.Position

object PointSerializer :
    AbstractGeometrySerializer<Point, Position>("Point", ::Point, PositionSerializer)