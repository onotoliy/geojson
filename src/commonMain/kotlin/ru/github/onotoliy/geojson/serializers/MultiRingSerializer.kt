package ru.github.onotoliy.geojson.serializers

import ru.github.onotoliy.geojson.MultiRing
import ru.github.onotoliy.geojson.Point
import ru.github.onotoliy.geojson.Ring

/**
 * Kotlin сериализация/десериализация [MultiRing].
 *
 * @author Anatoliy Pokhresnyi
 */
object MultiRingSerializer : GeoJsonCoordinateSerializer<MultiRing, Ring>(
    "MultiRing", MultiRing::coordinates, RingSerializer, ::MultiRing
)