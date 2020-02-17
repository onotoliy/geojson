package ru.github.onotoliy.geojson.serializers

import ru.github.onotoliy.geojson.LineString
import ru.github.onotoliy.geojson.MultiPosition

/**
 * Kotlin сериализация/десериализация [LineString].
 *
 * @author Anatoliy Pokhresnyi
 */
object LineStringSerializer :
    AbstractGeometrySerializer<LineString, MultiPosition>("LineString",
        ::LineString, MultiPositionSerializer
    )