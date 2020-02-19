package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.json.JsonElement
import ru.github.onotoliy.geojson.MultiPolygon
import ru.github.onotoliy.geojson.MultiPosition
import ru.github.onotoliy.geojson.MultiRing

/**
 * Kotlin сериализация/десериализация [MultiPolygon].
 *
 * @author Anatoliy Pokhresnyi
 */
object MultiPolygonSerializer : GeoJsonObjectSerializer<MultiPolygon>(
    "coordinates", JsonElement::toMultiPolygon, MultiPolygon::stringify
)
