package ru.github.onotoliy.geojson

actual class FeatureCollection actual constructor(features: MultiFeature) : GeoJsonObject<MultiFeature>(features) {
    actual val features: MultiFeature
        get() = value
}