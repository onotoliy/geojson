package ru.github.onotoliy.geojson.serializers

import ru.github.onotoliy.geojson.Feature
import ru.github.onotoliy.geojson.MultiFeature

/**
 * Kotlin сериализация/десериализация [MultiFeature].
 *
 * @author Anatoliy Pokhresnyi
 */
object MultiFeatureSerializer : GeoJsonCoordinateSerializer<MultiFeature, Feature>(
    "GeometryCollection", MultiFeature::coordinates, FeatureSerializer, ::MultiFeature
)