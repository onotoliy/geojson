package ru.github.onotoliy.geojson.serializers

import ru.github.onotoliy.geojson.MultiPolygon
import ru.github.onotoliy.geojson.MultiRing

object MultiPolygonSerializer :
    AbstractGeometrySerializer<MultiPolygon, MultiRing>("MultiPolygon",
        ::MultiPolygon, MultiRingSerializer
    )