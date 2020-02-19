package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.json.JsonElement
import ru.github.onotoliy.geojson.MultiPoint
import ru.github.onotoliy.geojson.MultiPolygon
import ru.github.onotoliy.geojson.MultiPosition

/**
 * Kotlin сериализация/десериализация [MultiPoint].
 *
 * @author Anatoliy Pokhresnyi
 */
object MultiPointSerializer : GeoJsonObjectSerializer<MultiPoint>(
    "coordinates", JsonElement::toMultiPoint, MultiPoint::stringify
)