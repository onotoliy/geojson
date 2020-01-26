package ru.github.onotoliy.geojson

expect class Feature constructor(geometry: Geometry) : GeoJsonObject<Geometry> {
    val geometry: Geometry
}