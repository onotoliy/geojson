package ru.github.onotoliy.geojson

expect open class Position(x: Double, y: Double) : PositionTyped, GeometryCoordinate {
    val x: Double
    val y: Double
}