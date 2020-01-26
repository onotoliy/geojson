package ru.github.onotoliy.geojson.serializers

import ru.github.onotoliy.geojson.MultiPoint
import ru.github.onotoliy.geojson.MultiPosition

object MultiPointSerializer :
    AbstractGeometrySerializer<MultiPoint, MultiPosition>("MultiPoint",
        ::MultiPoint, MultiPositionSerializer
    )