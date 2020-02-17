package ru.github.onotoliy.geojson.serializers

import ru.github.onotoliy.geojson.MultiPoint
import ru.github.onotoliy.geojson.MultiPolygon
import ru.github.onotoliy.geojson.MultiPosition

/**
 * Kotlin сериализация/десериализация [MultiPoint].
 *
 * @author Anatoliy Pokhresnyi
 */
object MultiPointSerializer :
    AbstractGeometrySerializer<MultiPoint, MultiPosition>("MultiPoint",
        ::MultiPoint, MultiPositionSerializer
    )