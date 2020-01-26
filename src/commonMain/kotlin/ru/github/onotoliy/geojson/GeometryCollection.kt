package ru.github.onotoliy.geojson

expect class GeometryCollection(geometries: MultiGeometry) : GeoJsonObject<MultiGeometry> {
    val geometries: MultiGeometry
}