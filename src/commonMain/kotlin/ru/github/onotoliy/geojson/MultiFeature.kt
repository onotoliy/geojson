package ru.github.onotoliy.geojson

expect class MultiFeature(coordinates: List<Feature>) : GeoJsonCoordinateCommon<Feature> {
    val coordinates: List<Feature>
}