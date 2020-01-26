package ru.github.onotoliy.geojson.serializers

import ru.github.onotoliy.geojson.Feature
import ru.github.onotoliy.geojson.MultiFeature

object MultiFeatureSerializer : GeoJsonCoordinateSerializer<MultiFeature, Feature>(
    "GeometryCollection", MultiFeature::coordinates, FeatureSerializer, ::MultiFeature
)