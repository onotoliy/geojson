package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.json.JsonElement
import ru.github.onotoliy.geojson.MultiLineString
import ru.github.onotoliy.geojson.MultiPoint
import ru.github.onotoliy.geojson.Ring

/**
 * Kotlin сериализация/десериализация [MultiLineString].
 *
 * @author Anatoliy Pokhresnyi
 */
object MultiLineStringSerializer : GeoJsonObjectSerializer<MultiLineString>(
    "coordinates", JsonElement::toMultiLineString, MultiLineString::stringify
)