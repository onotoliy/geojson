package ru.github.onotoliy.geojson.serializers

import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import ru.github.onotoliy.geojson.Feature
import ru.github.onotoliy.geojson.Geometry

object FeatureSerializer : GeoJsonObjectSerializer<Feature, Geometry>(
    "Feature", "geometry", Feature::geometry, GeometrySerializer
) {

    override fun deserialize(json: Json, element: JsonElement): Feature =
        Feature(json.fromJson(GeometrySerializer, element))
}