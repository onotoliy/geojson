package ru.github.onotoliy.geojson.serializers

import ru.github.onotoliy.geojson.Polygon
import ru.github.onotoliy.geojson.Ring

object PolygonSerializer :
    AbstractGeometrySerializer<Polygon, Ring>("Polygon", ::Polygon, RingSerializer)