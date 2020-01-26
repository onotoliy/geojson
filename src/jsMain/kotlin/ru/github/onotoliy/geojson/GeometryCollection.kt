package ru.github.onotoliy.geojson

actual class GeometryCollection actual constructor(geometries: MultiGeometry) :
    GeoJsonObject<MultiGeometry>(geometries) {
    actual val geometries: MultiGeometry
        get() = value
}