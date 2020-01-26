package ru.github.onotoliy.geojson


actual class Feature actual constructor(geometry: Geometry) : GeoJsonObject<Geometry>(geometry) {
    actual val geometry: Geometry
        get() = value
}