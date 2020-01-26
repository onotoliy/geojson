package ru.github.onotoliy.geojson.serializers

import ru.github.onotoliy.geojson.MultiLineString
import ru.github.onotoliy.geojson.Ring

object MultiLineStringSerializer :
    AbstractGeometrySerializer<MultiLineString, Ring>("MultiLineString",
        ::MultiLineString, RingSerializer
    )