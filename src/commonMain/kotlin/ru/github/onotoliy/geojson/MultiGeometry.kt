package ru.github.onotoliy.geojson

expect class MultiGeometry(coordinates: List<Geometry>) : MultiGeometryTyped, GeometryCoordinate {
    val coordinates: List<Geometry>
}