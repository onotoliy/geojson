package ru.github.onotoliy.geojson.serializers

import ru.github.onotoliy.geojson.LineString
import ru.github.onotoliy.geojson.MultiPosition

object LineStringSerializer :
    AbstractGeometrySerializer<LineString, MultiPosition>("LineString",
        ::LineString, MultiPositionSerializer
    )