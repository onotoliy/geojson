package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.json.JsonElement
import ru.github.onotoliy.geojson.Point

/**
 * Kotlin сериализация/десериализация [Point].
 *
 * @author Anatoliy Pokhresnyi
 */
object PointSerializer : GeoJsonObjectSerializer<Point>(
    "coordinates", JsonElement::toPoint, Point::stringify
)
