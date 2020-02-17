package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonArray
import kotlinx.serialization.json.JsonElement
import ru.github.onotoliy.geojson.Feature
import ru.github.onotoliy.geojson.FeatureCollection
import ru.github.onotoliy.geojson.MultiFeature

/**
 * Kotlin сериализация/десериализация [FeatureCollection].
 *
 * @author Anatoliy Pokhresnyi
 */
object FeatureCollectionSerializer : GeoJsonObjectSerializer<FeatureCollection, MultiFeature>(
    "FeatureCollection", "features", FeatureCollection::features, MultiFeatureSerializer
) {

    override fun deserialize(json: Json, element: JsonElement): FeatureCollection =
        FeatureCollection(MultiFeature((element as JsonArray).content.map {
            json.parse(
                FeatureSerializer,
                it.toString()
            )
        }))
}