package ru.github.onotoliy.geojson

expect class FeatureCollection(features: MultiFeature) : GeoJsonObject<MultiFeature> {
    val features: MultiFeature
}
