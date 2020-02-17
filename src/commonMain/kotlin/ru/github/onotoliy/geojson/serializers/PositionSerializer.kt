package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.serializer
import ru.github.onotoliy.geojson.Position
import ru.github.onotoliy.geojson.Ring

/**
 * Kotlin сериализация/десериализация [Position].
 *
 * @author Anatoliy Pokhresnyi
 */
object PositionSerializer : GeoJsonCoordinateSerializer<Position, Double>(
    "Position", { listOf(it.x, it.y) }, Double.Companion.serializer(), { Position(it[0], it[1]) })