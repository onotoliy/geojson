package ru.github.onotoliy.geojson.serializers

import ru.github.onotoliy.geojson.MultiPolygon
import ru.github.onotoliy.geojson.MultiPosition
import ru.github.onotoliy.geojson.MultiRing

/**
 * Kotlin сериализация/десериализация [MultiPolygon].
 *
 * @author Anatoliy Pokhresnyi
 */
object MultiPolygonSerializer :
    AbstractGeometrySerializer<MultiPolygon, MultiRing>("MultiPolygon",
        ::MultiPolygon, MultiRingSerializer
    )