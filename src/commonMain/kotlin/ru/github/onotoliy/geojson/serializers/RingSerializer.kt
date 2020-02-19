package ru.github.onotoliy.geojson.serializers

import ru.github.onotoliy.geojson.MultiPosition
import ru.github.onotoliy.geojson.Ring

/**
 * Kotlin сериализация/десериализация [Ring].
 *
 * @author Anatoliy Pokhresnyi
 */
object RingSerializer : GeoJsonCoordinateSerializer<Ring, MultiPosition>(
    Ring::coordinates, MultiPositionSerializer, ::Ring
)