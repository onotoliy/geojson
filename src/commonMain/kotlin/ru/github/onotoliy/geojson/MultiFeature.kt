package ru.github.onotoliy.geojson

expect class MultiFeature(coordinates: List<Feature>) : GeoJsonCoordinateTyped<Feature> {
    val coordinates: List<Feature>
}