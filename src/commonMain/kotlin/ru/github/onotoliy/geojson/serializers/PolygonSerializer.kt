package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.json.JsonElement
import ru.github.onotoliy.geojson.Polygon

/**
 * Kotlin сериализация/десериализация [Polygon].
 *
 * @author Anatoliy Pokhresnyi
 */
object PolygonSerializer : GeoJsonObjectSerializer<Polygon>(
    "coordinates", JsonElement::toPolygon, Polygon::stringify
)
