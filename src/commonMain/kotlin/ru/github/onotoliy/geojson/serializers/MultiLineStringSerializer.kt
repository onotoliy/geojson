package ru.github.onotoliy.geojson.serializers

import ru.github.onotoliy.geojson.MultiLineString
import ru.github.onotoliy.geojson.MultiPoint
import ru.github.onotoliy.geojson.Ring

/**
 * Kotlin сериализация/десериализация [MultiLineString].
 *
 * @author Anatoliy Pokhresnyi
 */
object MultiLineStringSerializer :
    AbstractGeometrySerializer<MultiLineString, Ring>("MultiLineString",
        ::MultiLineString, RingSerializer
    )