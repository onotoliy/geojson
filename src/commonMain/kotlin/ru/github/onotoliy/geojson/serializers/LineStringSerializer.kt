package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.json.JsonElement
import ru.github.onotoliy.geojson.LineString
import ru.github.onotoliy.geojson.MultiPosition

/**
 * Kotlin сериализация/десериализация [LineString].
 *
 * @author Anatoliy Pokhresnyi
 */
object LineStringSerializer : GeoJsonObjectSerializer<LineString>(
    "coordinates", JsonElement::toLineString, LineString::stringify
)