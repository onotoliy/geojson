package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.json.JsonElement
import ru.github.onotoliy.geojson.FeatureCollection

/**
 * Kotlin сериализация/десериализация [FeatureCollection].
 *
 * @author Anatoliy Pokhresnyi
 */
object FeatureCollectionSerializer : GeoJsonObjectSerializer<FeatureCollection>(
    "features", JsonElement::toFeatureCollection, FeatureCollection::stringify
)