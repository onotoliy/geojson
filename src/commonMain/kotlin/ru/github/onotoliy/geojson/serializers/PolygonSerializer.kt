package ru.github.onotoliy.geojson.serializers

import ru.github.onotoliy.geojson.Polygon
import ru.github.onotoliy.geojson.Position
import ru.github.onotoliy.geojson.Ring

/**
 * Kotlin сериализация/десериализация [Polygon].
 *
 * @author Anatoliy Pokhresnyi
 */
object PolygonSerializer :
    AbstractGeometrySerializer<Polygon, Ring>("Polygon", ::Polygon, RingSerializer)