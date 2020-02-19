package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.json.JsonElement
import ru.github.onotoliy.geojson.Feature

/**
 * Kotlin сериализация/десериализация [Feature].
 *
 * @author Anatoliy Pokhresnyi
 */
object FeatureSerializer : GeoJsonObjectSerializer<Feature>(
    "geometry", JsonElement::toFeature, Feature::stringify
)